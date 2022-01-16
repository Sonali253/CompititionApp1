package com.compititionapp.home_screen.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class TestList {
    @SerializedName("content")
    @Expose
    private var content: List<Content>? = null
    @SerializedName("pageable")
    @Expose
    private var pageable: Pageable? = null
    @SerializedName("totalPages")
    @Expose
    private var totalPages: Int? = null
    @SerializedName("last")
    @Expose
    private var last: Boolean? = null
    @SerializedName("totalElements")
    @Expose
    private var totalElements: Int? = null
    @SerializedName("size")
    @Expose
    private var size: Int? = null
    @SerializedName("number")
    @Expose
    private var number: Int? = null
    @SerializedName("sort")
    @Expose
    private var sort: Sort__1? = null
    @SerializedName("numberOfElements")
    @Expose
    private var numberOfElements: Int? = null
    @SerializedName("first")
    @Expose
    private var first: Boolean? = null
    @SerializedName("empty")
    @Expose
    private var empty: Boolean? = null

    fun getContent(): List<Content?>? {
        return content
    }

    fun setContent(content: List<Content>?) {
        this.content = content
    }

    fun getPageable(): Pageable? {
        return pageable
    }

    fun setPageable(pageable: Pageable?) {
        this.pageable = pageable
    }

    fun getTotalPages(): Int? {
        return totalPages
    }

    fun setTotalPages(totalPages: Int?) {
        this.totalPages = totalPages
    }

    fun getLast(): Boolean? {
        return last
    }

    fun setLast(last: Boolean?) {
        this.last = last
    }

    fun getTotalElements(): Int? {
        return totalElements
    }

    fun setTotalElements(totalElements: Int?) {
        this.totalElements = totalElements
    }

    fun getSize(): Int? {
        return size
    }

    fun setSize(size: Int?) {
        this.size = size
    }

    fun getNumber(): Int? {
        return number
    }

    fun setNumber(number: Int?) {
        this.number = number
    }

    fun getSort(): Sort__1? {
        return sort
    }

    fun setSort(sort: Sort__1?) {
        this.sort = sort
    }

    fun getNumberOfElements(): Int? {
        return numberOfElements
    }

    fun setNumberOfElements(numberOfElements: Int?) {
        this.numberOfElements = numberOfElements
    }

    fun getFirst(): Boolean? {
        return first
    }

    fun setFirst(first: Boolean?) {
        this.first = first
    }

    fun getEmpty(): Boolean? {
        return empty
    }

    fun setEmpty(empty: Boolean?) {
        this.empty = empty
    }

    override fun toString(): String {
        return "TestList(content=$content, pageable=$pageable, totalPages=$totalPages, last=$last, totalElements=$totalElements, size=$size, number=$number, sort=$sort, numberOfElements=$numberOfElements, first=$first, empty=$empty)"
    }

}