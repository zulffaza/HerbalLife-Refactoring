package com.herballife.main.catalog.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.detail.view.activity.DetailCatalogActivity;
import com.herballife.main.R;
import com.herballife.main.model.Catalog;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CatalogFragment extends Fragment implements CatalogContract.View {

    public static final String CATALOG_EXTRAS_NAME = "catalog";

    @BindView(R.id.list_tumbuhan)
    public ListView mListTumbuhan;

    @OnItemClick(R.id.list_tumbuhan)
    public void moveToDetail(int position) {
        mPresenter.moveToDetailActivity(position);
    }

    public static CatalogFragment newInstance() {
        return new CatalogFragment();
    }

    private CatalogContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_catalog, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void showCatalogs(List<String> catalogNames) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_list_item_1, catalogNames);

        mListTumbuhan.setAdapter(adapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void moveToDetailActivity(Catalog catalog) {
        Intent intent = new Intent(getContext(), DetailCatalogActivity.class);
        intent.putExtra(CATALOG_EXTRAS_NAME, catalog);

        moveActivity(intent);
    }

    @Override
    public void setPresenter(@NonNull CatalogContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }
}
