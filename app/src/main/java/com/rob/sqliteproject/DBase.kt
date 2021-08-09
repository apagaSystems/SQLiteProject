package com.rob.sqliteproject

import android.provider.BaseColumns


    object DBase : BaseColumns { // ID

        const val DATABASE_NAME = "StudentDB.db"
        const val DATABASE_VERSION = 1

        const val TABLE_NAME = "students"  // table name
        const val COLUMN_NAME_NAME= "name"
        const val COLUMN_NAME_SURNAME = "surname"

        const val CREAT_TABLE= "CREATE TABLE IF NOT EXISTS ${TABLE_NAME} (" +
        "${BaseColumns._ID} INTEGER PRIMARY KEY," +
        "${DBase.COLUMN_NAME_NAME} TEXT," +
        "${DBase.COLUMN_NAME_SURNAME} TEXT)"

        const val UPGRADE_TABLE = "DROP TABLE IF EXISTS ${DBase.TABLE_NAME}"
    }
