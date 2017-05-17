package com.example.karam.demo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Expert_groups extends AppCompatActivity {

    RecyclerView recycle ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expert_groups);

        recycle = (RecyclerView) findViewById(R.id.expert_recycle);
        recycle.setLayoutManager(new LinearLayoutManager(Expert_groups.this , LinearLayoutManager.VERTICAL, false));

        get_data();
    }

    public  void get_data()
    {


        JsonObjectRequest jobreq = new JsonObjectRequest("http://" + Internet_address.ip + "/get_all_expert_groups.php", new JSONObject(), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    JSONArray jarr = response.getJSONArray("result");

                    System.out.println(jarr);

                    expert_group_adapter ad = new expert_group_adapter(jarr , Expert_groups.this);

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

        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000 , 2  , 2));

        AppController app = new AppController(Expert_groups.this);

        app.addToRequestQueue(jobreq);
    }

}
