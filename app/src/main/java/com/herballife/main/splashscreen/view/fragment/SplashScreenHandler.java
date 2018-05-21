package com.herballife.main.splashscreen.view.fragment;

import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

public class SplashScreenHandler extends Handler {

    private static final Integer INCREMENT_PROGRESS = 20;

    private TextView mTextView;
    private ProgressBar mProgressBar;

    SplashScreenHandler(TextView textView, ProgressBar progressBar) {
        mTextView = textView;
        mProgressBar = progressBar;
    }

    @Override
    public void handleMessage(Message msg) {
        AtomicInteger progress = (AtomicInteger) msg.obj;
        updateProgressBar(progress);
    }

    private void updateProgressBar(AtomicInteger progress) {
        String text = progress.addAndGet(INCREMENT_PROGRESS) + "% Completed";

        mTextView.setText(text);
        mProgressBar.incrementProgressBy(INCREMENT_PROGRESS);
    }
}
