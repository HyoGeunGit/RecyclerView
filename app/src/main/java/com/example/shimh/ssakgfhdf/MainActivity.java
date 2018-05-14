package com.example.shimh.ssakgfhdf;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ListItem> items = new ArrayList<>();
    ReAdapter adapter;
    EditText editText;
    Button button;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        editText = findViewById(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items.add(new ListItem("title1", "content1"));
        items.add(new ListItem("title2", "content2"));
        items.add(new ListItem("title3", "content3"));
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapter = new ReAdapter(items);
        recyclerView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(new ListItem(editText.getText().toString(),"content"));
                editText.setText("");
                recyclerView.getAdapter().notifyItemInserted(items.size());
            }
        });
    }

}
