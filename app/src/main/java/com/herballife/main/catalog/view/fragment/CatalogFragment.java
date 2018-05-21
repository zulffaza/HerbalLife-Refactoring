package com.herballife.main.catalog.view.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.herballife.main.R;
import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.model.Catalog;

import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CatalogFragment extends Fragment implements CatalogContract.View {

    @BindView(R.id.list_tumbuhan)
    public ListView listView;

    private ArrayAdapter<String> mCatalogAdapter, mCategoryAdapter;

    private CatalogContract.Presenter mPresenter;

    public CatalogFragment() {

    }

    public static CatalogFragment newInstance() {

        return new CatalogFragment();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstance){

        View view = inflater.inflate(R.layout.list_katalog, container, false);
        ButterKnife.bind(this, view);

        return view;

    }

    @Override
    public void showToastMessage(@NonNull String message) {

    }

    @Override
    public void showCatalog(List<String> catalog) {

        if (mCatalogAdapter != null){
            mCatalogAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item);


        }

    }

    @Override
    public void showDetailCatalog(List<Catalog> catalog) {

    }

    @Override
    public void setPresenter(@NonNull CatalogContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }
}
