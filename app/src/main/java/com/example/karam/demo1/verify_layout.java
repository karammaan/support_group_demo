package com.example.karam.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class verify_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_layout);
        Button register_button = (Button) findViewById(R.id.register_login);

        final View.OnClickListener onbtn_click= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.register_login)
                {
                    Intent i = new Intent(verify_layout.this , Signup_details.class);


                    startActivity(i);


                }


            }
        };

        register_button.setOnClickListener(onbtn_click);
    }
}


