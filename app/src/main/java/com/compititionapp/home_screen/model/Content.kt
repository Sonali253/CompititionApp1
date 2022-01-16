package com.compititionapp.home_screen.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Content {
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
    @SerializedName("testId")
    @Expose
    private var testId: String? = null
    @SerializedName("testName")
    @Expose
    private var testName: String? = null
    @SerializedName("totalMarks")
    @Expose
    private var totalMarks: Float? = null
    @SerializedName("minimumPassingMarks")
    @Expose
    private var minimumPassingMarks: Float? = null
    @SerializedName("topic")
    @Expose
    private var topic: String? = null
    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("sections")
    @Expose
    private var sections: List<Section>? =
        null
    @SerializedName("totalTimeInMinute")
    @Expose
    private var totalTimeInMinute: Int? = null
    @SerializedName("timer")
    @Expose
    private var timer: Int? = null
    @SerializedName("category")
    @Expose
    private var category: String? = null
    @SerializedName("type")
    @Expose
    private var type: String? = null
    @SerializedName("mode")
    @Expose
    private var mode: String? = null
    @SerializedName("state")
    @Expose
    private var state: String? = null
    @SerializedName("rule")
    @Expose
    private var rule: Any? = null
    @SerializedName("chapter")
    @Expose
    private var chapter: Any? = null
    @SerializedName("subject")
    @Expose
    private var subject: String? = null
    @SerializedName("className")
    @Expose
    private var className: String? = null
    @SerializedName("boardName")
    @Expose
    private var boardName: String? = null
    @SerializedName("fromDate")
    @Expose
    private var fromDate: Long? = null
    @SerializedName("toDate")
    @Expose
    private var toDate: Long? = null
    @SerializedName("publication")
    @Expose
    private var publication: String? = null
    @SerializedName("states")
    @Expose
    private var states: String? = null
    @SerializedName("competitionType")
    @Expose
    private var competitionType: String? = null
    @SerializedName("standard")
    @Expose
    private var standard: String? = null
    @SerializedName("subjects")
    @Expose
    private var subjects: String? = null
    @SerializedName("pattern")
    @Expose
    private var pattern: String? = null
    @SerializedName("testPrice")
    @Expose
    private var testPrice: Float? = null
    @SerializedName("testType")
    @Expose
    private var testType: String? = null
    @SerializedName("testCountDto")
    @Expose
    private var testCountDto: Any? = null
    @SerializedName("negativeMarks")
    @Expose
    private var negativeMarks: Boolean? = null
    @SerializedName("visiblePublic")
    @Expose
    private var visiblePublic: Any? = null

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

    fun getTestId(): String? {
        return testId
    }

    fun setTestId(testId: String?) {
        this.testId = testId
    }

    fun getTestName(): String? {
        return testName
    }

    fun setTestName(testName: String?) {
        this.testName = testName
    }

    fun getTotalMarks(): Float? {
        return totalMarks
    }

    fun setTotalMarks(totalMarks: Float?) {
        this.totalMarks = totalMarks
    }

    fun getMinimumPassingMarks(): Float? {
        return minimumPassingMarks
    }

    fun setMinimumPassingMarks(minimumPassingMarks: Float?) {
        this.minimumPassingMarks = minimumPassingMarks
    }

    fun getTopic(): String? {
        return topic
    }

    fun setTopic(topic: String?) {
        this.topic = topic
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getSections(): List<Section?>? {
        return sections
    }

    fun setSections(sections: List<Section>?) {
        this.sections = sections
    }

    fun getTotalTimeInMinute(): Int? {
        return totalTimeInMinute
    }

    fun setTotalTimeInMinute(totalTimeInMinute: Int?) {
        this.totalTimeInMinute = totalTimeInMinute
    }

    fun getTimer(): Int? {
        return timer
    }

    fun setTimer(timer: Int?) {
        this.timer = timer
    }

    fun getCategory(): String? {
        return category
    }

    fun setCategory(category: String?) {
        this.category = category
    }

    fun getType(): String? {
        return type
    }

    fun setType(type: String?) {
        this.type = type
    }

    fun getMode(): String? {
        return mode
    }

    fun setMode(mode: String?) {
        this.mode = mode
    }

    fun getState(): String? {
        return state
    }

    fun setState(state: String?) {
        this.state = state
    }

    fun getRule(): Any? {
        return rule
    }

    fun setRule(rule: Any?) {
        this.rule = rule
    }

    fun getChapter(): Any? {
        return chapter
    }

    fun setChapter(chapter: Any?) {
        this.chapter = chapter
    }

    fun getSubject(): String? {
        return subject
    }

    fun setSubject(subject: String?) {
        this.subject = subject
    }

    fun getClassName(): String? {
        return className
    }

    fun setClassName(className: String?) {
        this.className = className
    }

    fun getBoardName(): String? {
        return boardName
    }

    fun setBoardName(boardName: String?) {
        this.boardName = boardName
    }

    fun getFromDate(): Long? {
        return fromDate
    }

    fun setFromDate(fromDate: Long?) {
        this.fromDate = fromDate
    }

    fun getToDate(): Long? {
        return toDate
    }

    fun setToDate(toDate: Long?) {
        this.toDate = toDate
    }

    fun getPublication(): String? {
        return publication
    }

    fun setPublication(publication: String?) {
        this.publication = publication
    }

    fun getStates(): String? {
        return states
    }

    fun setStates(states: String?) {
        this.states = states
    }

    fun getCompetitionType(): String? {
        return competitionType
    }

    fun setCompetitionType(competitionType: String?) {
        this.competitionType = competitionType
    }

    fun getStandard(): String? {
        return standard
    }

    fun setStandard(standard: String?) {
        this.standard = standard
    }

    fun getSubjects(): String? {
        return subjects
    }

    fun setSubjects(subjects: String?) {
        this.subjects = subjects
    }

    fun getPattern(): String? {
        return pattern
    }

    fun setPattern(pattern: String?) {
        this.pattern = pattern
    }

    fun getTestPrice(): Float? {
        return testPrice
    }

    fun setTestPrice(testPrice: Float?) {
        this.testPrice = testPrice
    }

    fun getTestType(): String? {
        return testType
    }

    fun setTestType(testType: String?) {
        this.testType = testType
    }

    fun getTestCountDto(): Any? {
        return testCountDto
    }

    fun setTestCountDto(testCountDto: Any?) {
        this.testCountDto = testCountDto
    }

    fun getNegativeMarks(): Boolean? {
        return negativeMarks
    }

    fun setNegativeMarks(negativeMarks: Boolean?) {
        this.negativeMarks = negativeMarks
    }

    fun getVisiblePublic(): Any? {
        return visiblePublic
    }

    fun setVisiblePublic(visiblePublic: Any?) {
        this.visiblePublic = visiblePublic
    }

    override fun toString(): String {
        return "Content(status=$status, createdBy=$createdBy, updatedBy=$updatedBy, createdDate=$createdDate, updatedDate=$updatedDate, testId=$testId, testName=$testName, totalMarks=$totalMarks, minimumPassingMarks=$minimumPassingMarks, topic=$topic, description=$description, sections=$sections, totalTimeInMinute=$totalTimeInMinute, timer=$timer, category=$category, type=$type, mode=$mode, state=$state, rule=$rule, chapter=$chapter, subject=$subject, className=$className, boardName=$boardName, fromDate=$fromDate, toDate=$toDate, publication=$publication, states=$states, competitionType=$competitionType, standard=$standard, subjects=$subjects, pattern=$pattern, testPrice=$testPrice, testType=$testType, testCountDto=$testCountDto, negativeMarks=$negativeMarks, visiblePublic=$visiblePublic)"
    }

}