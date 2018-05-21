package com.herballife.main.penyakit.search;

import android.content.Intent;
import android.os.Bundle;
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
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;
import com.herballife.main.penyakit.detail.DetailPenyakitActivity;
import com.herballife.main.util.Injection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PenyakitSearchFragment extends Fragment {

    public static final String PENYAKIT_EXTRAS_NAME = "penyakit";

    @BindView(R.id.selection)
    public TextView mSelectionPenyakit;

    @BindView(R.id.edit)
    public AutoCompleteTextView mListPenyakit;

    public static PenyakitSearchFragment newInstance() {
        return new PenyakitSearchFragment();
    }

    private List<Penyakit> mPenyakits;
    private PenyakitRepository mPenyakitRepository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPenyakitRepository = Injection.providePenyakitRepository(getContext());
    }

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
        mPenyakitRepository.loadPenyakit(new PenyakitRepositoryCallback());
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
            mSelectionPenyakit.setText(mListPenyakit.getText());
        }

        @Override
        public void afterTextChanged(Editable s) {
            // Do nothing
        }
    }

    private class ListPenyakitOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Penyakit penyakit = getPenyakitFromName(mListPenyakit.getText().toString());

            if (isFound(penyakit))
                moveIntoDetailPenyakit(penyakit);
        }

        private Penyakit getPenyakitFromName(String name) {
            for (Penyakit penyakit : mPenyakits) {
                if (penyakit.getName().equals(name))
                    return penyakit;
            }

            return null;
        }

        private Boolean isFound(Penyakit penyakit) {
            return penyakit != null;
        }

        private void moveIntoDetailPenyakit(Penyakit penyakit) {
            Intent intent = new Intent(getContext(), DetailPenyakitActivity.class);
            intent.putExtra(PENYAKIT_EXTRAS_NAME, penyakit);

            moveActivity(intent);
        }
    }

    private class PenyakitRepositoryCallback implements PenyakitDataSource.LoadPenyakitCallback {

        @Override
        public void onLoadSuccess(List<Penyakit> penyakits) {
            List<String> names = getPenyakitNames(penyakits);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getContext(), android.R.layout.simple_dropdown_item_1line, names);

            mListPenyakit.setAdapter(adapter);
            mPenyakits = penyakits;
        }

        @Override
        public void onLoadFailed(String message) {
            Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        }

        private List<String> getPenyakitNames(List<Penyakit> penyakits) {
            List<String> names = new ArrayList<>();

            for (Penyakit penyakit : penyakits)
                names.add(penyakit.getName());

            return names;
        }
    }
}