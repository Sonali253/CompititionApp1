package com.compititionapp.personlize.network

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Question {
    @SerializedName("status")
    @Expose
    private var status: String? = null
    @SerializedName("createdBy")
    @Expose
    private var createdBy: String? = null
    @SerializedName("updatedBy")
    @Expose
    private var updatedBy: String? = null
    @SerializedName("createdDate")
    @Expose
    private var createdDate: Long? = null
    @SerializedName("updatedDate")
    @Expose
    private var updatedDate: Long? = null
    @SerializedName("queId")
    @Expose
    private var queId: String? = null
    @SerializedName("queName")
    @Expose
    private var queName: String? = null
    @SerializedName("topic")
    @Expose
    private var topic: String? = null
    @SerializedName("marks")
    @Expose
    private var marks: Float? = null
    @SerializedName("testId")
    @Expose
    private var testId: String? = null
    @SerializedName("answers")
    @Expose
    private var answers: List<Answer>? = null
    @SerializedName("complexity")
    @Expose
    private var complexity: Int? = null
    @SerializedName("hint")
    @Expose
    private var hint: String? = null
    @SerializedName("reference")
    @Expose
    private var reference: String? = null
    @SerializedName("tags")
    @Expose
    private var tags: String? = null
    @SerializedName("duration")
    @Expose
    private var duration: Int? = null
    @SerializedName("queType")
    @Expose
    private var queType: String? = null
    @SerializedName("explanation")
    @Expose
    private var explanation: String? = null
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

    fun getUpdatedBy(): String? {
        return updatedBy
    }

    fun setUpdatedBy(updatedBy: String?) {
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

    fun getQueId(): String? {
        return queId
    }

    fun setQueId(queId: String?) {
        this.queId = queId
    }

    fun getQueName(): String? {
        return queName
    }

    fun setQueName(queName: String?) {
        this.queName = queName
    }

    fun getTopic(): String? {
        return topic
    }

    fun setTopic(topic: String?) {
        this.topic = topic
    }

    fun getMarks(): Float? {
        return marks
    }

    fun setMarks(marks: Float?) {
        this.marks = marks
    }

    fun getTestId(): String? {
        return testId
    }

    fun setTestId(testId: String?) {
        this.testId = testId
    }

    fun getAnswers(): List<Answer?>? {
        return answers
    }

    fun setAnswers(answers: List<Answer>?) {
        this.answers = answers
    }

    fun getComplexity(): Int? {
        return complexity
    }

    fun setComplexity(complexity: Int?) {
        this.complexity = complexity
    }

    fun getHint(): String? {
        return hint
    }

    fun setHint(hint: String?) {
        this.hint = hint
    }

    fun getReference(): String? {
        return reference
    }

    fun setReference(reference: String?) {
        this.reference = reference
    }

    fun getTags(): String? {
        return tags
    }

    fun setTags(tags: String?) {
        this.tags = tags
    }

    fun getDuration(): Int? {
        return duration
    }

    fun setDuration(duration: Int?) {
        this.duration = duration
    }

    fun getQueType(): String? {
        return queType
    }

    fun setQueType(queType: String?) {
        this.queType = queType
    }

    fun getExplanation(): String? {
        return explanation
    }

    fun setExplanation(explanation: String?) {
        this.explanation = explanation
    }

    override fun toString(): String {
        return "Question(status=$status, createdBy=$createdBy, updatedBy=$updatedBy, createdDate=$createdDate, updatedDate=$updatedDate, queId=$queId, queName=$queName, topic=$topic, marks=$marks, testId=$testId, answers=$answers, complexity=$complexity, hint=$hint, reference=$reference, tags=$tags, duration=$duration, queType=$queType, explanation=$explanation)"
    }

}