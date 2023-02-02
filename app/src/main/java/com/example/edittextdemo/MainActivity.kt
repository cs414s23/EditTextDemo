package com.example.edittextdemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // This function runs when the button is clicked
    fun showInfo(view: View) {
        // Get user input from the EditTexts
        val personName = name.text
        val personAge = age.text.toString().toIntOrNull()
        
        if (personAge == null) {
            Toast.makeText(this, "Please enter your age", Toast.LENGTH_SHORT).show()
            return
        } 
        
        // Finally display the information
        feedback.text = "Hello $personName, your age is $personAge"

        // Clear the EditTexts
        name.text.clear()
        age.text.clear()

        // Hide the keyboard
        age.hideKeyboard()

    }

    // Helper function to hide the keyboard for any view/widget
    private fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

}