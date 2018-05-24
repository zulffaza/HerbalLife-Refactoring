package com.herballife.main.penyakit.search.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.view.View;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.search.contract.PenyakitSearchContract;

public class PenyakitSearchItemViewModel extends BaseObservable
        implements PenyakitSearchContract.ItemViewModel {

    public final ObservableField<Penyakit> penyakit = new ObservableField<>();

    public final ObservableField<String> name = new ObservableField<>();

    private PenyakitSearchContract.View mView;

    public PenyakitSearchItemViewModel(PenyakitSearchContract.View view, Penyakit penyakit) {
        mView = view;
        this.penyakit.set(penyakit);
        this.name.set(this.penyakit.get().getName());
    }

    public void moveToDetailActivity(View view) {
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
