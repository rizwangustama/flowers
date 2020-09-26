package com.dicoding.myflowers2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListFlowerAdapter(val listFlower: ArrayList<Flower>) : RecyclerView.Adapter<ListFlowerAdapter.ListViewAdapter>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewAdapter {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_flower,viewGroup,false)
        return ListViewAdapter(view)
    }

    override fun getItemCount(): Int {
        return listFlower.size
    }

    override fun onBindViewHolder(holder: ListViewAdapter, position: Int) {
        val (name, spesies, photo, overview, identity) = listFlower[position]

        Glide.with(holder.itemView.context)
                .load(photo)
                .apply(RequestOptions())
                .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvspesies.text = spesies

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_flower::class.java)
            moveDetail.putExtra(detail_flower.EXTRA_NAME, name)
            moveDetail.putExtra(detail_flower.EXTRA_SPESIES, spesies)
            moveDetail.putExtra(detail_flower.EXTRA_PHOTO, photo)
            moveDetail.putExtra(detail_flower.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(detail_flower.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewAdapter(itemView: View) : RecyclerView.ViewHolder(itemView){
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvspesies : TextView = itemView.findViewById(R.id.tv_item_spesies)
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)

    }
}