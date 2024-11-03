package com.example.food_delivery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.ui.graphics.toArgb
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class TopMealsAdapter(private val meals: List<TopMealModel>) : RecyclerView.Adapter<TopMealsAdapter.TopMealViewHolder>() {

    class TopMealViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: CircleImageView = view.findViewById(R.id.meal_image)
        val name: TextView = view.findViewById(R.id.meal_name)
//        val color:CardView =view.findViewById(R.id.relative_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopMealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_top_meal, parent, false)
        return TopMealViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopMealViewHolder, position: Int) {
        val meal = meals[position]
        // Use Glide to load the image
        Glide.with(holder.itemView.context)
            .load(meal.image) // Image URL
            .into(holder.image) // Set image to ImageView
        holder.name.text = meal.name
        holder.image.setBackgroundColor(meal.color.toArgb()) // Set background color
    }

    override fun getItemCount() = meals.size
}
