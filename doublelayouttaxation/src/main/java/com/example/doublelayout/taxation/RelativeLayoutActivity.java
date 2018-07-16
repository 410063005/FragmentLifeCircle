package com.example.doublelayout.taxation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RelativeLayoutActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, RelativeLayoutActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relative_layout);

        final Button b = findViewById(R.id.tv_text1);
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
