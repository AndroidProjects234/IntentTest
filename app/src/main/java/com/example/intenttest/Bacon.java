package com.example.intenttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Bacon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bacon);
        Intent intent=new Intent(this,MyService.class);
        startService(intent);//Start the service

        Bundle applesData=getIntent().getExtras();  //We have some extra data store it into bundle
        if(applesData==null){   //Check if we have no data than we just return without changing text
            return;
        }
        String appleMessage=applesData.getString("appleMessage");
        final TextView baconText=(TextView)findViewById(R.id.BaconText);
        baconText.setText(appleMessage);
    }

    public void onClick(View view){
        Intent i=new Intent(this,Apples.class);
        startActivity(i);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
