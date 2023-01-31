package com.example.courseapp.ui.home

import androidx.compose.ui.text.style.TextDecoration.Companion.combine
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.courseapp.data.entity.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){
    private val _state = MutableStateFlow(HomeViewState())
    private val _selectedCategory = MutableStateFlow<Category?>(null)

    val state: StateFlow<HomeViewState>
        get() = _state

    fun onCategorySelected(category: Category) {
        _selectedCategory.value = category
    }

    init {
        val categories = MutableStateFlow<List<Category>>(
            mutableListOf(
                Category(1, "Food"),
                Category(2, "Health"),
                Category(3, "Savings"),
                Category(4, "Drinks"),
                Category(5, "Clothing"),
                Category(6, "Investment"),
                Category(7, "Travel"),
                Category(8, "Fuel"),
                Category(9, "Repairs"),
                Category(10, "Coffee")
            )
        )

        viewModelScope.launch {
            combine(
                categories.onEach { category ->
                    if (categories.value.isNotEmpty() && _selectedCategory.value == null) {
                        _selectedCategory.value = category[0] (-1.24.37)
                    }
                }
            )
        }
    }
}

data class HomeViewState(
    val categories: List<Category> = emptyList(),
    val selectedCategory: Category? = null
)