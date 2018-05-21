package com.herballife.main.penyakit;

import android.content.Context;
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
import com.herballife.main.penyakit.search.PenyakitSearchActivity;
import com.herballife.main.penyakit.detail.DetailPenyakitActivity;
import com.herballife.main.R;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;
import com.herballife.main.util.Injection;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;



public class PenyakitFragment extends Fragment implements PenyakitContract.View{

    public static final String PENYAKIT_EXTRAS_NAME = "penyakit";

    private PenyakitContract.Presenter mPenyakitPresenter;

    @BindView(R.id.listpenyakit)
    public ListView mListPenyakit;

    @OnItemClick(R.id.listpenyakit)
    public void moveToDetail(int position) {
        Penyakit penyakit = mPenyakits.get(position);

        Intent intent = new Intent(getContext(), DetailPenyakitActivity.class);
        intent.putExtra(PENYAKIT_EXTRAS_NAME, penyakit);

//        moveActivity(intent);
        mPenyakitPresenter.moveActivity(intent);
    }

    @OnClick(R.id.tombol_cari)
    public void moveToSearch() {
        Intent intent = new Intent(getContext(), PenyakitSearchActivity.class);
//        moveActivity(intent);
        mPenyakitPresenter.moveActivity(intent);
    }

    public static PenyakitFragment newInstance() {
        return new PenyakitFragment();
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
        View view = inflater.inflate(R.layout.fragment_penyakit, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPenyakitRepository.loadPenyakit(new PenyakitRepositoryCallback());

        mPenyakitPresenter.onStart();
    }

    @Override
    public void moveActivity(Intent intent) {
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showpenyakit(List<Penyakit> penyakitList) {

    }

    @Override
    public void setPresenter(@NonNull PenyakitContract.Presenter presenter) {
        mPenyakitPresenter = presenter;
    }

    @Override
    public Context getContextView() {
        return getContext();
    }

    private class PenyakitRepositoryCallback implements PenyakitDataSource.LoadPenyakitCallback {

        @Override
        public void onLoadSuccess(List<Penyakit> penyakits) {
            List<String> names = getPenyakitNames(penyakits);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    getContext(), android.R.layout.simple_list_item_1, names);

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
