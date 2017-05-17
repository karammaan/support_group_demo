package com.example.karam.demo1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Group_chat extends AppCompatActivity {

    public TextView group_name ;
    EditText chat_et;
    RecyclerView recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_chat);
        chat_et=(EditText)  findViewById(R.id.chat_et);
        recycle=(RecyclerView) findViewById(R.id.recycler_id);

        recycle.setLayoutManager(new LinearLayoutManager(Group_chat.this , LinearLayoutManager.VERTICAL , false));

        group_name = (TextView)  findViewById(R.id.group_name);
        String name = getIntent().getStringExtra("group_name");

        group_name.setText(name);

        get_chat();


    }
    public void close(View v){
        finish();

    }
    public void send_chat(View v){

        String chat = chat_et.getText().toString();

        String group_id = getIntent().getStringExtra("group_id");

        SharedPreferences sp = getSharedPreferences("user_info",MODE_PRIVATE);

         String user_id =  sp.getString("user_id","");





        JSONObject job = new JSONObject();
        try {
            job.put("chat_key", chat);
            job.put("group_id" , group_id);
            job.put("user_id" , user_id);

        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq =new JsonObjectRequest("http://" + Internet_address.ip + "/add_chat.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if (response.getString("key").equals("1")){
                        Toast.makeText(Group_chat.this,"message sent",Toast.LENGTH_SHORT).show();

                        get_chat();
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

        AppController app = new AppController(Group_chat.this);
        app.addToRequestQueue(jobreq);




    }


    public void get_chat()
    {

        String group_id = getIntent().getStringExtra("group_id");

        JSONObject job = new JSONObject();
        try {

            job.put("group_id" , group_id);


        }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobreq =new JsonObjectRequest("http://" + Internet_address.ip + "/get_group_chat.php", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {

                    JSONArray jarr  = response.getJSONArray("result");

                    group_chat_adapter ad = new group_chat_adapter(jarr , Group_chat.this);

                    recycle.setAdapter(ad);


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

        AppController app = new AppController(Group_chat.this);
        app.addToRequestQueue(jobreq);



    }
}
