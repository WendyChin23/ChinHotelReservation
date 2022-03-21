package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Menu_Admin extends AppCompatActivity implements View.OnClickListener{
    AlertDialog.Builder builder, ab;
    //ImageView btnRooms;
    ImageView btnBooking, btnView;
    ImageView btnLogOut;
    //private NotificationManagerCompat notiffcompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__admin);


        btnBooking = (ImageView) findViewById(R.id.btnBooking);
        btnLogOut = (ImageView) findViewById(R.id.btnLogOut);
        btnView= (ImageView) findViewById(R.id.btnView);
        builder = new AlertDialog.Builder( this);
        ab = new AlertDialog.Builder(this);

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage("Are you sure you want to log out?");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //code for YES
                        Toast.makeText(Menu_Admin.this, "LOGGING OUT", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(Menu_Admin.this ,Log_In.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Menu_Admin.this, "Cancelled", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                //show the alet dialog
                AlertDialog alert = builder.create();
                alert.setTitle("LOGGING OUT");
                alert.show();

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnBooking:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(this, AdminAddRoom.class);
                startActivity(intent2);
                break;

            case R.id.btnView:
                Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                Intent intent4 = new Intent(this, Receipt.class);
                startActivity(intent4);
                break;

            case R.id.btnLogOut:
                Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show();
                Intent intent5 = new Intent(this, Log_In.class);
                startActivity(intent5);
                break;
        }}}
