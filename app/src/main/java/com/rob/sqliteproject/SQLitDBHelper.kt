package com.rob.sqliteproject

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLitDBHelper(context: Context) : SQLiteOpenHelper(
    context, DBase.DATABASE_NAME,
    null, DBase.DATABASE_VERSION

) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DBase.CREAT_TABLE)

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DBase.UPGRADE_TABLE)
        onCreate(db)
    }

}