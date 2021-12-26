package com.example.lab5_persistent_storage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void onButtonClick(View view){

        EditText username = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText password = (EditText) findViewById(R.id.editTextTextPassword);

        if(username.getText().toString().length() <= 0 || password.getText().toString().length() <= 0){
            Toast.makeText(MainActivity.this, "Please Enter username or password", Toast.LENGTH_LONG).show();
        }else{
            String login = username.getText().toString();
            SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_persistent_storage", Context.MODE_PRIVATE);
            sharedPreferences.edit().putString("username", login).apply();

            goToActivity2();
        }
    }

    public void goToActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String usernameKey = "username";

        SharedPreferences sharedPreferences = getSharedPreferences("com.example.lab5_persistent_storage", Context.MODE_PRIVATE);

        if(!sharedPreferences.getString(usernameKey, "").equals("")){
            goToActivity2();
        }else{
            setContentView(R.layout.activity_main);
        }

    }
}