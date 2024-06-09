package com.example.ecofficient

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LightSensorFragment : Fragment() {


    private lateinit var databaseReference: DatabaseReference
    private lateinit var databaseReference2: DatabaseReference


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_light_sensor, container, false)

        databaseReference = FirebaseDatabase.getInstance().getReference("RGB")

        databaseReference2 = FirebaseDatabase.getInstance().getReference("Sensor")

        val rgb = "RGB"

        val map1 = mapOf(
            "R" to 255, "G" to 138, "B" to 18
        )
        val map2 = mapOf(
            "R" to 255, "G" to 180, "B" to 107
        )
        val map3 = mapOf(
            "R" to 255, "G" to 209, "B" to 163
        )
        val map4 = mapOf(
            "R" to 255, "G" to 228, "B" to 206
        )
        val map5 = mapOf(
            "R" to 255, "G" to 243, "B" to 239
        )
        val map6 = mapOf(
            "R" to 255, "G" to 255, "B" to 255
        )
        val map7 = mapOf(
            "R" to 227, "G" to 233, "B" to 255
        )
        val map8 = mapOf(
            "R" to 214, "G" to 225, "B" to 255
        )

        view.findViewById<View>(R.id.warmth1).setOnClickListener {

            savePostData(rgb, map1)
        }
        view.findViewById<View>(R.id.warmth2).setOnClickListener {

            savePostData(rgb, map2)
        }
        view.findViewById<View>(R.id.warmth3).setOnClickListener {

            savePostData(rgb, map3)
        }
        view.findViewById<View>(R.id.warmth4).setOnClickListener {

            savePostData(rgb, map4)
        }
        view.findViewById<View>(R.id.warmth5).setOnClickListener {

            savePostData(rgb, map5)
        }
        view.findViewById<View>(R.id.warmth6).setOnClickListener {

            savePostData(rgb, map6)
        }
        view.findViewById<View>(R.id.warmth7).setOnClickListener {

            savePostData(rgb, map7)
        }
        view.findViewById<View>(R.id.warmth8).setOnClickListener {

            savePostData(rgb, map8)
        }

        val onoffButton = view.findViewById<Switch>(R.id.onoffbutton)

        onoffButton.setOnClickListener {

            if (onoffButton.isChecked) {
                databaseReference2.child("OnOff").setValue("1").addOnCompleteListener {

                }.addOnFailureListener {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            } else {
                databaseReference2.child("OnOff").setValue("0").addOnCompleteListener {

                }.addOnFailureListener {
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view;
    }

    private fun savePostData(rgb: String, map: Map<String, Int>) {

        databaseReference.child("R").setValue(map.getValue("R")).addOnCompleteListener {

        }.addOnFailureListener {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }

        databaseReference.child("G").setValue(map.getValue("G")).addOnCompleteListener {

        }.addOnFailureListener {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }

        databaseReference.child("B").setValue(map.getValue("B")).addOnCompleteListener {

        }.addOnFailureListener {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}