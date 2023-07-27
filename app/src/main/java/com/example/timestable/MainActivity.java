package com.example.timestable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.newListView);
        seekBar = findViewById(R.id.seekBar);
        ArrayList<Integer> tables = new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            tables.add(i+1*2);
        }
        ArrayAdapter<Integer> newAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,tables);
        listView.setAdapter(newAdapter);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                update_table(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
    public void update_table(int progress){
        ArrayList<Integer> temp_table = new ArrayList<Integer>();
        for(int i=0;i<100;i++){
            temp_table.add(progress*(i+1));
        }
        ArrayAdapter<Integer> newAdapter = (ArrayAdapter<Integer>) listView.getAdapter();
        newAdapter.clear();
        newAdapter.addAll(temp_table);
        newAdapter.notifyDataSetChanged();
    }
}