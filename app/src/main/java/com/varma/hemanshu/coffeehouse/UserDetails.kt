package com.varma.hemanshu.coffeehouse

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText

/**
 * This Activity is for gathering User Details.
 */
class UserDetails : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userdetails)
    }

    //Triggered from XML
    fun userActivity(view: View) {
        val nameFromEditText = findViewById<EditText>(R.id.NameField)
        val name = nameFromEditText.text.toString()
        val phoneNoFromEditText = findViewById<EditText>(R.id.PhoneNo)
        val phoneNo = phoneNoFromEditText.text.toString()
        when {
            name.isBlank() -> {
                nameFromEditText.error = "Required"
            }
            phoneNo.isBlank() -> {
                phoneNoFromEditText.error = "Required"
            }
            else -> {
                val myIntent = Intent(this, MainActivity::class.java)
                myIntent.putExtra("NAME", name)
                myIntent.putExtra("PHONE_NO", phoneNo)
                startActivity(myIntent)
            }
        }
    }
}