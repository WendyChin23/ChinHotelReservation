package com.example.velasquez_chinhotelreservation;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class Account extends AppCompatActivity {
    DBHelper myDb;
    //DatabaseHelper myDbb;

    EditText editName,editEmail ,editPass;
    //Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button reset;
    Button btnviewUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        myDb = new DBHelper(this);

        editName = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPass = (EditText) findViewById(R.id.editPass);
        //editAge = (EditText) findViewById(R.id.editAge);


        //  btnAddData = (Button) findViewById(R.id.btnAddData);
        btnviewAll = (Button) findViewById(R.id.btnviewAll);
        btnviewUpdate = (Button) findViewById(R.id.btnviewUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        reset = (Button) findViewById(R.id.reset);
        // AddData();
       // viewAll();
        UpdateData();
        DeleteData();

        reset.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        editName.setText("Enter Name");
                        editEmail.setText("Enter Email");
                        editPass.setText(" ");
                        //editAge.setText(" ");
                    }

                });

            }


    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editEmail.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Account.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Account.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editEmail.getText().toString(),
                                editName.getText().toString(),
                                editPass.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Account.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Account.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
   /* public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editPassword.getText().toString(),
                                editAge.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Account.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Account.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/
/*
    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Email :"+ res.getString(0)+"\n");
                            buffer.append("Password :"+ res.getString(1)+"\n");
                            buffer.append("Name :"+ res.getString(2)+"\n\n\n");
                            //buffer.append("Available :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }*/

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rooms, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.actions) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
