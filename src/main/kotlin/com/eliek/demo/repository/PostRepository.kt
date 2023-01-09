package com.eliek.demo.repository

import com.eliek.demo.entity.Post
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PostRepository:JpaRepository<Post,Long> {

    fun findAllByUserId(userId:Long):List<Post>

}