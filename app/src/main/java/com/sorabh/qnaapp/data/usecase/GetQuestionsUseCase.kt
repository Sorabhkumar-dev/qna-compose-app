package com.sorabh.qnaapp.data.usecase

import com.sorabh.qnaapp.model.Question
import com.sorabh.qnaapp.repository.QuestionRepository
import javax.inject.Inject

class GetQuestionsUseCase @Inject constructor(private val questionRepository: QuestionRepository):FlowBaseUseCase<Unit,List<Question>>() {
    override suspend fun getResponse(params: Unit) = questionRepository.getQuestions()
}