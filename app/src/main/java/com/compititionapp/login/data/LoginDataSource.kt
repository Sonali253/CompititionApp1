package com.compititionapp.login.data

import com.compititionapp.login.data.model.LoggedInUser
import com.compititionapp.login.network.RestApiService
import com.compititionapp.model.UserInfo
import java.io.IOException
import java.util.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            var user: LoggedInUser
            val userID = addUser(username, password)

            // TODO: handle loggedInUser authentication
            user = LoggedInUser(userID, "Success")

            return Result.Success(user)
            //return Result.Error(IOException("Error registering new user"))
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun addUser(username: String, password: String) : String? {
        val apiService = RestApiService()
        val userInfo = UserInfo(
            userMobile = username,
            Password = password
        )
         val userID = apiService.login(userInfo)
        /*if (it?.userMobile() != null) {
            // it = newly added user parsed as response
            // it?.id = newly added user ID
        } else
            Log.d("@","Error registering new user")*/
        return userID
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

