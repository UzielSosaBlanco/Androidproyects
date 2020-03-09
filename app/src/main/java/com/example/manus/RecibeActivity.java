package com.example.manus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class RecibeActivity extends AppCompatActivity {
    TextView tvver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibe);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        String etUser = pref.getString("etUser_Key_1","");

        tvver = (TextView)findViewById(R.id.etwelcome);
        tvver.setText("Bienvenido\n"+etUser);

        Button btret = (Button)findViewById(R.id.btret);
        btret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
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

        switch(item.getItemId()){
            case R.id.edit:
                startActivity(new Intent(getApplicationContext(), Edit.class));
                finish();
                return true;

            case R.id.erase:
                startActivity(new Intent(getApplicationContext(), Erase.class));
                finish();
                return true;

            case R.id.exit:
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
                return true;

            case R.id.message:
                startActivity(new Intent(getApplicationContext(), RecibeActivity.class));
                finish();
                return true;

            case R.id.see:
                startActivity(new Intent(getApplicationContext(), YourInf.class));
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}