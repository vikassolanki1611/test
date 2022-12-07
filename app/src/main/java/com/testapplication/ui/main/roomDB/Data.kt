package com.example.roomclass.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "User Info")
 data class Data(

    @ColumnInfo(name = "id")
    @PrimaryKey
    val id: Int?,

    @ColumnInfo(name = "userId")
    val userId:Int?,

    @ColumnInfo(name = "title")
    val title: String?,

    @ColumnInfo(name = "body")
    var body: String?


 ):Parcelable