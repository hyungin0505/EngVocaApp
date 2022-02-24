package com.temporary.englishvocalist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface VocaDao {
    @Query("SELECT * FROM tb_voca")
    fun getAll(): List<Voca>

    @Insert
    fun insertAll(vararg voca: Voca)

    @Delete
    fun delete(voca: Voca)
}