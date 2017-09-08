package com.example.ssorenson.testapp1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.*;
import android.provider.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //code taken from developer.android.com/training/camera/photobasics.html
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.content_main);//this is where I made all the non-template stuff

        //this button opens up the existing camera app.
        Button pic_button = (Button) findViewById(R.id.picture_button);
        pic_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatchTakePictureIntent();
            }
        });

        //this EditText field is used to collect the Sales Order Number from the user.
        final EditText so_field = (EditText) findViewById(R.id.editText);
        so_field.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable text = so_field.getText();//get user input from EditText as an Editable
                String user_input = text.toString();//get String from Editable for a useable Sales Order Number
                user_input.trim();
                /*
                if (user_input.length() == 7) {
                    TextView t = (TextView) findViewById(R.id.textView);
                    t.setAllCaps(true);
                }
                /*///probably need to validate that at some point
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
