package com.example.healthassistant.domain.interactor

import com.example.healthassistant.domain.model.User
import com.example.healthassistant.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(private val userRepository: UserRepository) :
    UseCase<User, GetUserUseCase.Params>() {

    override suspend fun run(params: Params) = userRepository.getUserInfo(params.id)

    data class Params(val id: Long)
}
