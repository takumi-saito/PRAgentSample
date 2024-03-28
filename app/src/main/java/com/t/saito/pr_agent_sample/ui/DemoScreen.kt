package com.t.saito.pr_agent_sample.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.t.saito.pr_agent_sample.DemoViewModel

@Composable
fun DemoScreen(
    demoViewModel: DemoViewModel,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Button(onClick = { demoViewModel.onClickAddItem() }) {
            Text("Add Item")
        }
        Button(onClick = { demoViewModel.onClickAddAllItems() }) {
            Text("Add All Items")
        }
        Button(onClick = { demoViewModel.onClickClear() }) {
            Text("Clear")
        }
        Button(onClick = { demoViewModel.onClickFirstItem() }) {
            Text("First Item")
        }
        Button(onClick = { demoViewModel.onClickLastItem() }) {
            Text("Last Item")
        }
        Button(onClick = { demoViewModel.onClickPageSwitch() }) {
            Text("back")
        }
    }
}