package com.example.emptybase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView iv = (ImageView) findViewById(R.id.imageView);

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("view", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent activityName = new Intent(ListActivity.this, MainActivity.class);
                        activityName.putExtra("random", new Random().nextInt(1000000));
                        startActivity(activityName);
                    }
                });
                builder.setNegativeButton("close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}