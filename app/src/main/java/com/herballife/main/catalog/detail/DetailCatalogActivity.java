package com.herballife.main.catalog.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.catalog.CatalogFragment;
import com.herballife.main.model.Catalog;
import com.herballife.main.util.ActivityUtils;

public class DetailCatalogActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_catalog);

        Catalog catalog = getIntent().getParcelableExtra(CatalogFragment.CATALOG_EXTRAS_NAME);
        DetailCatalogFragment detailCatalogFragment = DetailCatalogFragment.newInstance(catalog);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                detailCatalogFragment, R.id.fl_detail_catalog);
    }
}