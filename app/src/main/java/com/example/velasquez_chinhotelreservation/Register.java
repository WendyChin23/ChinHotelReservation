package com.example.velasquez_chinhotelreservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import android.widget.EditText;

public class Register extends AppCompatActivity{
    Button cirRegisterButton;
    EditText Name, Age, Password, Email;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        cirRegisterButton = (Button) findViewById(R.id.cirRegisterButton);
        Name = (EditText) findViewById(R.id.Name);
        Age = (EditText) findViewById(R.id.Age);
        Password = (EditText) findViewById(R.id.Password);
        Email = (EditText) findViewById(R.id.editPass);
        db = new DBHelper(this);


        cirRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);

                String name = Name.getText().toString();
               // String age = Age.getText().toString();
                String email = Email.getText().toString();
                String password = Password.getText().toString();
                //String number = editNumber.getText().toString();
               // String address = editAdddress.getText().toString();



                boolean ins = db.createPerson(name,email,password);
                // Toast.makeText(SignIn.this, "Button clicked", Toast.LENGTH_SHORT).show();
                if (ins == true){
                    Toast.makeText(Register.this, "Record successfully inserted!", Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(getApplicationContext(), LogInPage.class);
                    startActivity(in);
                }
                else
                    Toast.makeText(Register.this, "Record NOT inserted!", Toast.LENGTH_SHORT).show();
            }
        });

    }


}