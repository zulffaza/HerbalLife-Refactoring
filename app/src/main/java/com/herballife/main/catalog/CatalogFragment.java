package com.herballife.main.catalog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.herballife.main.catalog.detail.DetailCatalogActivity;
import com.herballife.main.R;
import com.herballife.main.catalog.datasource.CatalogDataSource;
import com.herballife.main.catalog.datasource.CatalogRepository;
import com.herballife.main.model.Catalog;
import com.herballife.main.util.Injection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class CatalogFragment extends Fragment {

    public static final String CATALOG_EXTRAS_NAME = "catalog";

    @BindView(R.id.list_tumbuhan)
    public ListView mListTumbuhan;

    @OnItemClick(R.id.list_tumbuhan)
    public void moveToDetail(int position) {
        Catalog catalog = mCatalogs.get(position);

        Log.d(CATALOG_EXTRAS_NAME, catalog.toString());

        Intent intent = new Intent(getContext(), DetailCatalogActivity.class);
        intent.putExtra(CATALOG_EXTRAS_NAME, catalog);

        moveActivity(intent);
    }

    public static CatalogFragment newInstance() {
        return new CatalogFragment();
    }

    private List<Catalog> mCatalogs;
    private CatalogRepository mCatalogRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCatalogRepository = Injection.provideCatalogRepository(getContext());
    }

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
        mCatalogRepository.loadCatalog(new CatalogRepositoryCallback());
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }

    private class CatalogRepositoryCallback implements CatalogDataSource.LoadCatalogCallback {

        @Override
        public void onLoadSuccess(List<Catalog> catalogs) {
            List<String> names = getCatalogNames(catalogs);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getContext(), android.R.layout.simple_list_item_1, names);

            mListTumbuhan.setAdapter(adapter);
            mCatalogs = catalogs;
        }

        @Override
        public void onLoadFailed(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        }

        private List<String> getCatalogNames(List<Catalog> catalogs) {
            List<String> names = new ArrayList<>();

            for (Catalog catalog : catalogs)
                names.add(catalog.getName());

            return names;
        }
    }
}
