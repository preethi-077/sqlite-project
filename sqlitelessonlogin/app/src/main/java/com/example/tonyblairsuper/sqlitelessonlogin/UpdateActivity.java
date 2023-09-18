package com.example.tonyblairsuper.sqlitelessonlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    Button btnback, btnClick;
    EditText txtId, txtName, txtUserName, txtMarks;
    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        myDb = new DataBaseHelper(this);
        txtId = (EditText) findViewById(R.id.idID);
        txtName = (EditText) findViewById(R.id.idName);
        txtUserName = (EditText) findViewById(R.id.idSurname);
        txtMarks = (EditText) findViewById(R.id.idMarks);
        btnback = (Button) findViewById(R.id.buttonback);
        btnClick = (Button) findViewById(R.id.idBtn);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Blair();
            }
        });
    }

    public void back()
    {
        Intent tony = new Intent(UpdateActivity.this, RegisterActivity.class);
        startActivity(tony);
    }

    //A method responsible for accepting user inputs and interacting with the DataBaseHelper class to perform database operations
    private void Blair()
    {
        String id= txtId.getText().toString();
        String name= txtName.getText().toString();
        String surname = txtUserName.getText().toString();
        String marks = txtMarks.getText().toString();

        Boolean result = myDb.updateData(id,name,surname,marks);

        if(TextUtils.isEmpty(txtId.getText().toString()))
        {
            txtId.setError("Field ID can not be empty");
        }
        else if(TextUtils.isEmpty(txtName.getText().toString()))
        {
            txtName.setError("Name can not be empty");
        }
        else if(TextUtils.isEmpty(txtUserName.getText().toString()))
        {
            txtUserName.setError("Username can not be empty");
        }
        else if(TextUtils.isEmpty(txtMarks.getText().toString()))
        {
            txtMarks.setError("Marks can not be empty");
        }
       else
        {
            if(result==true)
            {
                Toast.makeText(this,"Data Updated Successfully",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this,"No Rows Affected. \n Data not updated.",Toast.LENGTH_LONG).show();
            }
        }

    }
}
