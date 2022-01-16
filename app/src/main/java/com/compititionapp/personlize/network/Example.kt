package com.compititionapp.personlize.network

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Example {
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
        return "Example(testList=$testList)"
    }


}