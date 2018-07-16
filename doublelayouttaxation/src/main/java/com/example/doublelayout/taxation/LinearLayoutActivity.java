package com.example.doublelayout.taxation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LinearLayoutActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, LinearLayoutActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_layout);

        final Button b = findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ("1111".equals(b.getText().toString())) {
                    b.setText("22222222222");
                } else {
                    b.setText("1111");
                }
            }
        });
    }
}
