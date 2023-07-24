package com.restaurant_menu

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class food_details : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)

        val bundle:Bundle? = intent.extras
        findViewById<ImageView>(R.id.ivimage).setImageResource(bundle!!.getInt("image"))
        findViewById<TextView>(R.id.tvtittle).text=(bundle.getString("name"))
        findViewById<TextView>(R.id.tvdescription).text=(bundle.getString("des"))
    }
}