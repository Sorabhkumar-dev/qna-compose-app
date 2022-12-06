package com.sorabh.qnaapp.model

data class Question(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)