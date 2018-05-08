package com.example.cm.fragmentlifecircle;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Fragment的生命周期(单个Fragment).
 * <p>
 * add, remove, attach, detach对Fragment生命周期的影响.
 * <p>
 * Created by 410063005 on 2018/5/7.
 */

public class SingleChildActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent starter = new Intent(context, SingleChildActivity.class);
        // starter.putExtra();
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_child);

        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (fragment == null) {
            fragment = ChildFragment.newInstance("child");
            getSupportFragmentManager().beginTransaction().add(R.id.fl_content, fragment).commit();
        }
    }

    public void onTextClick(View view) {
        FragmentTransaction curTransaction = getSupportFragmentManager().beginTransaction();
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("frag");

        switch (view.getId()) {
            case R.id.textViewAddFrag:
                if (fragment == null) {
                    curTransaction.add(R.id.fl_content2, ChildFragment.newInstance("little-child"), "frag");
                }
                break;

            case R.id.textViewRemoveFrag:
                if (fragment != null) {
                    curTransaction.remove(fragment);
                }
                break;

            case R.id.textViewAttachFrag:
                if (fragment != null) {
                    curTransaction.attach(fragment);
                }
                break;

            case R.id.textViewDetachFrag:
                if (fragment != null) {
                    curTransaction.detach(fragment);
                }
                break;
        }

        curTransaction.commit();
        // curTransaction.commitAllowingStateLoss();
    }
}
