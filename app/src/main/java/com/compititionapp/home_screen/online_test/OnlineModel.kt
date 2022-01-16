package com.compititionapp.home_screen.online_test

class OnlineModel {
    private var test_title: String? = null
    private var question_count: String? = null
    private var time: String? = null
    private var test_price: String? = null
    private var test_marks: String? = null
    private var test_date: String? = null

    fun getTest_title(): String? {
        return test_title
    }

    fun setTest_title(testtitle: String) {
        test_title = testtitle
    }

    fun getQuestion_count(): String? {
        return question_count
    }

    fun setQuestion_count(questioncount: String) {
        question_count = questioncount
    }

    fun getTime(): String? {
        return time
    }

    fun setTime(time: String) {
        this.time = time
    }

    fun getTest_price(): String? {
        return test_price
    }

    fun setTest_price(testprice: String) {
        test_price = testprice
    }

    fun getTest_marks(): String? {
        return test_marks
    }

    fun setTest_marks(testmarks: String) {
        test_marks = testmarks
    }

    fun getTest_date(): String? {
        return test_date
    }

    fun setTest_date(testdate: String) {
        test_date = testdate
    }

    override fun toString(): String {
        return "OnlineModel(test_title=$test_title, question_count=$question_count, time=$time, test_price=$test_price, test_marks=$test_marks, test_date=$test_date)"
    }


}