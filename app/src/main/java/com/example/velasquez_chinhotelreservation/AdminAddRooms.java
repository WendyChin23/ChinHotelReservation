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


public class AdminAddRooms extends AppCompatActivity {

   // DatabaseHelper myDbb;

    EditText editName,editText_Available,editText_Beds ,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
    Button btnclearreg;
    Button btnviewUpdate;
    DBH myDbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_rooms);
        myDbb = new DBH(this);

        editName = (EditText) findViewById(R.id.editName);
        editText_Beds = (EditText) findViewById(R.id.editText_Beds);
        editText_Available = (EditText) findViewById(R.id.editText_Available);
        editTextId = (EditText) findViewById(R.id.editTextId);

        btnclearreg = (Button) findViewById(R.id.btnclearreg);
        btnAddData = (Button) findViewById(R.id.btnAddData);
        btnviewAll = (Button) findViewById(R.id.btnviewAll);
        btnviewUpdate = (Button) findViewById(R.id.btnviewUpdate);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();


        btnclearreg.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editName.setText(" ");
                editText_Beds.setText(" ");
                editText_Available.setText(" ");
                editTextId.setText(" ");
            }

        });
    }

    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDbb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(AdminAddRooms.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AdminAddRooms.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDbb.updateData(editTextId.getText().toString(),
                                editName.getText().toString(),
                                editText_Beds.getText().toString(),editText_Available.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(AdminAddRooms.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AdminAddRooms.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDbb.insertData(editName.getText().toString(),
                                editText_Beds.getText().toString(),
                                editText_Available.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(AdminAddRooms.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AdminAddRooms.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDbb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("RoomType :"+ res.getString(1)+"\n");
                            buffer.append("Number of Beds :"+ res.getString(2)+"\n");
                            buffer.append("Available :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
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

/*
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
    }*/
}
