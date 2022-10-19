package com.example.divmm.view

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.divmm.databinding.ListItemBinding
import com.example.divmm.model.responseProductItem

class ListAdapter(var listcar : List<responseProductItem>): RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    var onDelete : ((responseProductItem)->Unit)? = null
    var onDetail : ((responseProductItem)->Unit)? = null

    class ViewHolder(var binding : ListItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        var view = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        holder.binding.nameCar.text = listcar!![position].name
        holder.binding.categoryCar.text = listcar!![position].category
        holder.binding.priceCar.text = listcar!![position].price.toString()
        Glide.with(holder.itemView.context).load(listcar!![position].imageLink).into(holder.binding.imgCar)

//        holder.binding.deleteCar.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(v: View?) {
//                val bun = Bundle()
//                bun.putString("id", listcar[position].id.toString())
//            }
//        })

    }

    override fun getItemCount(): Int {

        return listcar.size

    }
}