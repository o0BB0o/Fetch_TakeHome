package com.example.yifan_fetch_th.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Room
import java.util.concurrent.Executors

class HiringBuilder private constructor(context: Context) {
    companion object {
        private var INSTANCE: HiringBuilder? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = HiringBuilder(context)
            }
        }

        fun get(): HiringBuilder {
            return INSTANCE
                ?: throw IllegalStateException("Hiring_Builder must be initialized.")
        }
    }

    private val database: HiringDatabase = Room.databaseBuilder(
        context.applicationContext,
        HiringDatabase:: class.java,
        "hiring_database"
    ).fallbackToDestructiveMigration()
        .build()

    private val hiringDao = database.hiringDao()
    private val executor = Executors.newSingleThreadExecutor()

    fun insert(candidates: Candidates) {
        executor.execute {
            hiringDao.insert(candidates)
        }
    }

    fun delete(candidates: Candidates) {
        executor.execute {
            hiringDao.delete(candidates)
        }
    }

    fun showResults(): LiveData<List<Candidates>> = hiringDao.showResults()
}