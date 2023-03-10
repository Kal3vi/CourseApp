package com.example.courseapp.data.repository

import com.example.courseapp.data.entity.Category
import com.example.courseapp.data.room.CategoryDao
import kotlinx.coroutines.flow.Flow

class CategoryRepository(
    private val categoryDao: CategoryDao
) {
    fun categories(): Flow<List<Category>> = categoryDao.categories()
    fun getCategoryWithId(categoryId: Long): Category? = categoryDao.getCategoryWithId(categoryId)

    /**
     * Add a category to the database if it does not exist
     *
     * @return the id of the newly added/created category
     */
    suspend fun addCategory(category: Category): Long {
        return when (val local = categoryDao.getCategoryWithName(category.name)) {
            null -> categoryDao.insert(category)
            else -> local.id
        }
    }
}