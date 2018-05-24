package com.herballife.main.penyakit.detail.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.herballife.main.R;
import com.herballife.main.catalog.view.activity.CatalogActivity;
import com.herballife.main.databinding.FragmentDetailPenyakitBinding;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.detail.contract.DetailPenyakitContract;
import com.herballife.main.penyakit.detail.viewmodel.DetailPenyakitViewModel;
import com.herballife.main.penyakit.view.fragment.PenyakitFragment;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailPenyakitFragment extends Fragment implements DetailPenyakitContract.View {

    @BindView(R.id.daftar_penyakit)
    public TextView mName;

    @BindView(R.id.bahan)
    public TextView mHerbalMedicine;

    @BindView(R.id.tutorial)
    public TextView mTutorial;

    @BindString(R.string.detail_penyakit_bahan_title)
    public String mHerbalMedicineTitle;

    @BindString(R.string.detail_penyakit_tutorial_title)
    public String mTutorialTitle;

    private DetailPenyakitContract.ViewModel mViewModel;

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
        FragmentDetailPenyakitBinding fragmentDetailPenyakitBinding = FragmentDetailPenyakitBinding
                .inflate(inflater, container, false);
        fragmentDetailPenyakitBinding.setView(this);
        fragmentDetailPenyakitBinding.setDetailPenyakitViewModel((DetailPenyakitViewModel) mViewModel);

        View view = fragmentDetailPenyakitBinding.getRoot();
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart(mPenyakit);
    }

    @Override
    public String getHerbalMedicineTitle() {
        return mHerbalMedicineTitle;
    }

    @Override
    public String getTutorialTitle() {
        return mTutorialTitle;
    }

    @Override
    public void moveToCatalogActivity() {
        Intent intent = new Intent(getContext(), CatalogActivity.class);
        startActivity(intent);
    }

    @Override
    public void setViewModel(@NonNull DetailPenyakitContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

}
