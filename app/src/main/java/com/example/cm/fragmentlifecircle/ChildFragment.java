package com.example.cm.fragmentlifecircle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;

/**
 * Created by 410063005 on 2018/5/7.
 */

public class ChildFragment extends Fragment {
    private String TAG = "ChildFragment";

    private ViewStub mVsContent;

    public static Bundle args(String id) {
        Bundle arg = new Bundle();
        arg.putString("ID", id);
        return arg;
    }

    public static ChildFragment newInstance(String id) {
        Bundle args = new Bundle();
        args.putString("ID", "ChildFragment-" + id);
        ChildFragment fragment = new ChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public static LazyChildFragment newLazyInstance(String id) {
        Bundle args = new Bundle();
        args.putString("ID", "ChildFragment-" + id);
        LazyChildFragment fragment = new LazyChildFragment();
        fragment.setArguments(args);
        return fragment;
    }

    protected int getContentResId() {
        return R.layout.fragment_child;
    }

    @Override
    public String toString() {
        return TAG;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(TAG, "setUserVisibleHint() called with: isVisibleToUser = [" + isVisibleToUser + "], " + this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            TAG = getArguments().getString("ID");
        }

        Log.d(TAG, "onAttach() called with: context = [" + context + "]");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        View view = inflater.inflate(R.layout.fragment_common, container, false);

        mVsContent = view.findViewById(R.id.vs_content);
        mVsContent.setLayoutResource(getContentResId());
        doInflateInternal();
        return view;
    }

    @Override
    public void onStart() {
        Log.d(TAG, "onStart() called");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume() called");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause() called");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop() called");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView() called");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() called");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach() called");
        super.onDetach();
    }

    private void doInflateInternal() {
        doInflate();
    }

    protected void doInflate() {
        View tmp = mVsContent.inflate();
        TextView textView = tmp.findViewById(R.id.textView);
        if (textView != null) {
            textView.setText(TAG);
        }
    }
}
