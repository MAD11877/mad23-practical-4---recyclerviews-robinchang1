package com.example.emptybase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        int message = receivingEnd.getIntExtra("random", 0);

        TextView tv = (TextView) findViewById(R.id.textView);
        tv.setText("MAD " + message);

        User user = new User("john", "hi", 0, false);

        Button followButton = findViewById(R.id.button);

        followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (user.followed == false) {
                    user.followed = true;
                    followButton.setText("UNFOLLOW");
                    Toast toast = Toast.makeText(getApplicationContext(), "FOLLOWED", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    user.followed = false;
                    followButton.setText("FOLLOW");
                    Toast toast = Toast.makeText(getApplicationContext(), "UNFOLLOWED", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        Button msgButton = findViewById(R.id.button2);

        msgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activityName = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(activityName);
            }
        });
    }
}