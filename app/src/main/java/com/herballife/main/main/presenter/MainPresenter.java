package com.herballife.main.main.presenter;

import com.herballife.main.main.contract.MainContract;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void moveToSearchActivity() {
        mView.moveToSearchActivity();
    }

    @Override
    public void moveToCatalogActivity() {
        mView.moveToCatalogActivity();
    }

    @Override
    public void showHelpPopup() {
        mView.showHelpPopup();
    }

    @Override
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
