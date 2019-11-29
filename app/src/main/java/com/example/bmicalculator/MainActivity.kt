package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        calc_button.setOnClickListener {
            try {
                val in_weight = weightNum.text.toString()
                val in_height = heightNum.text.toString()

                val weight_num = in_weight.toDouble()
                val height_num = in_height.toDouble()
                val bmi_num: Double = weight_num / pow((height_num / 100), 2.0)


                val status: String


                if (bmi_num <= 18.5) {
                    bmi_img.setImageResource(R.drawable.under)
                    status = "Under weight"
                } else if (bmi_num > 18.5 && bmi_num <= 24.9) {
                    bmi_img.setImageResource(R.drawable.normal)
                    status = "Optimal weight"
                } else {
                    bmi_img.setImageResource(R.drawable.over)
                    status = "Over weight"
                }
                BMI_counter.text = "BMI : %.2f (%s)".format(bmi_num, status)
            }catch(ex:Exception)
            {
               val  toast:Toast = Toast.makeText(this,"Invalid Input",Toast.LENGTH_LONG)
                toast.setGravity(Gravity.CENTER,0,0)
                toast.show()
            }
        }
        res_button.setOnClickListener{
            BMI_counter.text = "BMI : "
            weightNum.setText("")
            heightNum.setText("")
            bmi_img.setImageResource(R.drawable.empty)

        }

    }



}
