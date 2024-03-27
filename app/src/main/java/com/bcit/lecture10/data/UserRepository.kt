package com.bcit.lecture10.data

class UserRepository(private val userDao: UserDAO) {

    // any business logic would go here

    fun insertEntity(user: LocalUser) {
        userDao.add(user)
    }


    fun getAll(): List<LocalUser> {
        return userDao.getAll()
    }
}