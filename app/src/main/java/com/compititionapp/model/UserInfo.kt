package com.compititionapp.model

import com.google.gson.annotations.SerializedName

data class UserInfo (
    @SerializedName("mobileNo") val userMobile: String?,
    @SerializedName("password") val Password: String?
)