package com.sorabh.qnaapp.repository

import com.sorabh.qnaapp.model.Question
import com.sorabh.qnaapp.network.ApiInterface
import com.sorabh.qnaapp.utils.Result
import javax.inject.Inject

class QuestionRepositoryImpl @Inject constructor(private val apiInterface: ApiInterface):QuestionRepository {
    override suspend fun getQuestions(): Result<List<Question>> {
        val response = apiInterface.getQuestion()
        return if (response.isSuccessful)
            Result.Success(response.body(),response.code(),response.message())
        else
            Result.Error(response.code(),response.message())
    }

}