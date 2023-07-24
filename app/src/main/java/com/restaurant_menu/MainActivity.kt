package com.restaurant_menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class FoodAdapter {

}

class MainActivity : AppCompatActivity() {
    lateinit var adapter :FoodAdapter
    var listOfFoods=ArrayList<foods>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // load foods
        listOfFoods.add(foods("Coffee","   Coffee made from fine grind coffee beans",R.drawable.coffe))
        listOfFoods.add(foods("Espersso","    Espresso’s heavenly made drink" ,R.drawable.kettle))
        listOfFoods.add(foods("French Fires","  made from locally grown fresh potatoes ",R.drawable.fries))
        listOfFoods.add(foods("Honey"," taste world class sweetness:",R.drawable.honeypot))
        listOfFoods.add(foods("Strawberry","   enjoy our strawberry icecream.",R.drawable.berries))
        listOfFoods.add(foods("Sugar cubes","Sugar cubes ",R.drawable.icecubes))
        adapter= FoodAdapter(this,listOfFoods)
        //Assign our list to the gridview id

        findViewById<GridView>(R.id.gridV).adapter =adapter



    }

    class  FoodAdapter: BaseAdapter {
        var listOfFood= ArrayList<foods>()
        var context: Context?=null
        constructor(context: Context, listOfFood:ArrayList<foods>):super(){
            this.context=context
            this.listOfFood=listOfFood
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val food = this.listOfFood[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var foodView= inflator.inflate(R.layout.food_ticket,null)
            foodView.findViewById<ImageView>(R.id.ivfooodimage).setImageResource(food.image!!)
            foodView.findViewById<ImageView>(R.id.ivfooodimage).setOnClickListener {

                val intent = Intent(context,food_details::class.java)
                intent.putExtra("name",food.name!!)
                intent.putExtra("des",food.des!!)
                intent.putExtra("image",food.image!!)
                context!!.startActivity(intent)
            }
            foodView.findViewById<TextView>(R.id.tvName).text =  food.name!!
            return  foodView

        }

        override fun getItem(p0: Int): Any {
            return listOfFood[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return listOfFood.size
        }
    }}