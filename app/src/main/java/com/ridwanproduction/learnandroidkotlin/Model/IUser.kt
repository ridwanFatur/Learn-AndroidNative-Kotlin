package com.ridwanproduction.learnandroidkotlin.Model

interface IUser {
    fun getEmail(): String?
    fun getPassword(): String?
    fun isValid(): Int
}