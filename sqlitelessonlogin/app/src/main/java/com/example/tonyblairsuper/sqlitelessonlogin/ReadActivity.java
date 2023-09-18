package com.example.tonyblairsuper.sqlitelessonlogin;

import android.content.Intent;
import android.database.Cursor;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ReadActivity extends AppCompatActivity {
    Button btnClick ,btnback;
    TextView txtResult;
    DataBaseHelper mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        mydb = new DataBaseHelper(this);
        txtResult = (TextView)findViewById(R.id.idResult);
        btnClick =(Button) findViewById(R.id.idBtn);
        btnback = (Button) findViewById(R.id.buttonback);

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayData();
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                back();
            }
        });

    }
    //setting the scroll view on the result EditText

   /* public boolean onTouch(View view, MotionEvent event)
    {
        if(view.getId()==R.id.idResult)
        {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            switch(event.getAction() & MotionEvent.ACTION_MASK)
            {
                case
                MotionEvent.ACTION_UP:
                    view.getParent().requestDisallowInterceptTouchEvent(false);
                    break;
            }
        }
        return false;

    }*/

    public void back()
    {
        Intent tony = new Intent(ReadActivity.this , RegisterActivity.class);
        startActivity(tony);
    }

    private void DisplayData()
    {
        Cursor res = mydb.getAllData();

        if(res==null && res.getCount()==0) {

            Toast.makeText(getApplicationContext(), "Data Retrieval Failed", Toast.LENGTH_LONG).show();
            return;
        }
        else
        {
            StringBuffer stringBuffer = new StringBuffer();
            while(res.moveToNext()) {
                stringBuffer.append("id: " + res.getString(0) + "\n");
                stringBuffer.append("Name: " + res.getString(1) + "\n");
                stringBuffer.append("Surname: " + res.getString(2) + "\n");
                stringBuffer.append("Marks: " + res.getString(3) + "\n"+"\n");
            }

            txtResult.setText(stringBuffer.toString());
            Toast.makeText(getApplicationContext(), "Data Retrieved Successfully", Toast.LENGTH_LONG).show();
        }

    }

}
