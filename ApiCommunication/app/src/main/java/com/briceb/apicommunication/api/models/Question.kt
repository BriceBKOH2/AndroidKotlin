package com.briceb.apicommunication.api.models

import com.briceb.apicommunication.api.models.Item

data class Question(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)