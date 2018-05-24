package com.herballife.main.penyakit.view.fragment;

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
import com.herballife.main.databinding.FragmentPenyakitBinding;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.adapter.PenyakitAdapter;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.detail.view.activity.DetailPenyakitActivity;
import com.herballife.main.penyakit.search.view.activity.PenyakitSearchActivity;
import com.herballife.main.penyakit.viewmodel.PenyakitViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PenyakitFragment extends Fragment implements PenyakitContract.View {

    public static final String PENYAKIT_EXTRAS_NAME = "penyakit";

    @BindView(R.id.listpenyakit)
    public ListView mListPenyakit;

    public static PenyakitFragment newInstance() {
        return new PenyakitFragment();
    }

    private PenyakitContract.ViewModel mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentPenyakitBinding fragmentPenyakitBinding = FragmentPenyakitBinding.inflate(inflater,
                container, false);
        fragmentPenyakitBinding.setView(this);
        fragmentPenyakitBinding.setPenyakitViewModel((PenyakitViewModel) mViewModel);

        View view = fragmentPenyakitBinding.getRoot();
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
    public void moveToSearchActivity() {
        Intent intent = new Intent(getContext(), PenyakitSearchActivity.class);
        moveActivity(intent);
    }

    @Override
    public void setViewModel(@NonNull PenyakitContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @BindingAdapter("app:items")
    public static void setItems(ListView listView, List<Penyakit> penyakits) {
        PenyakitAdapter adapter = (PenyakitAdapter) listView.getAdapter();

        if (adapter != null)
            adapter.replaceData(penyakits);
    }

    private void setListPenyakit() {
        PenyakitAdapter adapter = new PenyakitAdapter(getContext(), R.layout.item_penyakit,
                new ArrayList<Penyakit>(), this);
        mListPenyakit.setAdapter(adapter);
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }
}
