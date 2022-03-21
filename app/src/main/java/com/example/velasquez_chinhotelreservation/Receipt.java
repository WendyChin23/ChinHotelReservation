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

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;


public class Receipt extends AppCompatActivity {
    DatabaseHelper myDb;
    DBHelper myDb2;
    EditText editName,editTextEmail,editTextRoomType ,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnViewUsers;
    Button btnclearreg;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receipt);
        myDb = new DatabaseHelper(this);
        myDb2 = new DBHelper(this);


        //btnAddData = (Button)findViewById(R.id.btnAddData);
        btnviewAll = (Button) findViewById(R.id.btnviewAll);
        btnViewUsers= (Button)findViewById(R.id.btnViewUsers);
        //btnDelete= (Button)findViewById(R.id.btnDelete);
        // AddData();
        viewAll();
        viewAll2();
        //UpdateData();
        //DeleteData();
        //// btnclearreg.setOnClickListener(new View.OnClickListener() {
/*
            @Override
            public void onClick(View v) {
                editTextEmail.setText(" ");
                editName.setText(" ");
                editTextRoomType.setText(" ");
                editTextId.setText(" ");
            }

        });

    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Rooms.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Rooms.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editTextEmail.getText().toString(),editTextRoomType.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Rooms.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Rooms.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editName.getText().toString(),
                                editTextEmail.getText().toString(),
                                editTextRoomType.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Rooms.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Rooms.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/
    }
    public void viewAll() {
        btnViewUsers.setOnClickListener(
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
                            buffer.append("*Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Email :"+ res.getString(2)+"\n");
                            buffer.append("RoomType :"+ res.getString(3)+"\n\n\n");
                        }

                        // Show all data
                        showMessage("Rooms Booked by customers",buffer.toString());
                    }
                }
        );
    }

    public void viewAll2() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb2.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("*Email :"+ res.getString(0)+"\n");
                            buffer.append(" Password:"+ res.getString(1)+"\n");
                            buffer.append("Name :"+ res.getString(2)+"\n\n\n");
                          //  buffer.append(" :"+ res.getString(3)+"\n\n\n");
                        }

                        // Show all data
                        showMessage("Users of Chin Hotel and Spa",buffer.toString());
                    }
                }
        );
    }
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
