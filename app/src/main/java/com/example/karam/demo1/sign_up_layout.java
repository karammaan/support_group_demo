package com.example.karam.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class sign_up_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_layout);
        Button verify_button = (Button) findViewById(R.id.verify_login);

        final View.OnClickListener onbtn_click= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.verify_login)
                {
                    Intent i = new Intent(sign_up_layout.this , verify_layout.class);


                    startActivity(i);


                }


            }
        };

        verify_button.setOnClickListener(onbtn_click);
    }
}



