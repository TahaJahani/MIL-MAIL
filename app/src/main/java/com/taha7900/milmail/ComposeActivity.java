package com.taha7900.milmail;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ComposeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
    }

    public void confirmSend(View view) {
        EditText title = findViewById(R.id.title_text);
        EditText to = findViewById(R.id.to_text);
        EditText body = findViewById(R.id.bodyText);
        if (title.getText().toString().isEmpty() ||to.getText().toString().isEmpty()) {
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage("To and Title fields shouldn't be empty");
            alertDialogBuilder.setPositiveButton("OK", null);
            AlertDialog alert = alertDialogBuilder.create();
            alert.show();
        }else {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("*/*");
            intent.putExtra(Intent.EXTRA_EMAIL, new String[]{to.getText().toString()});
            intent.putExtra(Intent.EXTRA_SUBJECT, title.getText().toString());
            intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
            finish();
        }
    }
}