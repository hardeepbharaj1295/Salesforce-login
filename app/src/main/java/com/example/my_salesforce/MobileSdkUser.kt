package com.example.my_salesforce

import com.salesforce.android.service.common.http.AuthenticatedUser
import com.salesforce.androidsdk.accounts.UserAccount

class MobileSdkUser(userAccount: UserAccount) : AuthenticatedUser {
    private val mUserId: String
    init {
        mUserId = userAccount.getUserId()
    }

    override fun getUserId(): String {
        return mUserId
    }
}
