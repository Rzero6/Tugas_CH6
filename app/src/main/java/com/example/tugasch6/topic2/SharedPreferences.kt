package com.example.tugasch6.topic2

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences (private val context: Context){
    private var sharedPreferences = context.getSharedPreferences("SHARED_PREFS",Context.MODE_PRIVATE)
    private val LOGIN = "LOGIN"
    private val USERNAME = "USERNAME"
    private val PASSWORD = "PASSWORD"

    var login: Boolean
        get() {
            return sharedPreferences.getBoolean(LOGIN,false)
        }
        set(value) {
            sharedPreferences.edit().putBoolean(LOGIN,value).apply()
        }
    var username: String?
        get() {
            return sharedPreferences.getString(USERNAME,"")
        }
        set(value) {
            sharedPreferences.edit().putString(USERNAME,value).apply()
        }
    var password: String?
        get() {
            return sharedPreferences.getString(PASSWORD,"")
        }
        set(value) {
            sharedPreferences.edit().putString(PASSWORD,value).apply()
        }
    fun clearSharedPrefs(){
        sharedPreferences.edit().clear().apply()
    }
}