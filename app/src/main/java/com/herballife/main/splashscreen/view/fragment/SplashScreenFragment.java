package com.herballife.main.splashscreen.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
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
import com.herballife.main.splashscreen.util.SplashScreenHandler;

import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenFragment extends Fragment implements SplashScreenContract.View {

    private static final String TAG = "SplashScreenFragment";

    @BindView(R.id.prog)
    public ProgressBar mProgressBar;

    @BindView(R.id.load)
    public TextView mTextView;

    private SplashScreenContract.Presenter mPresenter;

    private Handler mHandler;

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

        mHandler = new SplashScreenHandler(mPresenter);
        mPresenter.onStart(new SplashScreenRunnable());
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void setProgressBarValue(Integer progress) {
        mProgressBar.setProgress(progress);
    }

    @Override
    public void sendMessage(AtomicInteger progress) {
        Message message = createMessage(progress);
        mHandler.sendMessage(message);
    }

    @Override
    public void setProgressText(String text) {
        mTextView.setText(text);
    }

    @Override
    public void incrementProgressBar(Integer progress) {
        mProgressBar.incrementProgressBy(progress);
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

    private Message createMessage(AtomicInteger progress) {
        Message message = mHandler.obtainMessage();
        message.obj = progress;

        return message;
    }

    private void startMainActivity() {
        Intent intent = new Intent(getContext(), MainActivity.class);
        startActivity(intent);
    }

    private void finishActivity() {
        getActivity().finish();
    }

    private class SplashScreenRunnable implements Runnable {

        @Override
        public void run() {
            try {
                mPresenter.doBackgroundProcess();
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            }

            mPresenter.moveToMainActivity();
        }
    }
}
