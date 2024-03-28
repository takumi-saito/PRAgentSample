package com.t.saito.pr_agent_sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.t.saito.pr_agent_sample.ui.DemoScreen
import com.t.saito.pr_agent_sample.ui.theme.PragentsampleTheme

class MainActivity : ComponentActivity() {

    private val demoViewModel by viewModels<DemoViewModel> {
        DemoViewModelFactory(
            DemoUseCase(
                DemoRepository()
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PragentsampleTheme {
                // A surface container using the 'background' color from the theme
                val flag by demoViewModel.pageFlag.collectAsState(false)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    if(flag) {
                        DemoScreen(
                            demoViewModel = demoViewModel,
                        )
                    } else {
                        Greeting(name = "Android", onClick = {
                            demoViewModel.onClickPageSwitch()
                        })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    onClick: () -> Unit = {}
) {
    Button(
        onClick = onClick,
        modifier = Modifier.wrapContentSize()
    ) {
        Text(
            text = "Hello $name!",
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PragentsampleTheme {
        Greeting(name = "Android")
    }
}