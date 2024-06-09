package com.example.ecofficient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TemperatureFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_temperature, container, false)

        val dbRef = FirebaseDatabase.getInstance().getReference("Sensor")

        dbRef.child("humidity_data").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                view.findViewById<TextView>(R.id.humidity).text =
                    "Humidity: " + snapshot.getValue().toString() + "%"

            }
            override fun onCancelled(error: DatabaseError) {
            }
        })

        var x = 0

        dbRef.child("temperature_data").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                view.findViewById<TextView>(R.id.getTemperature1).text =
                    snapshot.child("0").getValue().toString() + " °C"
                view.findViewById<TextView>(R.id.getTemperature2).text =
                    snapshot.child("1").getValue().toString() + " °C"
                view.findViewById<TextView>(R.id.getTemperature3).text =
                    snapshot.child("2").getValue().toString() + " °C"
                view.findViewById<TextView>(R.id.getTemperature4).text =
                    snapshot.child("3").getValue().toString() + " °C"
                view.findViewById<TextView>(R.id.getTemperature5).text =
                    snapshot.child("4").getValue().toString() + " °C"


                view.findViewById<TextView>(R.id.averageTemperature).text =
                    snapshot.child("avg").getValue().toString() + " °C"

                view.findViewById<TextView>(R.id.averageTemperature).setOnClickListener {

                    var y = snapshot.child("avg").getValue().toString().toDouble()
                    if (x % 2 == 0) {
                        y = ((9 / 5) * y) + 32
                        view.findViewById<TextView>(R.id.averageTemperature).text = "" + y + "°F"

                    } else {
                        y = snapshot.child("avg").getValue().toString().toDouble()
                        view.findViewById<TextView>(R.id.averageTemperature).text = "" + y + "°C "
                    }
                    x++
                }

            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        return view;
    }
}