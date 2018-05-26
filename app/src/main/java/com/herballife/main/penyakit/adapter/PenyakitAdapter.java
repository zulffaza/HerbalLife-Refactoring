package com.herballife.main.penyakit.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herballife.main.base.BaseAdapter;
import com.herballife.main.databinding.ItemPenyakitBinding;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.viewmodel.PenyakitItemViewModel;

import java.util.List;

public class PenyakitAdapter extends BaseAdapter<Penyakit> {

    private Context mContext;

    private PenyakitContract.View mView;

    public PenyakitAdapter(Context context, int resource, List<Penyakit> penyakits,
                           PenyakitContract.View view) {
        super(context, resource, penyakits);
        mContext = context;
        mView = view;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ItemPenyakitBinding itemPenyakitBinding = DataBindingUtil.getBinding(convertView);

        if (itemPenyakitBinding == null)
            itemPenyakitBinding = inflateNewView(parent);

        Penyakit penyakit = getItem(position);
        PenyakitContract.ItemViewModel viewModel = new PenyakitItemViewModel(mView, penyakit);

        itemPenyakitBinding.setPenyakitItemViewModel((PenyakitItemViewModel) viewModel);

        return itemPenyakitBinding.getRoot();
    }

    private ItemPenyakitBinding inflateNewView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return ItemPenyakitBinding.inflate(inflater, parent, false);
    }
}
