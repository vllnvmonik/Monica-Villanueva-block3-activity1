package com.villanueva.monica.block3.p1.quiz

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etHeight: EditText
    private lateinit var etWeight: EditText
    private lateinit var btnCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etHeight = findViewById(R.id.et_height)
        etWeight = findViewById(R.id.et_weight)
        btnCalculate = findViewById(R.id.btn_calculate)


        btnCalculate.setOnClickListener {
            if (heightAndWeightValidation()) {
                resultDialogBox()
                Log.d("CALC", "SDFSDFSF")
            }
        }


    }
    private fun resultDialogBox(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.result_dialog_box)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

//        val tvResult = dialog.findViewById(R.id.tv_result) as TextView
        val btnDone = dialog.findViewById(R.id.btn_done) as Button

        btnDone.setOnClickListener {
            dialog.dismiss()
            etWeight.setText("")
            etHeight.setText("")
        }
    dialog.show()
    }

    private fun heightAndWeightValidation(): Boolean {
        val height = etHeight.text.toString().trim()
        val weight = etWeight.text.toString().trim()

        if (height.isEmpty() || weight.isEmpty()) {
            Toast.makeText(this, "Input height and weight", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

}