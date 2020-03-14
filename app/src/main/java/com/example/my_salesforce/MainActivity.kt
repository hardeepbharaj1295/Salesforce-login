package com.example.my_salesforce

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.salesforce.androidsdk.app.SalesforceSDKManager
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SalesforceSDKManager.initNative(this, MainActivity::class.java)

        login_logout.setOnClickListener {
            val text  = login_logout.text.toString()
            if(text.toUpperCase() == "LOGIN"){
                login()
            }
            else{
                logout()
            }
        }
    }

    /**
     * Initiates user login process.
     */
    private fun login() {
        SalesforceSDKManager.getInstance()
            .clientManager
            .getRestClient(
                this
            ) { client ->
                // left blank intentionally
                login_logout.text = "LOGOUT"
                name.text = "NAME : ${client.clientInfo.displayName}"
                email.text = "EMAIL : ${client.clientInfo.email}"
                address.text = "ACCOUNT : ${client.clientInfo.accountName}"

                Log.e("Working ", client.clientInfo.email)
                Toast.makeText(this, "LOGIN SUCCESS", Toast.LENGTH_LONG).show()
            }
    }

    /**
     * Logs out authenticated users.
     */
    private fun logout() {
        SalesforceSDKManager.getInstance().logout(this, false)
        login_logout.text = "LOGIN"
        name.text = "NAME : null"
        email.text = "EMAIL : null"
        address.text = "ACCOUNT : null"
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show()
    }
}
