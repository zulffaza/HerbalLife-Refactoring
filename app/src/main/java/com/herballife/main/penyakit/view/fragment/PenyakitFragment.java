package com.herballife.main.penyakit.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.search.view.activity.PenyakitSearchActivity;
import com.herballife.main.penyakit.detail.view.activity.DetailPenyakitActivity;
import com.herballife.main.R;
import com.herballife.main.model.Penyakit;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class PenyakitFragment extends Fragment implements PenyakitContract.View {

    public static final String PENYAKIT_EXTRAS_NAME = "penyakit";

    @BindView(R.id.listpenyakit)
    public ListView mListPenyakit;

    @OnItemClick(R.id.listpenyakit)
    public void moveToDetail(int position) {
        mPresenter.moveToDetailActivity(position);
    }

    @OnClick(R.id.tombol_cari)
    public void moveToSearch() {
        mPresenter.moveToSearchActivity();
    }

    public static PenyakitFragment newInstance() {
        return new PenyakitFragment();
    }

    private PenyakitContract.ViewModel mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penyakit, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void showPenyakits(List<String> penyakitNames) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                getContext(), android.R.layout.simple_list_item_1, penyakitNames);

        mListPenyakit.setAdapter(adapter);
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
        mPresenter = viewModel;
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }
}
