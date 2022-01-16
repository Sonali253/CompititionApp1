package com.compititionapp.workbook.adapter

import java.io.Serializable

class WorkbookModel : Serializable{

    private var id : Int? = null
    private var subject_name: String? = null
    private var subject_image: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(iD: Int) {
        id = iD
    }

    fun getSubject_name(): String? {
        return subject_name
    }

    fun setSubject_name(subjectname: String) {
        subject_name = subjectname
    }

    fun getSubject_image(): String? {
        return subject_image
    }

    fun setSubject_image(subjectImage: String) {
        subject_image = subjectImage
    }

    override fun toString(): String {
        return "WorkbookModel(id=$id, subject_name=$subject_name, subject_image=$subject_image)"
    }


}