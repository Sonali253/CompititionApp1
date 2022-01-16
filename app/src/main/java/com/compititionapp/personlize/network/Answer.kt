package com.compititionapp.personlize.network

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Answer {
    @SerializedName("ansName")
    @Expose
    private var ansName: String? = null
    @SerializedName("selected")
    @Expose
    private var selected: Boolean? = null
    @SerializedName("correct")
    @Expose
    private var correct: Boolean? = null


    fun getAnsName(): String? {
        return ansName
    }

    fun setAnsName(ansName: String?) {
        this.ansName = ansName
    }

    fun getSelected(): Boolean? {
        return selected
    }

    fun setSelected(selected: Boolean?) {
        this.selected = selected
    }

    fun getCorrect(): Boolean? {
        return correct
    }

    fun setCorrect(correct: Boolean?) {
        this.correct = correct
    }

    override fun toString(): String {
        return "Answer(ansName=$ansName, selected=$selected, correct=$correct)"
    }


}