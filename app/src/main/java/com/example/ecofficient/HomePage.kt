package com.example.ecofficient

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation

class HomePage : Fragment() {



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)


        view.findViewById<CardView>(R.id.cardViewLightSensor).setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_homePage_to_lightSensorFragment)

        }


        view.findViewById<CardView>(R.id.cardViewTemperaure).setOnClickListener{

            Navigation.findNavController(view).navigate(R.id.action_homePage_to_temperatureFragment)

        }



        return view;
    }
}