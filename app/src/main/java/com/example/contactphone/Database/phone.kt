package com.example.contactphone.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Phone_table")
data class phone(
    var Nama: String,
    var description: String,
    var Notelp: String,
    var email: String)
{   @PrimaryKey(autoGenerate = true)
var id: Int = 0 }