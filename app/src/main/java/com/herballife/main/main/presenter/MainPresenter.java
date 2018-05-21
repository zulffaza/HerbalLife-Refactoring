package com.herballife.main.main.presenter;

import com.herballife.main.catalog.view.activity.CatalogActivity;
import com.herballife.main.main.contract.MainContract;
import com.herballife.main.penyakit.view.activity.PenyakitActivity;

public class MainPresenter implements MainContract.Presenter {

    private final MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void moveToSearchActivity() {
        mView.moveActivity(PenyakitActivity.class);
    }

    @Override
    public void moveToCatalogActivity() {
        mView.moveActivity(CatalogActivity.class);
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
