package com.example.contactphone

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.contactphone.Database.phone
import com.example.contactphone.Database.phoneRepository

class phoneViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: phoneRepository = phoneRepository(application)
    private var allphones: LiveData<List<phone>> = repository.getAllphones()
    fun insert(phone: phone) {
        repository.insert(phone)
    }
    fun update(phone: phone) {
        repository.update(phone)
    }
    fun delete(phone: phone) {
        repository.delete(phone)
    }
    fun deleteAllphones() {
        repository.deleteAllphones()
    }
    fun getAllphones(): LiveData<List<phone>> {
        return allphones
    }
}