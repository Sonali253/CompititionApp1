package com.compititionapp.login.network

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


 class LoginData {
    @SerializedName("MESSAGE")
    @Expose
    private var message: String? = null
    @SerializedName("STATUS")
    @Expose
    private var status: String? = null
    @SerializedName("RESULT")
    @Expose
    private var result: Result? = null

    fun getMessage(): String? {
        return message
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getResult(): Result? {
        return result
    }

    fun setResult(result: Result?) {
        this.result = result
    }

    override fun toString(): String {
        return "LoginData(message=$message, status=$status, result=$result)"
    }

     class Result() {
        @SerializedName("resourceId")
        @Expose
        private var resourceId: String? = null
        @SerializedName("mobileNo")
        @Expose
        private var mobileNo: String? = null
        @SerializedName("name")
        @Expose
        private var name: String? = null
        @SerializedName("city")
        @Expose
        private var city: String? = null
        @SerializedName("password")
        @Expose
        private var password: String? = null
        @SerializedName("teacherRole")
        @Expose
        private var teacherRole: String? = null

        fun getResourceId(): String? {
            return resourceId
        }

        fun setResourceId(resourceId: String?) {
            this.resourceId = resourceId
        }

        fun getMobileNo(): String? {
            return mobileNo
        }

        fun setMobileNo(mobileNo: String?) {
            this.mobileNo = mobileNo
        }

        fun getName(): String? {
            return name
        }

        fun setName(name: String?) {
            this.name = name
        }

        fun getCity(): String? {
            return city
        }

        fun setCity(city: String?) {
            this.city = city
        }

        fun getPassword(): String? {
            return password
        }

        fun setPassword(password: String?) {
            this.password = password
        }

        fun getTeacherRole(): String? {
            return teacherRole
        }

        fun setTeacherRole(teacherRole: String?) {
            this.teacherRole = teacherRole
        }

        override fun toString(): String {
            return "Result(resourceId=$resourceId, mobileNo=$mobileNo, name=$name, city=$city, password=$password, teacherRole=$teacherRole)"
        }

    }


}