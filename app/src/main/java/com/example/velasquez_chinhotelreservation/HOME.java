package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HOME extends AppCompatActivity implements View.OnClickListener{
    AlertDialog.Builder builder, ab;
    ImageView btnRooms;
    ImageView btnBooking,btnAbout, btnAmen, btnAccount;
    ImageView btnLogOut;
    //private NotificationManagerCompat notiffcompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_h_o_m_e);


        btnRooms = (ImageView) findViewById(R.id.btnRooms);
        btnBooking = (ImageView) findViewById(R.id.btnBooking);
        btnAmen = (ImageView) findViewById(R.id.btnAmen);
        btnAbout = (ImageView) findViewById(R.id.btnAbout);
        btnLogOut = (ImageView) findViewById(R.id.btnLogOut);
        btnAccount= (ImageView) findViewById(R.id.btnView);
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
                        Toast.makeText(HOME.this, "LOGGING OUT", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(HOME.this ,LogInPage.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(HOME.this, "Cancelled", Toast.LENGTH_SHORT).show();
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
                case R.id.btnRooms:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(this, Dashboard.class);
                    startActivity(intent1);
                    break;
                case R.id.btnBooking:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(this, Rooms.class);
                    startActivity(intent2);
                    break;

                case R.id.btnAmen:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(this, Amen.class);
                    startActivity(intent3);
                    break;

                case R.id.btnAbout:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent6 = new Intent(this, AboutUS.class);
                    startActivity(intent6);
                    break;

                case R.id.btnView:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent4 = new Intent(this, Account.class);
                    startActivity(intent4);
                    break;

                case R.id.btnLogOut:
                    Toast.makeText(this, "Logging Out", Toast.LENGTH_SHORT).show();
                    Intent intent5 = new Intent(this, LogInPage.class);
                    startActivity(intent5);
                    break;
            }}}


             /*
        btnNotiff = (TextView) findViewById(R.id.btnNotiff);

        notiffcompat = NotificationManagerCompat.from(this);

        btnNotiff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notiff = new NotificationCompat.Builder(v.getContext(), NotificationDemo_Class.channel1_id)
                        .setContentTitle("TITLE")
                        .setContentText("This is a notification")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .build();
                notiffcompat.notify(1, notiff);
            }
        });
    }}

*/