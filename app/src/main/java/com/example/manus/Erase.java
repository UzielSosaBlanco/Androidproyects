package com.example.manus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Erase extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erase);

        Button erase = (Button)findViewById(R.id.bterase);
        erase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText user = (EditText)findViewById(R.id.etUser);
                EditText Password = (EditText)findViewById(R.id.etPassword);

                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
                String etUser = pref.getString("etUser_Key_1","");
                String etPassword = pref.getString("etPassword_key_1","");

                if (user.getText().toString().length() == etUser.length()) {
                    if (Password.getText().toString().length() == etPassword.length()) {

                        eliminarSharedPreferences();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();

                    } else {
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        });
}

     public void eliminarSharedPreferences () {
         SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
            // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();

            //remover
            editor.remove("etUser_Key_1");
            editor.remove("etPassword_key_1");
            //Eliminar todas las preferencias
            //editor.clear();
            editor.commit();

            //evalua si la llave existe
            if (pref.contains("etUser_Key_1"))
                Toast.makeText(this, "Fue eliminada", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, "No existe", Toast.LENGTH_SHORT).show();

            //editor.putString("sp_valor_uno", "NO QUIERO NADA< TU QUE QUIERES");
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
