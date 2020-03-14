package com.example.my_salesforce.auth

import com.salesforce.android.service.common.http.AuthTokenProvider
import com.salesforce.android.service.common.http.ResponseSummary
import com.salesforce.androidsdk.rest.ClientManager.AccMgrAuthTokenProvider

class MobileSDKAuthTokenProvider(
    private val tokenProvider: AccMgrAuthTokenProvider,
    private var authToken: String
) : AuthTokenProvider {
    override fun getToken(): String? {
        return authToken
    }

    override fun getTokenType(): String? {
        return "Bearer"
    }

    override fun canRefresh(): Boolean {
        return true
    }

    override fun refreshToken(responseSummary: ResponseSummary) {
        authToken = tokenProvider.newAuthToken
    }

}