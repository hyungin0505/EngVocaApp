package com.temporary.englishvocalist

import androidx.room.*

@Entity(tableName = "tb_voca")
data class Voca(
    @PrimaryKey(autoGenerate = true) val id: Long,
    var eng: String,
    var kor: String
)