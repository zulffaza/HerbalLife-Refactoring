package com.herballife.main.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.herballife.main.MainActivity;
import com.herballife.main.R;

import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenFragment extends Fragment {

    private static final String TAG = "SplashScreenFragment";

    private static final Integer INITIAL_PROGRESS = 0;
    private static final Integer MAX_PROGRESS = 5;
    private static final Integer SLEEP_TIME = 1000;

    @BindView(R.id.prog)
    public ProgressBar mProgressBar;

    @BindView(R.id.load)
    public TextView mTextView;

    private Boolean mIsRunning = Boolean.FALSE;

    public static SplashScreenFragment newInstance() {
        return new SplashScreenFragment();
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
        mProgressBar.setProgress(INITIAL_PROGRESS);
        mIsRunning = Boolean.TRUE;

        startProgressBar();
    }

    @Override
    public void onStop() {
        super.onStop();
        mIsRunning = Boolean.FALSE;
    }

    private void startProgressBar() {
        Handler handler = new SplashScreenHandler(mTextView, mProgressBar);
        Runnable runnable = new SplashScreenRunnable(handler);

        new Thread(runnable).start();
    }

    private void handleProgressBar(Handler handler) throws InterruptedException {
        AtomicInteger progress = new AtomicInteger(INITIAL_PROGRESS);

        for (Integer i = INITIAL_PROGRESS; i < MAX_PROGRESS && mIsRunning; i++) {
            Thread.sleep(SLEEP_TIME);
            handler.sendMessage(createMessage(handler, progress));
        }
    }

    private Message createMessage(Handler handler, AtomicInteger progress) {
        Message message = handler.obtainMessage();
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

        private Handler mHandler;

        private SplashScreenRunnable(Handler handler) {
            mHandler = handler;
        }

        @Override
        public void run() {
            try {
                handleProgressBar(mHandler);
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            }

            startMainActivity();
            finishActivity();
        }
    }
}
