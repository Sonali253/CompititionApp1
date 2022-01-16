package com.compititionapp.home_screen.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class MockOrOnlineTest {
    @SerializedName("testList")
    @Expose
    private var testList: TestList? = null

    fun getTestList(): TestList? {
        return testList
    }

    fun setTestList(testList: TestList?) {
        this.testList = testList
    }

    override fun toString(): String {
        return "MockOrOnlineTest(testList=$testList)"
    }


}