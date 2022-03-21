package com.example.velasquez_chinhotelreservation;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LogInPage extends AppCompatActivity implements View.OnClickListener{
    Button LogInButton;
    EditText editEmail,editPassword;
    TextView RegisterButton;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);
        LogInButton = (Button) findViewById(R.id.LogInButton);
        editEmail = (EditText) findViewById(R.id.editPass);
        editPassword = (EditText) findViewById(R.id.editPassword);
        RegisterButton = (TextView) findViewById(R.id.RegisterButton);
        db = new DBHelper(this);

        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailAdd = editEmail.getText().toString();
                String passW = editPassword.getText().toString();

                boolean checkUser = db.checkUser(emailAdd, passW);

                if (checkUser == true) {
                    Toast.makeText(LogInPage.this, "Sign In Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(), HOME.class);
                    startActivity(intent1);
                } else
                    Toast.makeText(LogInPage.this, "User Doesn't Exists", Toast.LENGTH_SHORT).show();
            }
        });
    }
        @Override
        public void onClick(View v) {
            switch (v.getId()) {

                case R.id.RegisterButton:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent2 = new Intent(this, Register.class);
                    startActivity(intent2);
                    break;
                case R.id.admin:
                    Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                    Intent intent3 = new Intent(this, Log_In.class);
                    startActivity(intent3);
                    break;

    }
}}

/*import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;

import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class LogInPage extends AppCompatActivity implements View.OnClickListener{
    AlertDialog.Builder builder, ab;
    TextView Register, admin;
    Button cirLoginButton;
    EditText editTextPassword, editTextEmail;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_page);

        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        Register = (TextView) findViewById(R.id.Register);
        admin = (TextView) findViewById(R.id.admin);
        cirLoginButton = (Button) findViewById(R.id.cirLoginButton);
        cirLoginButton = (Button) findViewById(R.id.cirLoginButton);
        DB = new DBHelper(this);

       /* builder = new AlertDialog.Builder( this);
        ab = new AlertDialog.Builder(this);

        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                builder.setMessage("Are you sure you want to submit this page?");
                builder.setCancelable(false);
                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //code for YES
                        Toast.makeText(LogInPage.this, "SUCCESFULLY LOG IN", Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(LogInPage.this ,HOME.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(LogInPage.this, "Cancelled", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });

                //show the alert dialog
                AlertDialog alert = builder.create();
                alert.setTitle("LOG IN");
                alert.show();

            }
        });

        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        String email = editTextEmail.getText().toString();
        String pass = editTextPassword.getText().toString();

        if(email.equals("") || pass.equals(""))
            Toast.makeText(this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
            Boolean checkemailpass = DB.checkemailpassword(email, pass);
            if(checkemailpass==true){
                Toast.makeText(this, "SUCCESFULLY LOG IN", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), HOME.class);
                startActivity(intent);

            }else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
            }

    }





    @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.cirLoginButton:
                        Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(this, HOME.class);
                        startActivity(intent1);
                        break;
                    case R.id.Register:
                        Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(this, Register.class);
                        startActivity(intent2);
                        break;
                    case R.id.admin:
                        Toast.makeText(this, "This button is clicked!", Toast.LENGTH_SHORT).show();
                        Intent intent3 = new Intent(this, Menu_Admin.class);
                        startActivity(intent3);
                        break;

                }}}*/