package com.compititionapp.home_screen.online_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.compititionapp.R
import com.compititionapp.workbook.adapter.WorkbookModel
import com.squareup.picasso.Picasso

class OnlineTestAdapter: RecyclerView.Adapter<OnlineTestAdapter.Viewholder>() {
    var context: Context? = null
    var onlineModelList: ArrayList<OnlineModel>? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Viewholder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.online_list, parent, false)
        return Viewholder(view)
    }

    override fun getItemCount(): Int {
        return onlineModelList!!.size
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        val model: OnlineModel = onlineModelList!!.get(position)
        holder.testTitle.text = model.getTest_title()
        holder.testQuestion.text = model.getQuestion_count()
        holder.testTime.text = model.getTime()
        holder.btnFree.text = model.getTest_price()
        holder.btnMarks.text = model.getTest_marks()
    }

    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var testTitle: TextView
        var testQuestion: TextView
        var testTime: TextView
        var btnStart: Button
        var btnFree: Button
        var btnMarks: Button

        init {
            testTitle = itemView.findViewById(R.id.text_test_title)
            testQuestion  = itemView.findViewById(R.id.text_question)
            testTime  = itemView.findViewById(R.id.text_time)
            btnStart = itemView.findViewById(R.id.btn_start)
            btnFree = itemView.findViewById(R.id.btn_free)
            btnMarks = itemView.findViewById(R.id.btn_marks)
        }
    }
}