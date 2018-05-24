package com.herballife.main.penyakit.search.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;

import com.herballife.main.databinding.ItemPenyakitSearchBinding;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.search.contract.PenyakitSearchContract;
import com.herballife.main.penyakit.search.viewmodel.PenyakitSearchItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class PenyakitSearchAdapter extends ArrayAdapter<Penyakit> {

    private Context mContext;

    private List<Penyakit> mPenyakits, mRealPenyakits;

    private PenyakitSearchContract.View mView;

    private Filter mFilter;

    public PenyakitSearchAdapter(Context context, int resource, List<Penyakit> penyakits,
                                 PenyakitSearchContract.View view) {
        super(context, resource, penyakits);
        mContext = context;
        mPenyakits = penyakits;
        mView = view;

        mRealPenyakits = new ArrayList<>(mPenyakits);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createView(position, convertView, parent);
    }

    @NonNull
    @Override
    public Filter getFilter() {
        if (mFilter == null)
            mFilter = new PenyakitFilter();

        return mFilter;
    }

    private View createView(int position, View convertView, ViewGroup parent) {
        ItemPenyakitSearchBinding itemPenyakitSearchBinding = DataBindingUtil.getBinding(convertView);

        if (itemPenyakitSearchBinding == null)
            itemPenyakitSearchBinding = inflateNewView(parent);

        Penyakit penyakit = getItem(position);
        PenyakitSearchContract.ItemViewModel viewModel = new PenyakitSearchItemViewModel(
                mView, penyakit);

        itemPenyakitSearchBinding.setPenyakitSearchItemViewModel(
                (PenyakitSearchItemViewModel) viewModel);

        return itemPenyakitSearchBinding.getRoot();
    }

    private ItemPenyakitSearchBinding inflateNewView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        return ItemPenyakitSearchBinding.inflate(inflater, parent, false);
    }

    public void replaceData(List<Penyakit> penyakits) {
        replacePenyakits(penyakits);
        replaceRealPenyakits();

        notifyDataSetChanged();
    }

    private void replacePenyakits(List<Penyakit> penyakits) {
        clear();
        addAll(penyakits);
    }

    private void replaceRealPenyakits() {
        mRealPenyakits.clear();
        mRealPenyakits.addAll(mPenyakits);
    }

    private class PenyakitFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence name) {
            FilterResults result = new FilterResults();

            if (name != null && name.length() > 0) {
                String filterName = name.toString().toLowerCase();
                List<Penyakit> filteredPenyakits = createFilteredPenyakits(filterName);

                result.count = filteredPenyakits.size();
                result.values = filteredPenyakits;
            } else {
                synchronized (this) {
                    result.count = mRealPenyakits.size();
                    result.values = mRealPenyakits;
                }
            }

            return result;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            List<Penyakit> filtered = (List) results.values;

            replacePenyakits(filtered);
            notifyDataSetChanged();
            notifyDataSetInvalidated();
        }

        private List<Penyakit> createFilteredPenyakits(String filterName) {
            List<Penyakit> filter = new ArrayList<>();

            for (Penyakit penyakit : mRealPenyakits)
                filterPenyakit(penyakit, filterName, filter);

            return filter;
        }

        private void filterPenyakit(Penyakit penyakit, String filterName, List<Penyakit> filter) {
            if (isPenyakitContains(penyakit, filterName))
                filter.add(penyakit);
        }

        private Boolean isPenyakitContains(Penyakit penyakit, String filterName) {
            return penyakit.getName().toLowerCase().contains(filterName);
        }
    }
}
