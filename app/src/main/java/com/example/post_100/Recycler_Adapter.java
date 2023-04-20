package com.example.post_100;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Recycler_Adapter extends RecyclerView.Adapter<Recycler_Adapter.View_Holder> {
    Activity activity;
    ArrayList<DataModel> list;
    public Recycler_Adapter(Activity activity, ArrayList<DataModel> list) {
        this.activity=activity;
        this.list=list;

    }

    @NonNull
    @Override
    public Recycler_Adapter.View_Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(activity).inflate(R.layout.item_file,parent,false);
        View_Holder viewHolder=new View_Holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Recycler_Adapter.View_Holder holder, int position) {
        DataModel model=list.get(position);

        int uid=model.getUserId();
        int id=model.getId();
        String title=model.getTitle();
        String body=model.getBody();

        holder.Uid.setText(""+uid);
        holder.Id.setText(""+id);
        holder.Title.setText(""+title);
        holder.Body.setText(""+body);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class View_Holder extends RecyclerView.ViewHolder {
        TextView Uid,Id,Title,Body;
        public View_Holder(@NonNull View itemView) {
            super(itemView);
            Uid=itemView.findViewById(R.id.item_uid);
            Id=itemView.findViewById(R.id.item_id);
            Title=itemView.findViewById(R.id.item_title);
            Body=itemView.findViewById(R.id.item_body);
        }
    }
}
