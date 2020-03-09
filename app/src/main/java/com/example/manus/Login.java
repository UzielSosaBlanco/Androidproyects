package com.example.manus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Global.etUser = (EditText)findViewById(R.id.etUser);
        Global.etPassword = (EditText)findViewById(R.id.etPassword);

        Global.btLogin = (Button)findViewById(R.id.btLogin);
        Global.btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                String etUser = pref.getString("etUser_Key_1","");
                String etPassword = pref.getString("etPassword_key_1","");

                if (etUser.length() == Global.etUser.getText().toString().length()){
                    if(etPassword.length() == Global.etPassword.getText().toString().length()){

                        Intent i = new Intent(getApplicationContext(), RecibeActivity.class);
                        startActivity(i);
                        finish();

                    }else{
                        Toast.makeText(getApplicationContext(),"Contraseña incorrecta",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Usuario incorrecta",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
