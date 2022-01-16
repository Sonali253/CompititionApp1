package com.compititionapp.personlize

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class CustomObjectChoices {

    @SerializedName("stateList")
    @Expose
    private var stateList: List<State>? = null
    @SerializedName("standerdList")
    @Expose
    private var standerdList: List<Standard>? = null
    @SerializedName("boardList")
    @Expose
    private var boardList: List<Board>? = null
    @SerializedName("subjectList")
    @Expose
    private var subjectList: List<Subject>? = null
    @SerializedName("competitionList")
    @Expose
    private var competitionList: List<Competition>? = null

    fun getStateList(): List<State?>? {
        return stateList
    }

    fun setStateList(stateList: List<State>?) {
        this.stateList = stateList
    }

    fun getStanderdList(): List<Standard?>? {
        return standerdList
    }

    fun setStanderdList(standerdList: List<Standard>?) {
        this.standerdList = standerdList
    }

    fun getBoardList(): List<Board?>? {
        return boardList
    }

    fun setBoardList(boardList: List<Board>?) {
        this.boardList = boardList
    }

    fun getSubjectList(): List<Subject?>? {
        return subjectList
    }

    fun setSubjectList(subjectList: List<Subject>?) {
        this.subjectList = subjectList
    }

    fun getCompetitionList(): List<Competition?>? {
        return competitionList
    }

    fun setCompetitionList(competitionList: List<Competition>?) {
        this.competitionList = competitionList
    }

    override fun toString(): String {
        return "CustomObjectChoices(stateList=$stateList, standerdList=$standerdList, boardList=$boardList, subjectList=$subjectList, competitionList=$competitionList)"
    }


    class Competition{
        @SerializedName("code")
        @Expose
        private var code: String? = null
        @SerializedName("name")
        @Expose
        private var name: String? = null
        fun getCode(): String? {
            return code
        }

        fun setCode(code: String?) {
            this.code = code
        }

        fun getName(): String? {
            return name
        }

        fun setName(name: String?) {
            this.name = name
        }

        override fun toString(): String {
            return "competition(code=$code, name=$name)"
        }


    }

    class Board{
        @SerializedName("code")
        @Expose
        private var code: String? = null
        @SerializedName("name")
        @Expose
        private var name: String? = null
        fun getCode(): String? {
            return code
        }

        fun setCode(code: String?) {
            this.code = code
        }

        fun getName(): String? {
            return name
        }

        fun setName(name: String?) {
            this.name = name
        }

        override fun toString(): String {
            return "Board(code=$code, name=$name)"
        }

    }
    class Standard{
        @SerializedName("code")
        @Expose
        private var code: String? = null
        @SerializedName("name")
        @Expose
        private var name: String? = null

        fun getCode(): String? {
            return code
        }

        fun setCode(code: String?) {
            this.code = code
        }

        fun getName(): String? {
            return name
        }

        fun setName(name: String?) {
            this.name = name
        }

        override fun toString(): String {
            return "Standard(code=$code, name=$name)"
        }

    }
    class State{
        @SerializedName("code")
        @Expose
        private var code: String? = null
        @SerializedName("name")
        @Expose
        private var name: String? = null

        fun getCode(): String? {
            return code
        }

        fun setCode(code: String?) {
            this.code = code
        }

        fun getName(): String? {
            return name
        }

        fun setName(name: String?) {
            this.name = name
        }

        override fun toString(): String {
            return "State(code=$code, name=$name)"
        }

    }

    class Subject{
        @SerializedName("code")
        @Expose
        private var code: String? = null
        @SerializedName("name")
        @Expose
        private var name: String? = null

        fun getCode(): String? {
            return code
        }

        fun setCode(code: String?) {
            this.code = code
        }

        fun getName(): String? {
            return name
        }

        fun setName(name: String?) {
            this.name = name
        }

        override fun toString(): String {
            return "Subject(code=$code, name=$name)"
        }

    }


}