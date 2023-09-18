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

public class DeleteActivity extends AppCompatActivity {

    DataBaseHelper myDb;
    EditText txtId;
    Button btnClick, btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        myDb= new DataBaseHelper(this);
        txtId = (EditText)findViewById(R.id.idID);
        btnClick = (Button) findViewById(R.id.buttondelete);
        btnback= (Button) findViewById(R.id.buttonback);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Blair();
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
        Intent back = new Intent(DeleteActivity.this, RegisterActivity.class);
        startActivity(back);
    }

    private void Blair()
    {
        String id = txtId.getText().toString();
        int result = myDb.deleteData(id);

        if(TextUtils.isEmpty(txtId.getText().toString()))
        {
            txtId.setError("ID is required");
        }
        else
        {
            if(result>0)
            {
                Toast.makeText(this, "ID deleted successfully", Toast.LENGTH_LONG).show();
            }
            else
            {
                Toast.makeText(this, "ID not deleted. \n Try again", Toast.LENGTH_LONG).show();
            }

        }

    }

}
