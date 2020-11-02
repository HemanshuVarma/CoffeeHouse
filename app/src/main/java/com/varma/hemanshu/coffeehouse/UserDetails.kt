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
    fun userActivity(view: View?) {
        val myIntent = Intent(this, MainActivity::class.java)
        val nameFromEditText = findViewById<EditText>(R.id.NameField)
        val name = nameFromEditText.text.toString()
        val phoneNoFromEditText = findViewById<EditText>(R.id.PhoneNo)
        val phoneNo = phoneNoFromEditText.text.toString()
        myIntent.putExtra("NAME", name)
        myIntent.putExtra("PHONE_NO", phoneNo)
        startActivity(myIntent)
    }
}