package com.herballife.main.penyakit.search.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.herballife.main.R;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.detail.view.activity.DetailPenyakitActivity;
import com.herballife.main.penyakit.search.contract.PenyakitSearchContract;

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

    private PenyakitSearchContract.ViewModel mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_penyakit_search, container, false);
        ButterKnife.bind(this, view);

        mListPenyakit.addTextChangedListener(new ListPenyakitTextWatcher());
        mListPenyakit.setOnItemClickListener(new ListPenyakitOnItemClickListener());

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
                getContext(), android.R.layout.simple_dropdown_item_1line, penyakitNames);

        mListPenyakit.setAdapter(adapter);
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSelection(String name) {
        mSelectionPenyakit.setText(name);
    }

    @Override
    public void moveIntoDetailPenyakit(Penyakit penyakit) {
        Intent intent = new Intent(getContext(), DetailPenyakitActivity.class);
        intent.putExtra(PENYAKIT_EXTRAS_NAME, penyakit);

        moveActivity(intent);
    }

    @Override
    public void setViewModel(@NonNull PenyakitSearchContract.ViewModel viewModel) {
        mPresenter = viewModel;
    }

    private void moveActivity(Intent intent) {
        startActivity(intent);
    }

    private class ListPenyakitTextWatcher implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // Do nothing
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String name = mListPenyakit.getText().toString();
            mPresenter.changeSelection(name);
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Do nothing
        }
    }

    private class ListPenyakitOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String name = mListPenyakit.getText().toString();
            mPresenter.moveIntoDetailPenyakit(name);
        }
    }
}
