package com.eliek.demo.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.sql.Timestamp
import javax.persistence.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Entity
@Table(name = "publication")
data class Post (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id:Long? = null,
    @field: NotBlank(message="Content empty")
    var content: String,
    @Column(name = "user_id")
    var  userId:Long,
    @ManyToOne
    @JoinColumn(insertable = false, updatable = false)
    @JsonIgnore
    val user: User? = null,
    @CreationTimestamp
    var createdAt:Timestamp? = null,
    @UpdateTimestamp
    var updatedAt:Timestamp? = null,

)