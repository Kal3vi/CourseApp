package com.example.courseapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.courseapp.data.entity.Category
import com.example.courseapp.data.entity.Payment

/**
 * The [RoomDatabase] for this app
 */
@Database(
    entities = [Category::class, Payment::class],
    version = 2,
    exportSchema = false
)
abstract class MobileCompDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun paymentDao(): PaymentDao
}