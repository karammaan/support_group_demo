package com.example.karam.demo1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class home_layout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        ImageView login= (ImageView) findViewById(R.id.profile_layout);

        final View.OnClickListener onbtn_click= new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v.getId() == R.id.profile_layout)
                {

                    Intent i = new Intent(home_layout.this , profile_edit_layout.class);


                    startActivity(i);


                }


            }
        };

        login.setOnClickListener(onbtn_click);
    }
}

