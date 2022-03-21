package com.example.velasquez_chinhotelreservation;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

import androidx.annotation.RequiresApi;

public class NotificationDemo_Class extends Application {
    public static final String channel1_id = "First Channel";
    public  static final String channel2_id = "Second Channel";

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate(){
            super.onCreate();

//invoke the createNotificationChannel method
        createNotificationChannel();
    }


    //define method for creating notification
    @RequiresApi(api = Build.VERSION_CODES.O)
    private void createNotificationChannel(){
        //check the android version
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O);

        //create Notification Channel object for the first Channel
        NotificationChannel my_channel1 = new NotificationChannel(channel1_id, "My First Channel", NotificationManager.IMPORTANCE_HIGH);
        // customize my_channel1
        my_channel1.setDescription("This is my first Channel");

        //create Notification Channel object for the second Channel

        NotificationChannel my_channel2 = new NotificationChannel(channel2_id, "My Second Channel", NotificationManager.IMPORTANCE_HIGH);
        // customize my_channel1
        my_channel2.setDescription("This is my second Channel");

    //set a reference to the Notification manager and create the 2 channels
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(my_channel1);
        notificationManager.createNotificationChannel(my_channel2);

   //registwe the class in the manifest file


    }
}
