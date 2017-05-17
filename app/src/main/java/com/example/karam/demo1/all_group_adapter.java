package com.example.karam.demo1;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by karam on 27-04-17.
 */

public class all_group_adapter extends RecyclerView.Adapter<all_group_view_holder> {

    JSONArray jsarr;
    Activity b ;

    public all_group_adapter(JSONArray jarr , Activity a )
    {
        jsarr = jarr;
        b = a;
    }


    @Override
    public all_group_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        all_group_view_holder v = new all_group_view_holder(LayoutInflater.from(b).inflate(R.layout.all_group_cell,parent,false));

        return v ;

    }

    @Override
    public void onBindViewHolder(all_group_view_holder holder, int p) {

        try {
           final   JSONObject job =  jsarr.getJSONObject(p);

            holder.name.setText(job.getString("Group_name"));

            holder.join.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        all_group.group_join(job.getString("Group_id") , b);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            });

            holder.report_this_group.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {


                    try {
                        all_group.report_group(job.getString("Group_id") , b);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });


        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    @Override
    public int getItemCount() {
        return jsarr.length();
    }
}
