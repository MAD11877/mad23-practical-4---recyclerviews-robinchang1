package com.example.emptybase;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView iv;
    TextView txt;
    TextView txt2;
    public UserViewHolder(View itemView) {
        super(itemView);
        txt = itemView.findViewById(R.id.textView3);
        txt2 = itemView.findViewById(R.id.textView4);
        iv = itemView.findViewById(R.id.imageView3);

        ImageView img = itemView.findViewById(R.id.imageView);

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                builder.setTitle("Profile");
                builder.setMessage(txt.getText());
                builder.setCancelable(true);
                builder.setPositiveButton("view", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent activityName = new Intent(itemView.getContext(), MainActivity.class);
                        activityName.putExtra("name", txt.getText());
                        activityName.putExtra("desc", txt2.getText());
                        itemView.getContext().startActivity(activityName);
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
