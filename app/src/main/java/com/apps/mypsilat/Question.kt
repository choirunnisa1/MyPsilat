package com.apps.mypsilat

data class Question(
    val id : Int,
    val question: String,
    val optionOne: String,
    val optionTwo: String,
    val optionTree: String,
    val optionFour: String,
    val optionFive: String,
    val correctAnswer: Int
)