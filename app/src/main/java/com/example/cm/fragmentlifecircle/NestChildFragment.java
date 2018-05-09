package com.example.cm.fragmentlifecircle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 410063005 on 2018/5/9.
 */

public class NestChildFragment extends ChildFragment {

    @Override
    protected int getContentResId() {
        return R.layout.fragment_nest_child;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (view != null) {
            view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment f = getChildFragmentManager().findFragmentById(R.id.fl_fragment);
                    if (f == null) {
                        f = ChildFragment.newInstance("nest-child");
                        getChildFragmentManager().beginTransaction().add(R.id.fl_fragment, f).commit();
                    }
                }
            });
            view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Fragment f = getChildFragmentManager().findFragmentById(R.id.fl_fragment);
                    if (f != null) {
                        getChildFragmentManager().beginTransaction().remove(f).commit();
                    }
                }
            });
        }
        return view;
    }
}
