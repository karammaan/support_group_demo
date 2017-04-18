package com.example.karam.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class sign_up_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_layout);
    }

    public void verify_button(View v) {


        EditText mobile_id = (EditText) findViewById(R.id.mobile_id);

        String mobile = mobile_id.getText().toString();

        if (mobile.length() < 10) {
            Toast.makeText(sign_up_layout.this, "please enter valid mobile number", Toast.LENGTH_SHORT).show();

            return;
        }

        int randompin =   (int) (((Math.random())*9000)+1000);

        Intent i = new Intent(sign_up_layout.this , verify_layout.class);

        i.putExtra("mobile_key" , mobile);

        i.putExtra("pin_key" , randompin);

        startActivity(i);
        finish();

    }
}



