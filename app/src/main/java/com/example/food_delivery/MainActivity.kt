package com.example.food_delivery

import android.content.res.ColorStateList
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.example.food_delivery.Fragments.Categories
import com.example.food_delivery.Fragments.InstaCho
import com.example.food_delivery.Fragments.InstaGro
import com.example.food_delivery.Fragments.Offer
import com.example.food_delivery.Fragments.Record
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var  imageView: ImageView
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val selectedColor = ContextCompat.getColor(this, R.color.selectedColor)
        val unselectedColor = ContextCompat.getColor(this, R.color.unselectedColor)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener { item ->
            // Reset all items to unselected color
            for (i in 0 until bottomNavigationView.menu.size()) {
                bottomNavigationView.menu.getItem(i).iconTintList = ColorStateList.valueOf(unselectedColor)

                bottomNavigationView.menu.getItem(i).title = HtmlCompat.fromHtml(
                    "<font color='${unselectedColor.toString()}'>" + bottomNavigationView.menu.getItem(i).title + "</font>",
                    HtmlCompat.FROM_HTML_MODE_LEGACY
                )
            }

            // Set selected item to selected color
            item.iconTintList = ColorStateList.valueOf(selectedColor)
            item.title = HtmlCompat.fromHtml(
                "<font color='${selectedColor.toString()}'>" + item.title + "</font>",
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )

            when (item.itemId) {
                R.id.instaGro -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, InstaGro())
                        .commit()
                }
                R.id.categories -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, Categories())
                        .commit()
                }
                R.id.record -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, Record())
                        .commit()
                }
                R.id.offer -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.nav_host_fragment, Offer())
                        .commit()
                }
            }
            true
        }

    }
}