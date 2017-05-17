package com.example.karam.demo1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

public class user_forgot_password extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_forgot_password);

    }
    public void verify_button(View v) {


        EditText mobile_id = (EditText) findViewById(R.id.mobile_id);

        String mobile = mobile_id.getText().toString();

        if (mobile.length() < 10) {
            Toast.makeText(user_forgot_password.this, "please enter valid mobile number", Toast.LENGTH_SHORT).show();

            return;
        }

        int randompin =   (int) (((Math.random())*9000)+1000);

        Intent i = new Intent(user_forgot_password.this ,forgot_password_user_verify.class);

        i.putExtra("mobile_key" , mobile);

        i.putExtra("pin_key" , randompin);

        startActivity(i);
        finish();

    }
}