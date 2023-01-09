package com.eliek.demo.controller

import com.eliek.demo.entity.Post
import com.eliek.demo.service.PostService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
class PostController @Autowired constructor(private var postService: PostService) {

    @GetMapping("/posts")
    fun getPostList():List<Post> = postService.getPosts()

    @GetMapping("/posts/by-user/{userId}")
    fun getPostByUserId(@PathVariable userId:Long):List<Post> = postService.getPostByUserId(userId)

    @GetMapping("/posts/{id}")
    fun getPost(@PathVariable id:Long):Post = postService.getOne(id)

    @PostMapping("/posts")
    fun createPost(@RequestBody @Valid post: Post):Post = postService.savePost(post)

    @PutMapping("/posts/{id}")
    fun updatePost(@PathVariable @Valid id: Long, @RequestBody post: Post):Post = postService.updatePost(id,post)

    @DeleteMapping("/posts/{id}")
    fun deletePost(@PathVariable id: Long):String = postService.deletePost(id)
}