package com.herballife.main.main.viewmodel;

import com.herballife.main.main.contract.MainContract;

public class MainViewModel implements MainContract.ViewModel {

    private final MainContract.View mView;

    public MainViewModel(MainContract.View view) {
        mView = view;
        mView.setViewModel(this);
    }

    public void moveToSearchActivity() {
        mView.moveToSearchActivity();
    }

    public void moveToCatalogActivity() {
        mView.moveToCatalogActivity();
    }

    public void showHelpPopup() {
        mView.showHelpPopup();
    }

    public void showExitConfirmationPopup() {
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
