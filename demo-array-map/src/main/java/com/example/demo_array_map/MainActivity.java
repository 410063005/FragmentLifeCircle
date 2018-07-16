package com.example.demo_array_map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private SimpleArrayMap<Integer, String> map = new SimpleArrayMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvMap = findViewById(R.id.tvArrayMap);
        final TextView tvMapHash = findViewById(R.id.tvArrayMapHash);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.clear();
                map = new SimpleArrayMap<>();

                tvMap.setText(null);
                tvMapHash.setText(getMapHashes(map));
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.put(102, "a");

                tvMap.setText(map.toString());
                tvMapHash.setText(getMapHashes(map));
            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.put(103, "b");

                tvMap.setText(map.toString());
                tvMapHash.setText(getMapHashes(map));
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.put(1005, "c");
                tvMap.setText(map.toString());
                tvMapHash.setText(getMapHashes(map));
            }
        });


        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.put(1005, "d");

                tvMap.setText(map.toString());
                tvMapHash.setText(getMapHashes(map));
            }
        });

        findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                map.put(1006, "e");

                tvMap.setText(map.toString());
                tvMapHash.setText(getMapHashes(map));
            }
        });


    }

    private String getMapHashes(SimpleArrayMap map) {
        try {
            Field fieldHashes = SimpleArrayMap.class.getDeclaredField("mHashes");
            fieldHashes.setAccessible(true);
            Object objHashes = fieldHashes.get(map);
            int[] hashes = (int[]) objHashes;
            return Arrays.toString(hashes);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return "[]";
    }
}
