package com.t.saito.pr_agent_sample

class DemoUseCase(
    private val repository: DemoRepository
) {

    fun addAllItem(items: List<String>): List<String> {
        return repository.addAllItem(items)
    }
    fun addItem(item: String): List<String> {
        return repository.addItem(item)
    }

    fun firstItem(): String? {
        return repository.firstItem()
    }

    fun lastItem(): String? {
        return repository.lastItem()
    }

    fun clear() {
        repository.clear()
    }
}