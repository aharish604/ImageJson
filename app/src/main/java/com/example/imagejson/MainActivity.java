package com.example.imagejson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.ed1);
    }

    public void search(View view) {

        if (editText.getText().length() == 0) {
            editText.setError("its Not allow to Empty!");
        } else {

            String searchdata = editText.getText().toString();

            // Toast.makeText(this, ""+searchdata, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Second.class);

            //String msg;
            intent.putExtra("search", searchdata);

            startActivity(intent);

        }
    }
}