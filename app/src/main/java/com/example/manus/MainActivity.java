package com.example.manus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Boton de snackbar
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Global.etUser = (EditText)findViewById(R.id.etUser);
        Global.etPassword = (EditText)findViewById(R.id.etPassword);

        Global.btregist = (Button)findViewById(R.id.btregist);
        Global.btregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Global.etUser.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "No hay valores introducidos en Usuario", Toast.LENGTH_LONG).show();
                }else{
                    if (Global.etPassword.getText().toString().length() == 0){
                    Toast.makeText(getApplicationContext(), "No hay valores introducidos en contraseña", Toast.LENGTH_LONG).show();
                }else {
                        Toast.makeText(getApplicationContext(), Global.etUser.getText().toString() + " \n" + Global.etPassword.getText().toString(), Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), etPassword.getText().toString(), Toast.LENGTH_SHORT).show();

                        //SharedPreferences
                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                        // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();

                        editor.putString("etUser_Key_1", Global.etUser.getText().toString());
                        editor.putString("etPassword_key_1", Global.etPassword.getText().toString());

                        editor.commit();

                        Intent i = new Intent(getApplicationContext(), RecibeActivity.class);
                        startActivity(i);
                        finish();
                    }
                }
            }
        });
    }

}
