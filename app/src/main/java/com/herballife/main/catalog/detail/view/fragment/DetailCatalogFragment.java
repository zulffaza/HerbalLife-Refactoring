package com.herballife.main.catalog.detail.view.fragment;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.herballife.main.R;
import com.herballife.main.catalog.detail.contract.DetailCatalogContract;
import com.herballife.main.catalog.view.fragment.CatalogFragment;
import com.herballife.main.model.Catalog;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailCatalogFragment extends Fragment implements DetailCatalogContract.View {

    @BindView(R.id.nama_tumbuhan)
    public TextView mName;

    @BindView(R.id.kegunaan)
    public TextView mUse;

    @BindView(R.id.gambar)
    public ImageView mImage;

    @BindString(R.string.detail_catalog_use_title)
    public String mUseTitle;

    private DetailCatalogContract.Presenter mPresenter;

    private Catalog mCatalog;

    public static DetailCatalogFragment newInstance(Catalog catalog) {
        DetailCatalogFragment detailCatalogFragment = new DetailCatalogFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable(CatalogFragment.CATALOG_EXTRAS_NAME, catalog);
        detailCatalogFragment.setArguments(bundle);

        return detailCatalogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            mCatalog = getArguments().getParcelable(CatalogFragment.CATALOG_EXTRAS_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_catalog, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart(mCatalog);
    }

    @Override
    public void setPresenter(@NonNull DetailCatalogContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    @Override
    public void showCatalog() {
        String use = mUseTitle + mCatalog.getUse();
        Bitmap image = mPresenter.createBitmapFromByteArray(mCatalog.getImage());

        mName.setText(mCatalog.getName());
        mUse.setText(use);
        mImage.setImageBitmap(image);
    }
}
