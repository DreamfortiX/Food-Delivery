
package com.example.food_delivery
import kotlin.random.Random

data class TopMealModel(val name: String, val color: androidx.compose.ui.graphics.Color, val image: Int) {
    companion object {
        fun createRandom(name: String, image: Int): TopMealModel {
            // Select a random color from the colorsList
            val randomColor = colorsList[Random.nextInt(colorsList.size)]
            return TopMealModel(name, randomColor, image)
        }
    }
}
