package com.herballife.main.splashscreen.view.fragment;

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
import com.herballife.main.databinding.FragmentSplashScreenBinding;
import com.herballife.main.main.view.activity.MainActivity;
import com.herballife.main.splashscreen.contract.SplashScreenContract;
import com.herballife.main.splashscreen.util.SplashScreenHandler;
import com.herballife.main.splashscreen.viewmodel.SplashScreenViewModel;

import java.util.concurrent.atomic.AtomicInteger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreenFragment extends Fragment implements SplashScreenContract.View {

    private static final String TAG = "SplashScreenFragment";

    @BindView(R.id.prog)
    public ProgressBar mProgressBar;

    @BindView(R.id.load)
    public TextView mTextView;

    private SplashScreenContract.ViewModel mViewModel;

    private Handler mHandler;

    public static SplashScreenFragment newInstance() {
        return new SplashScreenFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel.onCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSplashScreenBinding mFragmentSplashScreenBinding = FragmentSplashScreenBinding
                .inflate(inflater, container, false);
        mFragmentSplashScreenBinding.setView(this);
        mFragmentSplashScreenBinding.setSplashScreenViewModel((SplashScreenViewModel) mViewModel);

        View view = mFragmentSplashScreenBinding.getRoot();
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        mHandler = new SplashScreenHandler(mViewModel);
        mViewModel.onStart(new SplashScreenRunnable());
    }

    @Override
    public void onStop() {
        super.onStop();
        mViewModel.onStop();
    }

    @Override
    public void sendMessage(AtomicInteger progress) {
        Message message = createMessage(progress);
        mHandler.sendMessage(message);
    }

    @Override
    public void moveToMainActivity() {
        startMainActivity();
        finishActivity();
    }

    @Override
    public void setViewModel(@NonNull SplashScreenContract.ViewModel viewModel) {
        mViewModel = viewModel;
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
                mViewModel.doBackgroundProcess();
            } catch (InterruptedException e) {
                Log.e(TAG, e.getMessage());
            }

            mViewModel.moveToMainActivity();
        }
    }
}
