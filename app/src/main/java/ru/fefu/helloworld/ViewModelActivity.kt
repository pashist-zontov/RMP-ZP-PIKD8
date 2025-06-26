package ru.fefu.helloworld

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModelActivity(private val repository: Repository): ViewModel() {
    val allActions: LiveData<List<EntityActivity>> = repository.getAllActions()

    fun insert(activity: EntityActivity) = viewModelScope.launch {
        repository.insertDat(activity)
    }

    suspend fun getActionById(actId: Int): EntityActivity? {
        return repository.getActionById(actId)
    }

    class Factory(private val repository: Repository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModelActivity(repository) as T
        }
    }
}