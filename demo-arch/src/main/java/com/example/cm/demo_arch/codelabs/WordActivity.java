package com.example.cm.demo_arch.codelabs;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.cm.demo_arch.R;

import java.util.List;

/**
 * Created by 410063005 on 2018/5/16.
 */

public class WordActivity extends AppCompatActivity {

    private static final String TAG = "WordActivity";

    private WordViewModel mWordViewModel;

    public static void start(Context context) {
        Intent starter = new Intent(context, WordActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word);

        mWordViewModel = ViewModelProviders.of(this).get(WordViewModel.class);
        Log.d(TAG, "onCreate: " + mWordViewModel + " in " + this);

        RecyclerView rv = findViewById(R.id.rvWord);
        rv.setLayoutManager(new LinearLayoutManager(this));
        final WordAdapter adapter = new WordAdapter(this);
        rv.setAdapter(adapter);


        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(@Nullable final List<Word> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });


        findViewById(R.id.ivAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewWordActivity.Companion.startForResult(WordActivity.this, 999);
            }
        });

        findViewById(R.id.ivDel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mWordViewModel.deleteAll();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            Word word = new Word(data.getStringExtra(NewWordActivity.Companion.getEXTRA_REPLY()));
            mWordViewModel.insert(word);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "not saved",
                    Toast.LENGTH_LONG).show();
        }
    }
}
