package com.example.karam.demo1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by karam on 28-04-17.
 */

public class joined_group_view_holder extends RecyclerView.ViewHolder {

    public TextView name ;

    public RelativeLayout joined_box;


    public joined_group_view_holder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name_id);

        joined_box = (RelativeLayout) itemView.findViewById(R.id.joined_box);


    }
}
