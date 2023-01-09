package com.eliek.demo.service

import com.eliek.demo.entity.Post
import com.eliek.demo.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PostService @Autowired constructor(private  var postRepository: PostRepository) {

    fun getPosts(): List<Post> {
        return postRepository.findAll()
    }

    fun getPostByUserId(userId:Long):List<Post> = postRepository.findAllByUserId(userId)


    fun getOne(id:Long):Post = postRepository.findById(id).orElseThrow { IllegalArgumentException("Post no found") }

    fun savePost(post: Post):Post{
        return postRepository.save(post)
    }

    fun updatePost(id: Long, postInput:Post):Post{
        val postNew:Post = getOne(id)
        postNew.content = postInput.content
        return postRepository.save(postNew)
    }

    fun deletePost(id: Long):String{
        val postDelete = getOne(id)
        postRepository.delete(postDelete)
        return "Post deleted"
    }




}