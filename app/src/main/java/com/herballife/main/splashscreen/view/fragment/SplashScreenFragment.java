package com.herballife.main.splashscreen.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.herballife.main.R;
import com.herballife.main.main.view.activity.MainActivity;
import com.herballife.main.splashscreen.contract.SplashScreenContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenFragment extends Fragment implements SplashScreenContract.View {

    private static final String TAG = "SplashScreenFragment";

    private static final Integer INITIAL_PROGRESS = 0;

    @BindView(R.id.prog)
    public ProgressBar mProgressBar;

    @BindView(R.id.load)
    public TextView mTextView;

    private SplashScreenContract.Presenter mPresenter;

    private Boolean mIsRunning;

    public static SplashScreenFragment newInstance() {
        return new SplashScreenFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_screen, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void setRunningIsFalse() {
        mIsRunning = Boolean.FALSE;
    }

    @Override
    public void setProgressBarInitialValue() {
        mProgressBar.setProgress(INITIAL_PROGRESS);
    }

    @Override
    public void setRunningIsTrue() {
        mIsRunning = Boolean.TRUE;
    }

    @Override
    public void startBackgroundProcess() {
        Handler handler = new SplashScreenHandler(mTextView, mProgressBar);
        Runnable runnable = new SplashScreenRunnable(handler);

        new Thread(runnable).start();
    }

    @Override
    public void moveToMainActivity() {
        startMainActivity();
        finishActivity();
    }

    @Override
    public void setPresenter(@NonNull SplashScreenContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    private void startMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    private void finishActivity() {
        getActivity().finish();
    }

    private class SplashScreenRunnable implements Runnable {

        private Handler mHandler;

        private SplashScreenRunnable(Handler handler) {
            mHandler = handler;
        }

        @Override
        public void run() {
            try {
                mPresenter.handleProgressBar(mHandler, mIsRunning);
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            }

            mPresenter.moveToMainActivity();
        }
    }
}
