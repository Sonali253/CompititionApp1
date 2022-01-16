package com.compititionapp.home_screen.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Answer {
    @SerializedName("ansName")
    @Expose
    private var ansName: String? = null
    @SerializedName("correct")
    @Expose
    private var correct: Boolean? = null
    @SerializedName("selected")
    @Expose
    private var selected: Boolean? = null

    fun getAnsName(): String? {
        return ansName
    }

    fun setAnsName(ansName: String?) {
        this.ansName = ansName
    }

    fun getCorrect(): Boolean? {
        return correct
    }

    fun setCorrect(correct: Boolean?) {
        this.correct = correct
    }

    fun getSelected(): Boolean? {
        return selected
    }

    fun setSelected(selected: Boolean?) {
        this.selected = selected
    }

    override fun toString(): String {
        return "Answer(ansName=$ansName, correct=$correct, selected=$selected)"
    }

}