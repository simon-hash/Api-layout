package com.example.api_layout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    val foodList = arrayListOf(
            "Indisches Curry", "Burger", "Maultaschen",
            "Spaghetti", "Minestrone", "Steak"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        decide.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            Foodid.text = foodList[randomFood]
        }

        totutorial.setOnClickListener {
            val cont = Foodid.text
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(SecondActivity.FOOD_Name,cont)
            startActivity(intent)
        }

    }
}