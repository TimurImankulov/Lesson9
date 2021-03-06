package com.example.lesson9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    var spCities:Spinner? = null
    var tvNameOfCity:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        setUpSpinner()
        chooseCity()
    }

    private fun initView(){
        spCities = findViewById<Spinner>(R.id.spCities)
        tvNameOfCity = findViewById<TextView>(R.id.tvNameOfCity)
    }

    private fun setUpSpinner(){
        val adapter = ArrayAdapter.createFromResource(this, R.array.cities, android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spCities?.adapter = adapter
    }

    private fun chooseCity(){
        spCities?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {

                        if (position!=0)
                        tvNameOfCity?.text = parent.getItemAtPosition(position).toString()

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

}