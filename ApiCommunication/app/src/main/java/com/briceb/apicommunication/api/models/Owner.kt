package com.briceb.apicommunication.api.models

data class Owner(
    val display_name: String,
    val link: String,
    val profile_image: String,
    val reputation: Int,
    val user_id: Int,
    val user_type: String
)