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

public class Edit extends AppCompatActivity {

    EditText newuser, newpassword;
    Button change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final String etUser = pref.getString("etUser_Key_1","");
        final String etPassword = pref.getString("etPassword_key_1","");

        newuser = (EditText)findViewById(R.id.newuser);
        newpassword =(EditText)findViewById(R.id.newpwrd);
        change = (Button)findViewById(R.id.btchange);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Global.etUser.getText().toString().length() == etUser.length()) {
                    if (Global.etPassword.getText().toString().length() == etPassword.length()) {

                        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                        // 0 - for private mode
                        SharedPreferences.Editor editor = pref.edit();

                        editor.putString("etUser_Key_1", newuser.getText().toString());
                        editor.putString("etPassword_key_1", newpassword.getText().toString());

                        editor.commit();

                        Toast.makeText(getApplicationContext(), "Sean hecho los cambios satisfactoriamente", Toast.LENGTH_LONG).show();

                        Intent i = new Intent(getApplicationContext(), Login.class);
                        startActivity(i);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(), "Contraseña no valida", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "Usuario no valido", Toast.LENGTH_LONG).show();
                }
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
