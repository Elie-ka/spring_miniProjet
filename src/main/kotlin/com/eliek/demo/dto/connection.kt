package com.eliek.demo.dto

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class Userconnection(@NotBlank var username:String, @NotBlank @Size(min = 6) var password:String)
