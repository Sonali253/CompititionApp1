package com.compititionapp.workbook.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.compititionapp.R
import com.squareup.picasso.Picasso


class WorkbookListAdapter : RecyclerView.Adapter<WorkbookListAdapter.Viewholder>() {

    var context: Context? = null
    var workbookModelList: ArrayList<WorkbookModel>? = null

    // Constructor
    fun WorkbookListAdapter(
        context: Context?,
        workbookModelList: ArrayList<WorkbookModel>?) {
        this.context = context
        this.workbookModelList = workbookModelList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkbookListAdapter.Viewholder { // to inflate the layout for each item of recycler view.
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.workbook_list, parent, false)
        return Viewholder(view)
    }
    override fun onBindViewHolder(
        holder: WorkbookListAdapter.Viewholder,
        position: Int
    ) { // to set data to textview and imageview of each card layout
        val model: WorkbookModel = workbookModelList!!.get(position)
        holder.subjectName.setText(model.getSubject_name())
        Picasso.get().load(model.getSubject_image()).into(holder.subjectImage)
        //holder.subjectImage.setImageURI(Uri.parse(model.getSubject_image()))
    }

    override fun getItemCount(): Int { // this method is used for showing number
// of card items in recycler view.
        return workbookModelList!!.size
    }


    // View holder class for initializing of
// your views such as TextView and Imageview.
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var subjectName: TextView
        var subjectImage: ImageView


        init {
            subjectImage = itemView.findViewById(R.id.image1)
            subjectName  = itemView.findViewById(R.id.subject1)
        }
    }
}