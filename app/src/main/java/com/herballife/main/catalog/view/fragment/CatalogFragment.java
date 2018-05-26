package com.herballife.main.catalog.view.fragment;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.herballife.main.R;
import com.herballife.main.base.BaseAdapter;
import com.herballife.main.catalog.adapter.CatalogAdapter;
import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.detail.view.activity.DetailCatalogActivity;
import com.herballife.main.catalog.viewmodel.CatalogViewModel;
import com.herballife.main.databinding.FragmentCatalogBinding;
import com.herballife.main.model.Catalog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CatalogFragment extends Fragment implements CatalogContract.View {

    public static final String CATALOG_EXTRAS_NAME = "catalog";

    @BindView(R.id.list_tumbuhan)
    public ListView mListTumbuhan;

    public static CatalogFragment newInstance() {
        return new CatalogFragment();
    }

    private CatalogContract.ViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentCatalogBinding fragmentCatalogBinding = FragmentCatalogBinding.inflate(inflater,
                container, false);
        fragmentCatalogBinding.setView(this);
        fragmentCatalogBinding.setCatalogViewModel((CatalogViewModel) mViewModel);

        View view = fragmentCatalogBinding.getRoot();
        ButterKnife.bind(this, view);

        setListPenyakit();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
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
    public void setViewModel(@NonNull CatalogContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @BindingAdapter("app:items")
    public static void setItems(ListView listView, List<Catalog> catalogs) {
        BaseAdapter<Catalog> adapter = (CatalogAdapter) listView.getAdapter();

        if (adapter != null)
            adapter.replaceData(catalogs);
    }

    private void setListPenyakit() {
        BaseAdapter<Catalog> adapter = new CatalogAdapter(getContext(), R.layout.item_catalog,
                new ArrayList<Catalog>(), this);
        mListTumbuhan.setAdapter(adapter);
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }
}
