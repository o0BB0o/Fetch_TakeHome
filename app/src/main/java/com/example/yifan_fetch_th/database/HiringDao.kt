package com.example.yifan_fetch_th.database
import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface HiringDao {
    // Simple Dao for the hiring.json file.
    // Just supports insert, delete and find all results with no null names.
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(candidate: Candidates)

    @Delete
    fun delete(candidate: Candidates)

    @Query("SELECT * " +
            "FROM Hiring " +
            "WHERE NAME <> \"null\" AND NAME <> ''" +
            // "GROUP BY listId " + Do not need group by listId here since ORDER BY could do the job.
            "ORDER BY listId, name * 1")
    fun showResults(): LiveData<List<Candidates>>
}