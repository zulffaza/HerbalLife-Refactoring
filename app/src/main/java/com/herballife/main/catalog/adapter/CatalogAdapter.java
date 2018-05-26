package com.herballife.main.catalog.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herballife.main.base.BaseAdapter;
import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.viewmodel.CatalogItemViewModel;
import com.herballife.main.databinding.ItemCatalogBinding;
import com.herballife.main.model.Catalog;

import java.util.List;

public class CatalogAdapter extends BaseAdapter<Catalog> {

    private Context mContext;

    private CatalogContract.View mView;

    public CatalogAdapter(Context context, int resource, List<Catalog> catalogs,
                          CatalogContract.View view) {
        super(context, resource, catalogs);
        mContext = context;
        mView = view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ItemCatalogBinding itemCatalogBinding = DataBindingUtil.getBinding(convertView);

        if (itemCatalogBinding == null)
            itemCatalogBinding = inflateNewView(parent);

        Catalog catalog = getItem(position);
        CatalogContract.ItemViewModel viewModel = new CatalogItemViewModel(mView, catalog);

        itemCatalogBinding.setCatalogItemViewModel((CatalogItemViewModel) viewModel);

        return itemCatalogBinding.getRoot();
    }

    private ItemCatalogBinding inflateNewView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return ItemCatalogBinding.inflate(inflater, parent, false);
    }
}
