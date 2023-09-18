package com.example.tonyblairsuper.sqlitelessonlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button inserbtn = (Button) findViewById(R.id.buttoninsert);
        Button readbtn = (Button) findViewById(R.id.button2read);
        Button updatebtn = (Button) findViewById(R.id.button3update);
        Button deletebtn = (Button) findViewById(R.id.button4delete);
        Button contact = (Button)findViewById(R.id.buttoncontact);


        inserbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              insert();
            }
        });

        readbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                read();
            }
        });

        updatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Name: Tony Okoth \n Email:blairman001@gmail.com \n Thank you.",Toast.LENGTH_LONG).show();
            }
        });
    }
    public void insert()
    {
       Intent tony = new Intent(RegisterActivity.this, InsertActivity.class);
        startActivity(tony);
    }
    public void read()
    {
        Intent tony = new Intent(RegisterActivity.this, ReadActivity.class);
        startActivity(tony);
    }
    public void update()
    {
        Intent tony = new Intent(RegisterActivity.this, UpdateActivity.class);
        startActivity(tony);
    }
    public void delete()
    {
        Intent tony = new Intent(RegisterActivity.this, DeleteActivity.class);
        startActivity(tony);
    }

}
