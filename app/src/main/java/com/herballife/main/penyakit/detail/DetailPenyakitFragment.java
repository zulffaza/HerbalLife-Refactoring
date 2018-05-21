package com.herballife.main.penyakit.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.herballife.main.List_catalog;
import com.herballife.main.R;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.PenyakitFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailPenyakitFragment extends Fragment {

    @BindView(R.id.daftar_penyakit)
    public TextView mName;

    @BindView(R.id.bahan)
    public TextView mHerbalMedicine;

    @BindView(R.id.tutorial)
    public TextView mTutorial;

    @OnClick(R.id.button1)
    public void moveToCatalog() {
        Intent intent = new Intent(getContext(), List_catalog.class);
        startActivity(intent);
    }

    @BindString(R.string.detail_penyakit_bahan_title)
    public String mHerbalMedicineTitile;

    @BindString(R.string.detail_penyakit_tutorial_title)
    public String mTutorialTitile;

    private Penyakit mPenyakit;

    public static DetailPenyakitFragment newInstance(Penyakit penyakit) {
        DetailPenyakitFragment detailPenyakitFragment = new DetailPenyakitFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable(PenyakitFragment.PENYAKIT_EXTRAS_NAME, penyakit);
        detailPenyakitFragment.setArguments(bundle);

        return detailPenyakitFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            mPenyakit = getArguments().getParcelable(PenyakitFragment.PENYAKIT_EXTRAS_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_penyakit, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (isPenyakitSet())
            showPenyakit();
    }

    private Boolean isPenyakitSet() {
        return mPenyakit != null;
    }

    private void showPenyakit() {
        String herbalMedicine = mHerbalMedicineTitile + mPenyakit.getHerbalMedicine();
        String tutorial = mTutorialTitile + mPenyakit.getTutorial();

        mName.setText(mPenyakit.getName());
        mHerbalMedicine.setText(herbalMedicine);
        mTutorial.setText(tutorial);
    }
}
