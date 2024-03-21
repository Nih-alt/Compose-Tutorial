package com.example.composenihal.todo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composenihal.utils.timberLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject constructor(private val repository: TodoRepository) : ViewModel() {

    private val mTag = "TodoViewModel"
    val response: MutableState<List<Todo>> = mutableStateOf(listOf())

    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }

    init {
        getAllTodos()
    }

    fun getAllTodos() = viewModelScope.launch {
        repository.getAllTodos()
            .catch { e ->
                timberLog(mTag, "Exception: ${e.message}")
            }.collect {
                response.value = it
            }
    }

}