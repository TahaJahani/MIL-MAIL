package com.taha7900.milmail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

public class EmailListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        //String username = getIntent().getStringExtra("username");
        //Toast.makeText(this, "Welcome " + username, Toast.LENGTH_LONG).show();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        //setting how to show items
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        EmailAdapter adapter = new EmailAdapter(this, Email.getAllEmails());
        //setting recyclerview's behavior based on our adapter
        recyclerView.setAdapter(adapter);


    }
}