package com.example.karam.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Signup_details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_details);
        Button finish_button = (Button) findViewById(R.id.finish_layout);

        final View.OnClickListener onbtn_click= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.finish_layout)
                {
                    Intent i = new Intent(Signup_details.this , home_layout.class);


                    startActivity(i);


                }


            }
        };

        finish_button.setOnClickListener(onbtn_click);
    }
}


