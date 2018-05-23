package com.herballife.main.penyakit.adapter;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.herballife.main.databinding.ItemPenyakitBinding;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.viewmodel.PenyakitItemViewModel;

import java.util.List;

public class PenyakitAdapter extends BaseAdapter {

    private List<Penyakit> mPenyakits;

    private PenyakitContract.View mView;

    public PenyakitAdapter(List<Penyakit> penyakits, PenyakitContract.View view) {
        mPenyakits = penyakits;
        mView = view;
    }

    @Override
    public int getCount() {
        return mPenyakits.size();
    }

    @Override
    public Object getItem(int position) {
        return mPenyakits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemPenyakitBinding itemPenyakitBinding;

        if (convertView == null)
            itemPenyakitBinding = inflateNewView(parent);
        else
            itemPenyakitBinding = DataBindingUtil.getBinding(convertView);

        Penyakit penyakit = mPenyakits.get(position);
        PenyakitItemViewModel viewModel = new PenyakitItemViewModel(mView, penyakit);

        itemPenyakitBinding.setPenyakitItemViewModel(viewModel);

        return itemPenyakitBinding.getRoot();
    }

    private ItemPenyakitBinding inflateNewView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return ItemPenyakitBinding.inflate(inflater, parent, false);
    }

    public void replaceData(List<Penyakit> penyakits) {
        mPenyakits.clear();
        mPenyakits.addAll(penyakits);

        notifyDataSetChanged();
    }
}
