package com.example.yifan_fetch_th.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Candidates::class], version = 1, exportSchema = false)
abstract class HiringDatabase : RoomDatabase() {
    abstract fun hiringDao(): HiringDao
}

val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
    }
}