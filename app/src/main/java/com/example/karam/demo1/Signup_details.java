package com.example.karam.demo1;

import android.content.Intent;
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

public class Signup_details extends AppCompatActivity {

    String mobile ;
    EditText username_id , gender_id , password_id , confirm_password_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_details);

        mobile = getIntent().getStringExtra("mobile_key");

         username_id=(EditText) findViewById(R.id.username_id);
         gender_id=(EditText) findViewById(R.id.gender_id);
         password_id=(EditText) findViewById(R.id.password_id);
        confirm_password_id=(EditText) findViewById(R.id.confirm_password_id);


    }

    public void register(View v)
    {
        String username = username_id.getText().toString();

        String gender = gender_id.getText().toString();

        String password = password_id.getText().toString();

        String confirm_password = confirm_password_id.getText().toString();

        if(username.equals(""))
        {
            Toast.makeText(Signup_details.this , "please enter username" , Toast.LENGTH_SHORT).show();

            return;
        }

        if(gender.equals(""))
        {
            Toast.makeText(Signup_details.this , "please enter gender" , Toast.LENGTH_SHORT).show();

            return;
        }
        if(password.equals(""))
        {
            Toast.makeText(Signup_details.this , "please enter password" , Toast.LENGTH_SHORT).show();

            return;
        }
        if(confirm_password.equals(""))
        {
            Toast.makeText(Signup_details.this , "please enter confirm password" , Toast.LENGTH_SHORT).show();

            return;
        }
        if( ! password.equals(confirm_password))
        {
            Toast.makeText(Signup_details.this , "password do not match" , Toast.LENGTH_SHORT).show();

            return;
        }

        JSONObject job = new JSONObject();

        try {
            job.put("name_key" , username);
            job.put("mobile_key" , mobile);
            job.put("pass_key", password);
            job.put("gender_key" , gender);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);

        JsonObjectRequest jobreq = new JsonObjectRequest("http://192.168.0.24/signup.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("1"))
                    {
                        Intent i = new Intent(Signup_details.this , home_layout.class);
                        startActivity(i);
                        finish();
                    }

                    else {

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2 , 2));

        AppController app = new AppController(Signup_details.this);
        app.addToRequestQueue(jobreq);



    }
}


