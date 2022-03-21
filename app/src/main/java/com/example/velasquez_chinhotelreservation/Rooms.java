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


public class Rooms extends AppCompatActivity {
    DatabaseHelper myDb;
    DBH myDb2;

    EditText editName,editTextEmail,editTextRoomType ,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
Button btnclearreg;
    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rooms);
        myDb = new DatabaseHelper(this);
        myDb2 = new DBH(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextRoomType = (EditText)findViewById(R.id.editTextRoomType);
        editTextId = (EditText)findViewById(R.id.editText_id);

        btnclearreg = (Button) findViewById(R.id.btnclearreg);

        btnAddData = (Button)findViewById(R.id.btnAddData);
        btnviewAll = (Button)findViewById(R.id.btnviewAll);
        btnviewUpdate= (Button)findViewById(R.id.btnviewUpdate);
        btnDelete= (Button)findViewById(R.id.btnDelete);
        AddData();
        viewAll();
        UpdateData();
        DeleteData();
        btnclearreg.setOnClickListener(new View.OnClickListener() {

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
    }

    public void viewAll() {
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
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Room Type :"+ res.getString(1)+"\n");
                            buffer.append("Beds :"+ res.getString(2)+"\n");
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
