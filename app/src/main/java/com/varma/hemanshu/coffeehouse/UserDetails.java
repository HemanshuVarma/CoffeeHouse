package com.varma.hemanshu.coffeehouse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * This Activity is for Collecting User Details.
 */

public class UserDetails extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userdetails);

    }

    public void UserActivity(View view) {
        Intent MyIntent = new Intent(UserDetails.this, MainActivity.class);
        EditText nameFromEditText = findViewById(R.id.NameField);
        String name = nameFromEditText.getText().toString();
        EditText phone_NoFromEditText = findViewById(R.id.PhoneNo);
        String phone_no = phone_NoFromEditText.getText().toString();
        MyIntent.putExtra("Name", name);
        MyIntent.putExtra("Phone_No", phone_no);
        startActivity(MyIntent);
    }
}
