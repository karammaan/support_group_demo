package com.example.karam.demo1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by karam on 14-05-17.
 */

public class expert_group_view_holder extends RecyclerView.ViewHolder {

    TextView group_name ;

    public expert_group_view_holder(View itemView) {
        super(itemView);

        group_name = (TextView) itemView.findViewById(R.id.name_id);

    }
}
