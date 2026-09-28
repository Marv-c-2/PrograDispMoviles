package edu.ucb.project.di

import android.content.Context
import org.koin.core.context.startKoin

fun initKoinAndroid(context: Context) {
    startKoin {
        modules(
            sharedModule()
        )
    }
}