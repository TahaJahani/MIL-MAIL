package com.taha7900.milmail;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.viewHolder> {
    private ArrayList<Email> data;
    private LayoutInflater inflater;//creates a view object out of an XML file
    private Context context;
    //context: current app's state (most of the times, current activity)
    public EmailAdapter (Context context, ArrayList<Email> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
        this.context = context;
    }

    //to create a new view holder to add an item to context
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new viewHolder(inflater.inflate(R.layout.email_row, parent, false));
    }

    //to show to created item on the context
    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Email thisItem = data.get(position); //position gives us current item's index
        holder.senderTextView.setText(thisItem.getSender());
        holder.subjectTextView.setText(thisItem.getSubject());
        Picasso.with(context).load(thisItem.getImageURL()).into(holder.emailImage);
    }

    //'cause android wants to know how many items is shown
    @Override
    public int getItemCount() {
        return data.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView senderTextView;
        TextView subjectTextView;
        ImageView emailImage;

        viewHolder(@NonNull View itemView) {
            super(itemView);
            senderTextView = (TextView) itemView.findViewById(R.id.senderInRow);
            subjectTextView = (TextView) itemView.findViewById(R.id.subjectInRow);
            emailImage = itemView.findViewById(R.id.emailImage);
        }
    }


}
