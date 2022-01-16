package com.compititionapp.home_screen.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Sort {
    @SerializedName("unsorted")
    @Expose
    private var unsorted: Boolean? = null
    @SerializedName("sorted")
    @Expose
    private var sorted: Boolean? = null
    @SerializedName("empty")
    @Expose
    private var empty: Boolean? = null

    fun getUnsorted(): Boolean? {
        return unsorted
    }

    fun setUnsorted(unsorted: Boolean?) {
        this.unsorted = unsorted
    }

    fun getSorted(): Boolean? {
        return sorted
    }

    fun setSorted(sorted: Boolean?) {
        this.sorted = sorted
    }

    fun getEmpty(): Boolean? {
        return empty
    }

    fun setEmpty(empty: Boolean?) {
        this.empty = empty
    }

    override fun toString(): String {
        return "Sort(unsorted=$unsorted, sorted=$sorted, empty=$empty)"
    }

}