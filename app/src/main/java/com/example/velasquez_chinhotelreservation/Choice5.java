package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Choice5 extends AppCompatActivity implements View.OnClickListener{
    ImageView arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choice5);

        arrow = (ImageView) findViewById(R.id.arrow);



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow:
                Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
                Intent intent1 = new Intent(this, Dashboard.class);
                startActivity(intent1);
                break;
        }
    }}