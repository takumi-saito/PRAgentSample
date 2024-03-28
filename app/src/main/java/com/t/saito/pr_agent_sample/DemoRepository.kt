package com.t.saito.pr_agent_sample

class DemoRepository {

    val demoItems = mutableListOf<String>()

    fun addAllItem(items: List<String>): List<String> {
        demoItems.addAll(items)
        return demoItems
    }

    fun addItem(item: String): List<String> {
        demoItems.add(item)
        return demoItems
    }

    fun firstItem(): String? {
        return demoItems.firstOrNull()
    }

    fun lastItem(): String? {
        return demoItems.lastOrNull()
    }

    fun clear() {
        demoItems.clear()
    }
}