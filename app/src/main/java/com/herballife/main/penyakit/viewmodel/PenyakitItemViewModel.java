package com.herballife.main.penyakit.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;

public class PenyakitItemViewModel extends BaseObservable
        implements PenyakitContract.RowViewModel {

    public final ObservableField<Penyakit> penyakit = new ObservableField<>();

    public final ObservableField<String> name = new ObservableField<>();

    private PenyakitContract.View mView;

    public PenyakitItemViewModel(PenyakitContract.View view, Penyakit penyakit) {
        mView = view;
        this.penyakit.set(penyakit);
        this.name.set(this.penyakit.get().getName());
    }

    @Override
    public void moveToDetailActivity() {
        mView.moveToDetailActivity(penyakit.get());
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        // Do nothing
    }

    @Override
    public void onResume() {
        // Do nothing
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        // Do nothing
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }
}
