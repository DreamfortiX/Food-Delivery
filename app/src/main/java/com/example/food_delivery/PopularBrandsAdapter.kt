package com.example.food_delivery

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PopularBrandsAdapter(
    private val context: Context,
    private val brandList: List<Brand>
) : RecyclerView.Adapter<PopularBrandsAdapter.BrandViewHolder>() {

    class BrandViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.brand_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_brand, parent, false)
        return BrandViewHolder(view)
    }

    override fun onBindViewHolder(holder: BrandViewHolder, position: Int) {
        val brand = brandList[position]

        // Using Glide to load the image
        Glide.with(context)
            .load(brand.img)
            .placeholder(R.drawable.kfc) // Your placeholder image
            .into(holder.imageView)

        holder.imageView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(brand.link))
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = brandList.size
}
