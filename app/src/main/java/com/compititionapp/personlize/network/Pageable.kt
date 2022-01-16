package com.compititionapp.personlize.network

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Pageable {
    @SerializedName("sort")
    @Expose
    private var sort: Sort? = null
    @SerializedName("offset")
    @Expose
    private var offset: Int? = null
    @SerializedName("pageNumber")
    @Expose
    private var pageNumber: Int? = null
    @SerializedName("pageSize")
    @Expose
    private var pageSize: Int? = null
    @SerializedName("paged")
    @Expose
    private var paged: Boolean? = null
    @SerializedName("unpaged")
    @Expose
    private var unpaged: Boolean? = null

    fun getSort(): Sort? {
        return sort
    }

    fun setSort(sort: Sort?) {
        this.sort = sort
    }

    fun getOffset(): Int? {
        return offset
    }

    fun setOffset(offset: Int?) {
        this.offset = offset
    }

    fun getPageNumber(): Int? {
        return pageNumber
    }

    fun setPageNumber(pageNumber: Int?) {
        this.pageNumber = pageNumber
    }

    fun getPageSize(): Int? {
        return pageSize
    }

    fun setPageSize(pageSize: Int?) {
        this.pageSize = pageSize
    }

    fun getPaged(): Boolean? {
        return paged
    }

    fun setPaged(paged: Boolean?) {
        this.paged = paged
    }

    fun getUnpaged(): Boolean? {
        return unpaged
    }

    fun setUnpaged(unpaged: Boolean?) {
        this.unpaged = unpaged
    }

    override fun toString(): String {
        return "Pageable(sort=$sort, offset=$offset, pageNumber=$pageNumber, pageSize=$pageSize, paged=$paged, unpaged=$unpaged)"
    }


}