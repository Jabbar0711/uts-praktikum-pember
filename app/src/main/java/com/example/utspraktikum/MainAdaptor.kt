package com.example.utspraktikum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainAdaptor (private val courseList: ArrayList<MainData>) : RecyclerView.Adapter<MainAdaptor.getView>() {
    class getView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseNama: TextView = itemView.findViewById(R.id.idNama)
        val courseNim: TextView = itemView.findViewById(R.id.idNim)
        val courseUsia: TextView = itemView.findViewById(R.id.idUsia)
        val courseProfile: ImageView = itemView.findViewById(R.id.idProfile)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdaptor.getView {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.activity_view,parent, false)

        return getView(itemView)
    }

    override fun onBindViewHolder(holder: MainAdaptor.getView, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.courseNama.text = courseList[position].ModalNama
        holder.courseNim.text = courseList[position].ModalNim
        holder.courseUsia.text = courseList[position].ModalUsia
        holder.courseProfile.setImageResource (courseList[position].ModalImg)

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context,courseList[position].ModalNama, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = courseList.size


}