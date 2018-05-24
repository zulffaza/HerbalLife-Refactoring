package com.herballife.main.penyakit.search.view.fragment;

import android.content.Intent;
import android.databinding.BindingAdapter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.herballife.main.R;
import com.herballife.main.databinding.FragmentPenyakitSearchBinding;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.detail.view.activity.DetailPenyakitActivity;
import com.herballife.main.penyakit.search.adapter.PenyakitSearchAdapter;
import com.herballife.main.penyakit.search.contract.PenyakitSearchContract;
import com.herballife.main.penyakit.search.viewmodel.PenyakitSearchViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PenyakitSearchFragment extends Fragment implements PenyakitSearchContract.View {

    public static final String PENYAKIT_EXTRAS_NAME = "penyakit";

    @BindView(R.id.selection)
    public TextView mSelectionPenyakit;

    @BindView(R.id.edit)
    public AutoCompleteTextView mListPenyakit;

    public static PenyakitSearchFragment newInstance() {
        return new PenyakitSearchFragment();
    }

    private PenyakitSearchContract.ViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPenyakitSearchBinding fragmentPenyakitSearchBinding = FragmentPenyakitSearchBinding
                .inflate(inflater, container, false);
        fragmentPenyakitSearchBinding.setView(this);
        fragmentPenyakitSearchBinding.setPenyakitSearchViewModel((PenyakitSearchViewModel) mViewModel);

        View view = fragmentPenyakitSearchBinding.getRoot();
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
    public void moveToDetailActivity(Penyakit penyakit) {
        Intent intent = new Intent(getContext(), DetailPenyakitActivity.class);
        intent.putExtra(PENYAKIT_EXTRAS_NAME, penyakit);

        moveActivity(intent);
    }

    @Override
    public void setViewModel(@NonNull PenyakitSearchContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @BindingAdapter("app:items")
    public static void setItems(AutoCompleteTextView autoCompleteTextView,
                                List<Penyakit> penyakits) {
        PenyakitSearchAdapter adapter = (PenyakitSearchAdapter) autoCompleteTextView.getAdapter();

        if (adapter != null)
            adapter.replaceData(penyakits);
    }

    private void setListPenyakit() {
        PenyakitSearchAdapter adapter = new PenyakitSearchAdapter(getContext(),
                R.layout.item_penyakit_search, new ArrayList<Penyakit>(), this);
        mListPenyakit.setAdapter(adapter);
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }
}
