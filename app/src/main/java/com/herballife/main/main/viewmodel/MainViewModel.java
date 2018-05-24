package com.herballife.main.main.viewmodel;

import android.view.View;

import com.herballife.main.main.contract.MainContract;

public class MainViewModel implements MainContract.ViewModel {

    private final MainContract.View mView;

    public MainViewModel(MainContract.View view) {
        mView = view;
        mView.setViewModel(this);
    }

    public void moveToSearchActivity(View view) {
        mView.moveToSearchActivity();
    }

    public void moveToCatalogActivity(View view) {
        mView.moveToCatalogActivity();
    }

    public void showHelpPopup(View view) {
        mView.showHelpPopup();
    }

    public void showExitConfirmationPopup(View view) {
        mView.showExitConfirmationPopup();
    }

    @Override
    public void onCreate() {
        // Do Nothing
    }

    @Override
    public void onStart() {
        // Do Nothing
    }

    @Override
    public void onResume() {
        // Do Nothing
    }

    @Override
    public void onPause() {
        // Do Nothing
    }

    @Override
    public void onStop() {
        // Do Nothing
    }

    @Override
    public void onDestroy() {
        // Do Nothing
    }
}
