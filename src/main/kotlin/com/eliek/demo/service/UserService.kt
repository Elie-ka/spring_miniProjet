package com.eliek.demo.service

import com.eliek.demo.dto.Userconnection
import com.eliek.demo.entity.User
import com.eliek.demo.repository.UserRepository
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(private var userRepository: UserRepository) {

    fun getUsers(): List<User> =  userRepository.findAll()

    fun getOne(id:Long):User = userRepository.findById(id).orElseThrow{IllegalArgumentException("User with id =$id was not found")}

    fun saveUser(user: User):User = userRepository.save(user)

    fun updateUser(id: Long,userInput:User):User{

        val userFound = getOne(id)

        userFound.username = userInput.username
        userFound.profession = userInput.profession
        userFound.ville = userInput.ville
        userFound.pays = userInput.pays
        userFound.fullname = userInput.fullname
        @JsonIgnore
        userFound.password = userInput.password
        //userFound.posts = userInput.posts

        return userRepository.save(userFound)
    }

    fun deleteUser(id:Long):String{
        val userFound = getOne(id)

        userRepository.delete(userFound)
        return  "user deleted"
    }

    fun login(userData: Userconnection): User {
        val user = userRepository.findByUsername(userData.username).orElseThrow({IllegalArgumentException("User not found")})

        if (user.password == userData.password){
            return user
        }
        throw IllegalArgumentException("username not correct")
    }
}