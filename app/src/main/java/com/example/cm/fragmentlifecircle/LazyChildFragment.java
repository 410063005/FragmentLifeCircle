package com.example.cm.fragmentlifecircle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * 一个简单的延迟加载Fragment.
 *
 * Created by 410063005 on 2018/5/7.
 */

public class LazyChildFragment extends ChildFragment {

    private ProgressBar mProgressBar;
    private ViewStub mVsContent;
    private View mInflatedView;

    private boolean mViewCreated;
    private boolean mFirstLoad = true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (mFirstLoad && mViewCreated && isVisibleToUser) {
            loadDataShowProgress();
            mFirstLoad = false;
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_common, container, false);
        mProgressBar = view.findViewById(R.id.progressBar);
        mVsContent = view.findViewById(R.id.vs_content);
        mVsContent.setLayoutResource(getContentResId());

        mViewCreated = true;

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mFirstLoad && mViewCreated && getUserVisibleHint()) {
            loadDataShowProgress();
            mFirstLoad = false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mViewCreated = false;
        mFirstLoad = true;
        mInflatedView = null;
    }

    @Override
    protected void doInflate() {
        super.doInflate();
    }

    private void loadDataShowProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
        loadData(true);
    }

    protected void loadData(boolean force) {
        mProgressBar.postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressBar.setVisibility(View.GONE);
                if (mInflatedView == null) {
                    mInflatedView = mVsContent.inflate();
                }
                TextView tv = mInflatedView.findViewById(R.id.textView);
                tv.setText("data " + (Math.random() * 1000));
            }
        }, 1500);
    }

}
