package com.example.ecommerce

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val content: Activity, val productList: List<Product>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Called when a new ViewHolder is created
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(content).inflate(R.layout.each_view, parent, false)
        return MyViewHolder(itemView)
    }

    // Returns the total number of items in the list
    override fun getItemCount(): Int {
        return productList.size
    }

    // Binds data to the ViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = productList[position]
        holder.title.text = currentItem.title
        //show image as well
        //to put links into imageViews, use third party library picasso
        Picasso.get().load(currentItem.thumbnail).into(holder.image)
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ShapeableImageView = itemView.findViewById(R.id.product)
        var title: TextView = itemView.findViewById(R.id.productName)
    }
}
