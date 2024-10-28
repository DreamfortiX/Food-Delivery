package com.example.food_delivery

import OnboardingAdapter
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton

class activity_onboarding : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var dotIndicator: LinearLayout
    private lateinit var onboardingAdapter: OnboardingAdapter

    private val onboardingItems = listOf(
        OnboardingItem(R.drawable.startd1, "Insta Chow", "Food", "Grocery", "Dine-out", "Order from top restaurants."),
        OnboardingItem(R.drawable.started2, "Explore", "Description 1", "Description 2", "Description 3", "Detail description."),
        OnboardingItem(R.drawable.started3, "Get Started", "Description 1", "Description 2", "Description 3", "Detail description.")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_onboarding)
        // Initialize Views
        viewPager = findViewById(R.id.viewPager)
        dotIndicator = findViewById(R.id.dotIndicator) // Initialize dotIndicator

        // Initialize Adapter
        onboardingAdapter = OnboardingAdapter(onboardingItems) { position ->
            viewPager.currentItem = position
        }

        viewPager.adapter = onboardingAdapter

        setupDotIndicator()

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                updateDotIndicator(position)
            }
        })
    }

    private fun setupDotIndicator() {
        for (i in onboardingItems.indices) {
            val dot = ImageView(this)
            dot.setImageResource(R.drawable.dot_inactive) // Replace with your inactive dot drawable
            val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
            params.setMargins(8, 0, 8, 0)
            dotIndicator.addView(dot, params)
        }
    }

    private fun updateDotIndicator(position: Int) {
        for (i in 0 until dotIndicator.childCount) {
            val dot = dotIndicator.getChildAt(i) as ImageView
            dot.setImageResource(if (i == position) R.drawable.dot_active else R.drawable.dot_inactive)
        }
    }
}