package com.example.imagejson;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class Second extends AppCompatActivity {

    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;

    Task task;
    RecAdapter adapter;
    String searchdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        searchdata = getIntent().getStringExtra("search");

        // iin.getExtras().getString("search",searchdata);


        //Toast.makeText(this, ""+searchdata, Toast.LENGTH_LONG).show();

        recyclerView = findViewById(R.id.rv);

        layoutManager = new GridLayoutManager(getApplicationContext(), 2);

        recyclerView.setLayoutManager(layoutManager);
        task = new Task(this);

        task.execute("https://pixabay.com/api/?key=10973143-33f5b7123759833d87db4b030&q=" + searchdata);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.back:

                Intent intent = new Intent(this, MainActivity.class);

                startActivity(intent);

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
