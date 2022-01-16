package com.compititionapp.workbook.adapter

import android.content.Context
import android.net.Uri
import android.opengl.Visibility
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.compititionapp.R
import com.squareup.picasso.Picasso


class WorkbookAdapter : RecyclerView.Adapter<WorkbookAdapter.Viewholder>() {

     var context: Context? = null
     var workbookModelList: ArrayList<WorkbookModel>? = null
     var firstFiveItemsList :ArrayList<WorkbookModel>?= null

    // Constructor
    fun WorkbookAdapter(
        context: Context?,
        workbookModelList: ArrayList<WorkbookModel>?) {
        this.context = context
        this.workbookModelList = workbookModelList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkbookAdapter.Viewholder { // to inflate the layout for each item of recycler view.
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.workbook_cardview, parent, false)
        return Viewholder(view)
    }
    override fun onBindViewHolder(
        holder: WorkbookAdapter.Viewholder, position: Int) { // to set data to textview and imageview of each card layout
        val count = workbookModelList!!.size - 5


        if(firstFiveItemsList == null) {
            val model: WorkbookModel = workbookModelList!!.get(position)
            holder.subjectName.setText(model.getSubject_name())
            Picasso.get().load(model.getSubject_image()).into(holder.subjectImage)
        }
        if(firstFiveItemsList!= null) {
            val model: WorkbookModel = firstFiveItemsList!!.get(position)
            holder.subjectName.setText(model.getSubject_name())
            Picasso.get().load(model.getSubject_image()).into(holder.subjectImage)

            if(position > 4) {
                for (i in workbookModelList!!.indices) {
                    if (workbookModelList!!.get(i).getId() == 5) {
                        val params: ViewGroup.LayoutParams = holder.subjectName.getLayoutParams() as ViewGroup.LayoutParams
                        params.height = context?.getResources()!!.getDimensionPixelSize(R.dimen.text_view_height)
                        holder.subjectImage.visibility = View.GONE
                        holder.subjectName.text = "+$count\nmore"
                        holder.subjectName.gravity = Gravity.CENTER
                        //Picasso.get().load("").into(holder.subjectImage)
                    }
                }
            }
        }


        //holder.subjectImage.setImageURI(Uri.parse(model.getSubject_image()))
    }

    override fun getItemCount(): Int { // this method is used for showing number
// of card items in recycler view.
        if (firstFiveItemsList != null)
            return firstFiveItemsList!!.size
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