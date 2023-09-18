package com.example.tonyblairsuper.sqlitelessonlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {

    DataBaseHelper mydb;
    EditText txtName, txtSurname, txtMarks;
    Button btnClick, btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        mydb = new DataBaseHelper(this);
        txtName=(EditText)findViewById(R.id.idName);
        txtSurname=(EditText)findViewById(R.id.idSurname);
        txtMarks=(EditText)findViewById(R.id.idMarks);

        btnClick=(Button)findViewById(R.id.buttoninsert);
        btnback=(Button)findViewById(R.id.buttonback);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //call the method InsertMe()
                InsertMe();
            }
        });

      btnback.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              back();
          }
      });

    }

    public void back()
    {
        Intent tony = new Intent(InsertActivity.this , RegisterActivity.class);
        startActivity(tony);
    }

    private void InsertMe()
    {
        String name= txtName.getText().toString();
        String surname= txtSurname.getText().toString();
        String marks = txtMarks.getText().toString();

        if(TextUtils.isEmpty(txtName.getText().toString()))
        {
            txtName.setError("Name can not be empty");
        }
        else if(TextUtils.isEmpty(txtSurname.getText().toString()))
           {
               txtSurname.setError("Surname can not be empty");
           }
        else if(TextUtils.isEmpty(txtMarks.getText().toString()))
           {
               txtMarks.setError("Marks can not be empty");
           }
        else
        {
            Boolean result = mydb.insertData(name, surname, marks);
            if(result==true)
            {
                Toast.makeText(getApplicationContext(),"Data Inserted Successfully",Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Data Insertion Failed",Toast.LENGTH_LONG).show();
            }
        }


    }

}
