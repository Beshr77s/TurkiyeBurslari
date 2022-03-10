package com.qashar.turkiyeburslari.Adapters;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.qashar.turkiyeburslari.Models.Requests;
import com.qashar.turkiyeburslari.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {
    final Context context;
    final List<Requests> groups;

    public ListAdapter( Context context, List<Requests> groups) {
        this.context = context;
        this.groups = groups;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.S)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Requests requests = groups.get(position);
        holder.country.setText(groups.get(position).getCountry());
        holder.note.setText(groups.get(position).getNote());
        if (requests.getCountry().equals("أسم الدولة")){
            holder.date.setText("تاريخ بدء أرسال القبولات");
        }
        Long aLong = requests.getDate();
        Date date = new Date(aLong);
        SimpleDateFormat format = new SimpleDateFormat("E yyyy/MM/dd ");
        holder.date .setText("أخر تحديث في : "+format.format(date));
        if (!requests.getUrl().equals(null)){
            holder.url.setVisibility(View.VISIBLE);
        }
        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(requests.getUrl()));
                context.startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {

        return groups.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView country,date,note;
        private Button url;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            country = itemView.findViewById(R.id.itemCountry);
            date = itemView.findViewById(R.id.itemDate);
            note = itemView.findViewById(R.id.itemNote);
            url = itemView.findViewById(R.id.btnUrl);



        }


    }

}