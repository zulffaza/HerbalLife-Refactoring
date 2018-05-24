package com.herballife.main.penyakit.detail.viewmodel;

import android.databinding.ObservableField;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.detail.contract.DetailPenyakitContract;

public class DetailPenyakitViewModel implements DetailPenyakitContract.ViewModel {

    private final DetailPenyakitContract.View mView;

    public final ObservableField<Penyakit> penyakit = new ObservableField<>();

    public final ObservableField<String> name = new ObservableField<>();

    public final ObservableField<String> herbalMedicine = new ObservableField<>();

    public final ObservableField<String> tutorial = new ObservableField<>();

    public DetailPenyakitViewModel(DetailPenyakitContract.View view) {
        mView = view;
        mView.setViewModel(this);
    }

    @Override
    public void moveToCatalogActivity() {
        mView.moveToCatalogActivity();
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
    public void onStart(Penyakit penyakit) {
        if (isPenyakitSet(penyakit)) {
            setPenyakit(penyakit);
            setFields();
        }
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

    private Boolean isPenyakitSet(Penyakit penyakit) {
        return penyakit != null;
    }

    private void setPenyakit(Penyakit penyakit) {
        this.penyakit.set(penyakit);
    }

    private void setFields() {
        String herbalMedicine = mView.getHerbalMedicineTitle() + " " +
                penyakit.get().getHerbalMedicine();
        String tutorial = mView.getTutorialTitle() + " " +
                penyakit.get().getTutorial();

        this.name.set(penyakit.get().getName());
        this.herbalMedicine.set(herbalMedicine);
        this.tutorial.set(tutorial);
    }
}
