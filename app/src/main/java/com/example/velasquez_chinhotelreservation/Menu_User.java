package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Menu_User extends AppCompatActivity implements View.OnClickListener{

    ImageButton btnAboutUs, btnUpdateAccount, btnBook, btnBookings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__user);

        btnUpdateAccount = (ImageButton) findViewById(R.id.btnAddData);
        btnBook = (ImageButton) findViewById(R.id.btnBook);
        btnBookings = (ImageButton) findViewById(R.id.btnBookings);

}

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnAddData:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, Account.class);
                startActivity(intent2);
                break;

            case R.id.btnBook:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent3 = new Intent(this, AdminAddRoom.class);
                startActivity(intent3);
                break;


            case R.id.btnBookings:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, Receipt.class);
                startActivity(intent5);
                break;




        }
}}