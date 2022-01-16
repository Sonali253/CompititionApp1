package com.compititionapp.model.studymaterialAPI

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class GetStudyMaterial {
    @SerializedName("studyMaterial")
    @Expose
    private var studyMaterial: StudyMaterial? = null
    @SerializedName("total studyMaterial count")
    @Expose
    private var totalStudyMaterialCount: List<TotalStudyMaterialCount>? = null
    @SerializedName("status")
    @Expose
    private var status: String? = null

    fun getStudyMaterial(): StudyMaterial? {
        return studyMaterial
    }

    fun setStudyMaterial(studyMaterial: StudyMaterial?) {
        this.studyMaterial = studyMaterial
    }

    fun getTotalStudyMaterialCount(): List<TotalStudyMaterialCount?>? {
        return totalStudyMaterialCount
    }

    fun setTotalStudyMaterialCount(totalStudyMaterialCount: List<TotalStudyMaterialCount>) {
        this.totalStudyMaterialCount = totalStudyMaterialCount
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    override fun toString(): String {
        return "GetStudyMaterial(studyMaterial=$studyMaterial, totalStudyMaterialCount=$totalStudyMaterialCount, status=$status)"
    }

}