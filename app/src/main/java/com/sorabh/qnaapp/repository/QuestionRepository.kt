package com.sorabh.qnaapp.repository

import com.sorabh.qnaapp.model.Question
import com.sorabh.qnaapp.utils.Result

interface QuestionRepository {
   suspend fun getQuestions(): Result<List<Question>>
}