package com.example.karam.demo1;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by karam on 14-05-17.
 */

public class expert_group_adapter extends RecyclerView.Adapter<expert_group_view_holder> {

    JSONArray jarr ;
    Activity a ;

    public  expert_group_adapter(JSONArray jarr , Activity a)
    {
        this.jarr = jarr ;
        this.a = a ;
    }
    @Override
    public expert_group_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new expert_group_view_holder(LayoutInflater.from(a ).inflate(R.layout.expert_group_cell , parent ,false));

    }

    @Override
    public void onBindViewHolder(expert_group_view_holder holder, int position) {
        try {
            JSONObject job = jarr.getJSONObject(position);

            holder.group_name.setText(job.getString("Group_name"));

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jarr.length();
    }
}
