package com.example.karam.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login_layout extends AppCompatActivity {
 private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        Button login = (Button) findViewById(R.id.button_login);

        final View.OnClickListener onbtn_click= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.button_login)
                {

                    Intent i = new Intent(login_layout.this , home_layout.class);


                    startActivity(i);


                }


            }
        };

        login.setOnClickListener(onbtn_click);
    }
}



