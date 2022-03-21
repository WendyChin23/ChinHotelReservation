package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class AdminOrUser extends AppCompatActivity implements View.OnClickListener{
ImageButton admin, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_or_user);

        admin = (ImageButton) findViewById(R.id.admin);
        user = (ImageButton) findViewById(R.id.user);
    }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.admin:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(this, Menu_Admin.class);
                    startActivity(intent1);
                    break;
                case R.id.user:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(this, Menu_User.class);
                    startActivity(intent2);
                    break;

            }

        }
    }