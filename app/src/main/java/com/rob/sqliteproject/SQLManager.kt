package com.rob.sqliteproject

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase


class SQLManager(context: Context) {
    val sqliteDBHelper = SQLitDBHelper(context)
    var db: SQLiteDatabase? = null
    fun openDB() {
        db = sqliteDBHelper.writableDatabase

    }

    fun insertDB(name: String, surname: String) {
        val DBvalues = ContentValues().apply {
            put(DBase.COLUMN_NAME_NAME, name)
            put(DBase.COLUMN_NAME_SURNAME, surname)
        }

        db?.insert(DBase.TABLE_NAME, null, DBvalues)

    }

    fun selectDB(): ArrayList<String> {
        val dataList = ArrayList<String>()
        val cursor = db?.query(
            DBase.TABLE_NAME, null, null,
            null, null, null, null
        )

        while (cursor?.moveToNext()!!) {
            val data = cursor?.getString(cursor.getColumnIndex(DBase.COLUMN_NAME_NAME))
            dataList.add(data.toString())
        }
        cursor.close()
        return dataList

    }

    fun closeDB() {
        sqliteDBHelper.close()
    }

}