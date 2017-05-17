package com.example.karam.demo1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by karam on 27-04-17.
 */

public class all_group_view_holder extends RecyclerView.ViewHolder {

    public TextView name , join , report_this_group;



    public all_group_view_holder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name_id);

        join = (TextView) itemView.findViewById(R.id.join_id);

        report_this_group = (TextView) itemView.findViewById(R.id.report_this_group);
    }
}
