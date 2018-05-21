package com.herballife.main.catalog.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.herballife.main.R;
import com.herballife.main.catalog.presenter.CatalogPresenter;
import com.herballife.main.catalog.view.fragment.CatalogFragment;
import com.herballife.main.util.ActivityUtils;
import com.herballife.main.util.Injection;

import java.util.HashMap;

public class CatalogActivity extends AppCompatActivity {

    private final String mCatalogTag = "Catalog Fragment";
    private final String mFragmentTag = "Fragment";

    private FragmentManager mFragmentManager;
    private HashMap<Integer, HashMap<String, Object>> mMenuMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_katalog);

        CatalogFragment catalogFragment = CatalogFragment.newInstance();
        ActivityUtils.addFragmentToActivity(
                mFragmentManager,
                catalogFragment,
                R.id.catalogTumbuhan,
                mCatalogTag);

        new CatalogPresenter(Injection.provideCatalogRepository(this), catalogFragment);

    }
}
