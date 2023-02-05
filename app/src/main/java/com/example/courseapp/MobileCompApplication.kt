package com.example.courseapp

import android.app.Application

/**
 * This application class sets up our dependency [Graph] with a context
 */
class MobileCompApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Graph.provide(this)
    }
}