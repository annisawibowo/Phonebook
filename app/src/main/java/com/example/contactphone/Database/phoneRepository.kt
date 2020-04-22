package com.example.contactphone.Database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class phoneRepository(application: Application) {
    private var phoneDao: phoneDao
    private var allphones: LiveData<List<phone>>

    init {
        val database: PhoneDatabase = PhoneDatabase.getInstance(
            application.applicationContext
        )!!
        phoneDao = database.phoneDao()
        allphones = phoneDao.getAllNotes()
    }
    fun insert(phone: phone) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(phoneDao).execute(phone)
    }
    fun update(phone: phone) {
        val updateNoteAsyncTask = UpdateNoteAsyncTask(phoneDao).execute(phone)
    }
    fun delete(phone: phone) {
        val deleteNoteAsyncTask = DeletephoneAsyncTask(phoneDao).execute(phone)
    }
    fun deleteAllphones() {
        val deleteAllphonesAsyncTask = deleteAllphonesAsyncTask(
            phoneDao         ).execute()
    }
    fun getAllphones(): LiveData<List<phone>> {
        return allphones
    }
    companion object {
        private class InsertNoteAsyncTask(phoneDao: phoneDao) : AsyncTask<phone, Unit, Unit>() {
            val phoneDao = phoneDao
            override fun doInBackground(vararg p0: phone?) {
                phoneDao.insert(p0[0]!!)
            }
        }
        private class UpdateNoteAsyncTask(phoneDao: phoneDao) : AsyncTask<phone, Unit, Unit>() {
            val phoneDao = phoneDao

            override fun doInBackground(vararg p0: phone?) {
                phoneDao.update(p0[0]!!)
            }
        }
        private class DeletephoneAsyncTask(phoneDao: phoneDao) : AsyncTask<phone, Unit, Unit>() {
            val phoneDao = phoneDao
            override fun doInBackground(vararg p0: phone?) {
                phoneDao.delete(p0[0]!!)
            }
        }
        private class deleteAllphonesAsyncTask(phoneDao: phoneDao) : AsyncTask<Unit, Unit, Unit>() {
            val phoneDao = phoneDao

            override fun doInBackground(vararg p0: Unit?) {
                phoneDao.deleteAllNotes()
            }
        }
    }
    }


