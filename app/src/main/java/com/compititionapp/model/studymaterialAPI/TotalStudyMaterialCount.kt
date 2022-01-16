package com.compititionapp.model.studymaterialAPI

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class TotalStudyMaterialCount {
    @SerializedName("status")
    @Expose
     private var status: String? = null
    @SerializedName("createdBy")
    @Expose
    private var createdBy: String? = null
    @SerializedName("updatedBy")
    @Expose
    private var updatedBy: Any? = null
    @SerializedName("createdDate")
    @Expose
    private var createdDate: Long? = null
    @SerializedName("updatedDate")
    @Expose
    private var updatedDate: Long? = null
    @SerializedName("id")
    @Expose
    private var id: String? = null
    @SerializedName("smName")
    @Expose
    private var smName: String? = null
    @SerializedName("smDescription")
    @Expose
    private var smDescription: String? = null
    @SerializedName("smState")
    @Expose
    private var smState: String? = null
    @SerializedName("smCompetitionType")
    @Expose
    private var smCompetitionType: String? = null
    @SerializedName("smStandard")
    @Expose
    private var smStandard: String? = null
    @SerializedName("smSubjects")
    @Expose
    private var smSubjects: String? = null
    @SerializedName("smPattern")
    @Expose
    private var smPattern: String? = null
    @SerializedName("smPrice")
    @Expose
    private var smPrice: Float? = null
    @SerializedName("smDiscount")
    @Expose
    private var smDiscount: Float? = null
    @SerializedName("smImgUrl")
    @Expose
    private var smImgUrl: String? = null
    @SerializedName("smPrvImg")
    @Expose
    private var smPrvImg: String? = null

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getCreatedBy(): String? {
        return createdBy
    }

    fun setCreatedBy(createdBy: String?) {
        this.createdBy = createdBy
    }

    fun getUpdatedBy(): Any? {
        return updatedBy
    }

    fun setUpdatedBy(updatedBy: Any?) {
        this.updatedBy = updatedBy
    }

    fun getCreatedDate(): Long? {
        return createdDate
    }

    fun setCreatedDate(createdDate: Long?) {
        this.createdDate = createdDate
    }

    fun getUpdatedDate(): Long? {
        return updatedDate
    }

    fun setUpdatedDate(updatedDate: Long?) {
        this.updatedDate = updatedDate
    }

    fun getId(): String? {
        return id
    }

    fun setId(id: String?) {
        this.id = id
    }

    fun getSmName(): String? {
        return smName
    }

    fun setSmName(smName: String?) {
        this.smName = smName
    }

    fun getSmDescription(): String? {
        return smDescription
    }

    fun setSmDescription(smDescription: String?) {
        this.smDescription = smDescription
    }

    fun getSmState(): String? {
        return smState
    }

    fun setSmState(smState: String?) {
        this.smState = smState
    }

    fun getSmCompetitionType(): String? {
        return smCompetitionType
    }

    fun setSmCompetitionType(smCompetitionType: String?) {
        this.smCompetitionType = smCompetitionType
    }

    fun getSmStandard(): String? {
        return smStandard
    }

    fun setSmStandard(smStandard: String?) {
        this.smStandard = smStandard
    }

    fun getSmSubjects(): String? {
        return smSubjects
    }

    fun setSmSubjects(smSubjects: String?) {
        this.smSubjects = smSubjects
    }

    fun getSmPattern(): String? {
        return smPattern
    }

    fun setSmPattern(smPattern: String?) {
        this.smPattern = smPattern
    }

    fun getSmPrice(): Float? {
        return smPrice
    }

    fun setSmPrice(smPrice: Float?) {
        this.smPrice = smPrice
    }

    fun getSmDiscount(): Float? {
        return smDiscount
    }

    fun setSmDiscount(smDiscount: Float?) {
        this.smDiscount = smDiscount
    }

    fun getSmImgUrl(): String? {
        return smImgUrl
    }

    fun setSmImgUrl(smImgUrl: String?) {
        this.smImgUrl = smImgUrl
    }

    fun getSmPrvImg(): String? {
        return smPrvImg
    }

    fun setSmPrvImg(smPrvImg: String?) {
        this.smPrvImg = smPrvImg
    }

    override fun toString(): String {
        return "TotalStudyMaterialCount(status=$status, createdBy=$createdBy, updatedBy=$updatedBy, createdDate=$createdDate, updatedDate=$updatedDate, id=$id, smName=$smName, smDescription=$smDescription, smState=$smState, smCompetitionType=$smCompetitionType, smStandard=$smStandard, smSubjects=$smSubjects, smPattern=$smPattern, smPrice=$smPrice, smDiscount=$smDiscount, smImgUrl=$smImgUrl, smPrvImg=$smPrvImg)"
    }

}
