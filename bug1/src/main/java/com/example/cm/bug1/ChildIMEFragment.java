package com.example.cm.bug1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

/**
 * Created by 410063005 on 2018/5/8.
 */

public class ChildIMEFragment extends Fragment {
    private static final String TAG = "ChildIMEFragment";

    private EditText mEditText;
    private RelativeLayout mClRoot;

    public static ChildIMEFragment newInstance() {

        Bundle args = new Bundle();
        ChildIMEFragment fragment = new ChildIMEFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        AndroidBug5497Workaround2.assistActivity(getActivity(), new Callback() {

            @Override
            public void run(int height) {
                Log.d(TAG, "run() called with: height = [" + height + "]");
                if (mEditText != null && mEditText.getLayoutParams() != null) {
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) mEditText.getLayoutParams();
                    if (params != null) {
                        if (height <= 0) params.bottomMargin = 0;
                        else params.bottomMargin = height - 144;// (int) (48 * getContext().getResources().getDisplayMetrics().density);
                        //mEditText.setLayoutParams(params);
                        mEditText.requestLayout();
                    }
                }

//                if (mEditText != null && mEditText.getLayoutParams() != null) {
//                    ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) mEditText.getLayoutParams();
//                    if (params != null) {
//                        if (height <= 0) params.bottomMargin = 0;
//                        else params.bottomMargin = height;// - (int) (48 * getContext().getResources().getDisplayMetrics().density) - (1015 - 859);
//                        mEditText.setLayoutParams(params);
//                    }
//                }
//                if (mClRoot != null && mClRoot.getLayoutParams() != null) {
//                    ViewPager.LayoutParams layoutParams = (ViewPager.LayoutParams) mClRoot.getLayoutParams();
//                    if (height == 0) layoutParams. =0;
//                    else layoutParams.bottomMargin = height;
//                    mClRoot.setLayoutParams(layoutParams);
//                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_child_ime, container, false);
        mEditText = view.findViewById(R.id.editText);
        mClRoot = view.findViewById(R.id.cl_root);
        return view;
    }

    public interface Callback {
        void run(int height);
    }
}
