package com.example.food_delivery.Fragments

import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.food_delivery.BannerAdapter
import com.example.food_delivery.Brand
import com.example.food_delivery.PopularBrandsAdapter
import com.example.food_delivery.TopMealModel
import com.example.food_delivery.R
import com.example.food_delivery.TopMealsAdapter
import java.util.Timer
import java.util.TimerTask

class InstaGro : Fragment() {
    private lateinit var viewPager: ViewPager2
    private lateinit var dotsContainer: LinearLayout
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PopularBrandsAdapter
    private val bannerUrls = listOf(
        R.drawable.startd1,
        R.drawable.ic_splash,
        R.drawable.started3
    ) // Replace with actual image resource ids

    private val listMinds: String = listOf(
        R.drawable.kfc,
        R.drawable.domino_pizza,
        R.drawable.domino_pizza,
        R.drawable.domino_pizza,
        R.drawable.domino_pizza,
        R.drawable.domino_pizza,
    ).toString()
    private lateinit var bannerAdapter: BannerAdapter
    private var currentPage = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insta_gro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listBrands = listOf(
            Brand(R.drawable.kfc.toString(), "https://example.com/brand1"),
            Brand(R.drawable.kfc.toString(), "https://example.com/brand2"),
            Brand(R.drawable.kfc.toString(), "https://example.com/brand2"),
            Brand(R.drawable.kfc.toString(), "https://example.com/brand2"),
            Brand(R.drawable.kfc.toString(), "https://example.com/brand2"),
            Brand(R.drawable.kfc.toString(), "https://example.com/brand3")
            // Add more brands as needed
        )

        recyclerView = view.findViewById(R.id.popular_brands_recycler_view)
        adapter = PopularBrandsAdapter(requireContext(), listBrands)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        // Sample data for top meals
        val meals = listOf(
            TopMealModel.createRandom("Burger", R.drawable.burger),
            TopMealModel.createRandom("Biryani", R.drawable.biryani),
            TopMealModel.createRandom("Chinese", R.drawable.chinese),
            TopMealModel.createRandom("Cake", R.drawable.cake),
            TopMealModel.createRandom("Cake", R.drawable.cofee)
        )

        // Find RecyclerView for top meals
        val mealsRecyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        mealsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        // Set Adapter for top meals
        val mealsAdapter = TopMealsAdapter(meals)
        mealsRecyclerView.adapter = mealsAdapter

        // Initialize ViewPager
        viewPager = view.findViewById(R.id.viewPager)
        dotsContainer = view.findViewById(R.id.dots_container)

        bannerAdapter = BannerAdapter(bannerUrls)
        viewPager.adapter = bannerAdapter
        setupDots(bannerUrls.size)

        // Auto-slide effect
        autoSlideImages()



        recyclerView = view.findViewById(R.id.recycler_view2)
        adapter = PopularBrandsAdapter(requireContext(), listBrands)
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter
    }

    private fun setupDots(count: Int) {
        dotsContainer.removeAllViews() // Clear any existing dots
        for (i in 0 until count) {
            val dot = View(requireContext()).apply {
                background = ContextCompat.getDrawable(context, R.drawable.dot_inactive)
                layoutParams = LinearLayout.LayoutParams(16, 16).apply {
                    marginStart = 8
                    marginEnd = 8
                }
            }
            dotsContainer.addView(dot)
        }
        selectDot(0)
    }

    private fun selectDot(index: Int) {
        for (i in 0 until dotsContainer.childCount) {
            val dot = dotsContainer.getChildAt(i)
            dot.background = ContextCompat.getDrawable(
                requireContext(),
                if (i == index) R.drawable.dot_active else R.drawable.dot_inactive
            )
        }
    }

    private fun autoSlideImages() {
        val handler = Handler(Looper.getMainLooper())
        val update = Runnable {
            if (currentPage >= bannerUrls.size) {
                currentPage = 0
            }
            viewPager.setCurrentItem(currentPage++, true)
        }

        Timer().schedule(object : TimerTask() {
            override fun run() {
                handler.post(update)
            }
        }, 2000, 2000) // Adjust the interval time as needed

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                currentPage = position
                selectDot(position)
            }
        })
    }

}