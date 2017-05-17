package com.example.karam.demo1;

import android.app.Activity;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class profile_edit_layout extends AppCompatActivity {


    private ImageView iv;

    private String image_s = "";
    EditText name, email, bio, mobile, gender;
    Button update_et, upload_et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit_layout);
        iv = (ImageView) findViewById(R.id.image_edit);
        upload_et = (Button) findViewById(R.id.upload_image);
        update_et = (Button) findViewById(R.id.done_button);

        name = (EditText) findViewById(R.id.name_id);
        email = (EditText) findViewById(R.id.email_id);
        bio = (EditText) findViewById(R.id.bio_id);
        mobile = (EditText) findViewById(R.id.mobile_id);
        gender = (EditText) findViewById(R.id.gender_id);

        get_profile();


    }

    public void get_profile() {
        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);

        String user_id = sp.getString("user_id", "");


        JSONObject job = new JSONObject();
        try {
            job.put("user_id", user_id);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.println(job);
        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Internet_address.ip + "/get_profile.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    JSONObject job = response.getJSONObject("result");
                    String email_s = job.getString("Email_Id");
                    String name_s = job.getString("Name");
                    String contact_s = job.getString("Contact_no");
                    String gender_s = job.getString("Gender");
                    String bio_s = job.getString("Bio");
                    String image = job.getString("Image_upload");

                    Bitmap bmp = StringToBitMap(image);

                    name.setText(name_s);
                    email.setText(email_s);
                    gender.setText(gender_s);
                    mobile.setText(contact_s);
                    bio.setText(bio_s);

                    iv.setImageBitmap(bmp);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);
            }
        });
        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000, 2, 2));

        AppController app = new AppController(profile_edit_layout.this);
        app.addToRequestQueue(jobreq);


    }

    // function to convert string image into bitmap image
    public Bitmap StringToBitMap(String encodedString) {
        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    public void update_profile(View v) {


        String name_et = name.getText().toString();

        String gender_et = gender.getText().toString();

        String mobile_et = mobile.getText().toString();

        String bio_et = bio.getText().toString();
        String email_et = email.getText().toString();

        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);

        String user_id = sp.getString("user_id", "");


        JSONObject job = new JSONObject();

        try {
            job.put("name_key", name_et);
            job.put("mobile_key", mobile_et);
            job.put("email_key", email_et);
            job.put("gender_key", gender_et);
            job.put("bio_key", bio_et);
            job.put("user_id", user_id);


        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);

        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Internet_address.ip + "/update_profile.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if (response.getString("key").equals("1")) {

                        Toast.makeText(profile_edit_layout.this , "profile updated successfully" ,Toast.LENGTH_SHORT).show();



                    } else {

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);

            }
        });

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000, 2, 2));

        AppController app = new AppController(profile_edit_layout.this);
        app.addToRequestQueue(jobreq);


    }
}