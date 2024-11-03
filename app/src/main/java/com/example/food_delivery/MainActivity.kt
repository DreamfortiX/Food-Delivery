package com.example.food_delivery

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.food_delivery.Fragments.Categories
import com.example.food_delivery.Fragments.InstaGro
import com.example.food_delivery.Fragments.Offer
import com.example.food_delivery.Fragments.Record
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var imageView: ImageView

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Set up bottom navigation with NavController
        val navController = findNavController(R.id.nav_host_fragment)
        bottomNavigationView.setupWithNavController(navController)
    }

//
//        val selectedColor = ContextCompat.getColor(this, R.color.selectedColor)
//        val unselectedColor = ContextCompat.getColor(this, R.color.unselectedColor)
//
//        bottomNavigationView = findViewById(R.id.bottomNavigationView)
//
//        // Initialize the first fragment
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, InstaGro()) // Default fragment
//                .commit()
//        }
//
//        bottomNavigationView.setOnItemSelectedListener { item ->
//            // Reset all items to unselected color
//            for (i in 0 until bottomNavigationView.menu.size()) {
//                bottomNavigationView.menu.getItem(i).iconTintList =
//                    ColorStateList.valueOf(unselectedColor)
//
//                bottomNavigationView.menu.getItem(i).title = HtmlCompat.fromHtml(
//                    "<font color='${unselectedColor.toString()}'>" + bottomNavigationView.menu.getItem(
//                        i
//                    ).title + "</font>",
//                    HtmlCompat.FROM_HTML_MODE_LEGACY
//                )
//            }
//
//            // Set selected item to selected color
//            item.iconTintList = ColorStateList.valueOf(selectedColor)
//            item.title = HtmlCompat.fromHtml(
//                "<font color='${selectedColor.toString()}'>" + item.title + "</font>",
//                HtmlCompat.FROM_HTML_MODE_LEGACY
//            )
//
//            // Handle fragment transactions
//            when (item.itemId) {
//                R.id.instaGro -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.nav_host_fragment, InstaGro())
//                        .commit()
//                    bottomNavigationView.removeBadge(item.itemId)
//                }
//
//                R.id.categories_bar -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.nav_host_fragment, Categories())
//                        .commit()
//                    bottomNavigationView.removeBadge(item.itemId)
//                }
//
//                R.id.record_bar -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.nav_host_fragment, Record())
//                        .commit()
//                    bottomNavigationView.removeBadge(item.itemId)
//                }
//
//                R.id.offer_bar -> {
//                    supportFragmentManager.beginTransaction()
//                        .replace(R.id.nav_host_fragment, Offer())
//                        .commit()
//                    bottomNavigationView.removeBadge(item.itemId)
//                }
//            }
//            true
//        }
override fun onSupportNavigateUp(): Boolean {
    return findNavController(R.id.nav_host_fragment).navigateUp() || super.onSupportNavigateUp()
}
    }