package com.sorabh.qnaapp.utils

sealed class Result<T> {
    class Loading<T> : Result<T>()
    class Success<T>(val body: T?, val code: Int, val message: String):Result<T>()
    class Error<T>(val code: Int,val message: String):Result<T>()
}