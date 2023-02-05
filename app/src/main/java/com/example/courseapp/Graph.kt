package com.example.courseapp

import android.content.Context
import androidx.room.Room
import com.example.courseapp.data.repository.CategoryRepository
import com.example.courseapp.data.repository.PaymentRepository
import com.example.courseapp.data.room.MobileCompDatabase

/**
 * A simple singleton dependency graph
 *
 * For a real app, please use something like Koin/Dagger/Hilt instead
 */
object Graph {
    lateinit var database: MobileCompDatabase

    lateinit var appContext: Context

    val categoryRepository by lazy {
        CategoryRepository(
            categoryDao = database.categoryDao()
        )
    }

    val paymentRepository by lazy {
        PaymentRepository(
            paymentDao = database.paymentDao()
        )
    }

    fun provide(context: Context) {
        appContext = context
        database = Room.databaseBuilder(context, MobileCompDatabase::class.java, "mcData.db")
            .fallbackToDestructiveMigration() // don't use this in production app
            .build()
    }
}