package com.example.employees

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.coroutines.NonDisposableHandle.parent
import kotlinx.coroutines.withContext

class RecyclerAdapter ( private val Data:List<ContactsItem>,private var context: Context  ): RecyclerView.Adapter<RecyclerAdapter.ViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_row,parent,false )
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.email.text = Data[position].email

        val name =   (Data[position].first_name + Data[position].last_name)
        holder.Name.text =name

        Glide.with(context).load(Data[position].avatar).fitCenter().into(holder.imageView)
//        holder.Salary.text = Data[position].employee_salary.toString()

    }



    override fun getItemCount(): Int {
        return Data.size
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name = itemView.findViewById<TextView>(R.id.name)

        var email= itemView.findViewById<TextView>(R.id.email)
        var imageView = itemView.findViewById<ImageView>(R.id.image)
//        var image = itemView.findViewById<ImageView>(androidx.appcompat.R.id.image)
    }

}