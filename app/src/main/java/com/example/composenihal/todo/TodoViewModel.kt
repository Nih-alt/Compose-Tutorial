package com.example.composenihal.todo

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel
@Inject constructor(private val repository: TodoRepository) : ViewModel() {

    val response: MutableState<List<Todo>> = mutableStateOf(listOf())

    fun insert(todo: Todo) = viewModelScope.launch {
        repository.insert(todo)
    }

    fun getAllTodos() = repository.getAllTodos()
}