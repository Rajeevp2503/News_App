package com.example.news_app

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide

class MyAdpater(val context : Context, val articless : List<articles>): Adapter<MyViewHolder>() {


    //OnCreateHolder create view for us
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        //layout inflater takes xml file and changes to java object ........
        val inflater : LayoutInflater = LayoutInflater.from(parent.context)
        val view :View = inflater.inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
       return articless.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val art = articless[position]



        holder.txtTitile.text = art.title
        holder.txtdesc.text =art.description
        Glide.with(context).load(art.urlToImage).into(holder.Image)
    }


}
class MyViewHolder(itemView: View) : ViewHolder(itemView){
    var txtTitile= itemView.findViewById<TextView>(R.id.title)
    var txtdesc  = itemView.findViewById<TextView>(R.id.desc)
    var Image  = itemView.findViewById<ImageView>(R.id.newsImage)

}