package com.briceb.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query( "SELECT * FROM User")
    fun getUsers(): MutableList<User>

    @Query( "SELECT * FROM User WHERE id = :id")
    fun getUserById(id: Int): User

    @Insert
    fun insert(vararg userEntity: User)

    @Query( "DELETE FROM User")
    fun deleteAll()

}