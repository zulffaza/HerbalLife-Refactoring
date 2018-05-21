package com.herballife.main.catalog.adapter;

import android.content.Context;
import android.view.LayoutInflater;

import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.model.Catalog;

import java.util.ArrayList;

public class CatalogAdapter {

    private ArrayList<Catalog> mCatalog;
    private Context mContext;
    private CatalogContract.Presenter mPresenter;
    private LayoutInflater mInflater;

    public CatalogAdapter(Context context, ArrayList<Catalog> catalogs, CatalogContract.Presenter presenter){
        mContext = context;
        mCatalog = catalogs;
        mPresenter = presenter;

        mInflater = LayoutInflater.from(context);



    }

}
