package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickFunc(View view){
        //Log.i("Info", "Button Pressed");
        EditText mytextfield = (EditText) findViewById(R.id.PlainText1);
        String str = mytextfield.getText().toString();

        goToActivity2(str);
        //Toast.makeText(MainActivity.this, textfield.getText().toString(), Toast.LENGTH_LONG).show();
    }

    private void goToActivity2(String str) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("message", str);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}