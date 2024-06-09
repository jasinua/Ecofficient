package com.example.ecofficient

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class HomePage : Fragment() {

    private lateinit var databaseReference: DatabaseReference

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home_page, container, false)

        databaseReference = FirebaseDatabase.getInstance().getReference("OpenOrClosed")

        view.findViewById<CardView>(R.id.cardViewLightSensor).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_homePage_to_lightSensorFragment)

        }

        view.findViewById<CardView>(R.id.cardViewTemperaure).setOnClickListener {

            Navigation.findNavController(view).navigate(R.id.action_homePage_to_temperatureFragment)

        }

        var i = 1
        view.findViewById<CardView>(R.id.doorControl).setOnClickListener {

            i += 1
            if (i % 2 == 0) {
                databaseReference.child("?").setValue("0").addOnCompleteListener {

                }.addOnFailureListener {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                databaseReference.child("?").setValue("1").addOnCompleteListener {

                }.addOnFailureListener(){
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return view;
    }
}