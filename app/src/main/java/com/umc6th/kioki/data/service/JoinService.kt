package com.umc6th.kioki.data.service

import android.app.DownloadManager.Request
import com.umc6th.kioki.data.request.ExecuteJoinRequest
import com.umc6th.kioki.data.request.RequestVerifyCode
import com.umc6th.kioki.data.request.VerifyAuthCodeRequest
import com.umc6th.kioki.data.response.AuthCodeVerifyResponse
import com.umc6th.kioki.data.response.CommonResponse
import com.umc6th.kioki.data.response.TokenResponse
import com.umc6th.kioki.data.response.RequestAuthCodeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface JoinService {

    @POST("/api/v1/auth/sms/send")
    suspend fun requestAuthCode(@Body phoneNumber: RequestVerifyCode): Response<CommonResponse<RequestAuthCodeResponse>>

    @POST("/api/v1/auth/sms/verify")
    suspend fun verifyAuthCode(@Body verifyAuthCodeRequest: VerifyAuthCodeRequest): Response<CommonResponse<VerifyAuthCodeRequest>>

    @POST("/api/v1/auth/join")
    suspend fun executeJoin(executeJoinRequest: ExecuteJoinRequest): Response<CommonResponse<TokenResponse>>
}