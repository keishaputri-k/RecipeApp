package com.kei.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val list = ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        rv_main.setHasFixedSize(true)
        list.addAll(getRecipe())
        showRecycler()
    }

    private fun showRecycler() {
        rv_main.layoutManager = LinearLayoutManager(this)
        val listRecipe = ItemAdapter(list)
        rv_main.adapter = listRecipe
    }
    private fun getRecipe(): ArrayList<Recipe>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_description)
        val dataIngredients = resources.getStringArray(R.array.data_ingredients)
        val dataSteps = resources.getStringArray(R.array.data_steps)
        val dataRating = resources.getIntArray(R.array.data_rating)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listRecipes = ArrayList<Recipe>()
        for (position in dataName.indices){
            val recipes = Recipe(
                    dataName[position],
                    dataDesc[position],
                    dataIngredients[position],
                    dataSteps[position],
                    dataRating[position],
                    dataPhoto[position]
            )
            listRecipes.add(recipes)
        }
        return listRecipes
    }
}