package com.compititionapp.home_screen.model

import com.compititionapp.personlize.network.Question
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Section {
    @SerializedName("sectionName")
    @Expose
    private var sectionName: String? = null
    @SerializedName("sectionMarks")
    @Expose
    private var sectionMarks: Float? = null
    @SerializedName("sectionTime")
    @Expose
    private var sectionTime: Int? = null
    @SerializedName("questionList")
    @Expose
    private var questionList: List<Question>? = null

    fun getSectionName(): String? {
        return sectionName
    }

    fun setSectionName(sectionName: String?) {
        this.sectionName = sectionName
    }

    fun getSectionMarks(): Float? {
        return sectionMarks
    }

    fun setSectionMarks(sectionMarks: Float?) {
        this.sectionMarks = sectionMarks
    }

    fun getSectionTime(): Int? {
        return sectionTime
    }

    fun setSectionTime(sectionTime: Int?) {
        this.sectionTime = sectionTime
    }

    fun getQuestionList(): List<Question?>? {
        return questionList
    }

    fun setQuestionList(questionList: List<Question>?) {
        this.questionList = questionList
    }
}