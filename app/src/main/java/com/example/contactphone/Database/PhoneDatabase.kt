package com.example.contactphone.Database

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [phone::class], version = 1)
abstract class PhoneDatabase : RoomDatabase() {
    abstract fun phoneDao(): phoneDao
    companion object {
        private var instance: PhoneDatabase? = null
        fun getInstance(context: Context): PhoneDatabase? {
            if (instance == null) {
                synchronized(PhoneDatabase::class) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            PhoneDatabase::class.java, "phone_database"  )
                        .fallbackToDestructiveMigration() .addCallback(roomCallback)
                    .build()
                }
            }
            return instance
        }
        fun destroyInstance() {
            instance = null
        }
        private val roomCallback = object :
            RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }

    class PopulateDbAsyncTask(db: PhoneDatabase?) : AsyncTask<Unit, Unit, Unit>() {
        private val noteDao = db?.phoneDao()

        override fun doInBackground(vararg p0: Unit?) {
            noteDao?.insert(phone("Annisa Raudya Wibowo", "Teman SMP", "082264771633", "Annisa.raudya98@gmail.com"))

        }
    }
}


