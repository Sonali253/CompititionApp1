package com.compititionapp.personlize.network

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Sort {
    @SerializedName("sorted")
    @Expose
    private var sorted: Boolean? = null
    @SerializedName("unsorted")
    @Expose
    private var unsorted: Boolean? = null
    @SerializedName("empty")
    @Expose
    private var empty: Boolean? = null

    fun getSorted(): Boolean? {
        return sorted
    }

    fun setSorted(sorted: Boolean?) {
        this.sorted = sorted
    }

    fun getUnsorted(): Boolean? {
        return unsorted
    }

    fun setUnsorted(unsorted: Boolean?) {
        this.unsorted = unsorted
    }

    fun getEmpty(): Boolean? {
        return empty
    }

    fun setEmpty(empty: Boolean?) {
        this.empty = empty
    }

    override fun toString(): String {
        return "Sort(sorted=$sorted, unsorted=$unsorted, empty=$empty)"
    }

}