package com.herballife.main.catalog.detail.view.fragment;

import android.databinding.BindingAdapter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.herballife.main.R;
import com.herballife.main.catalog.detail.contract.DetailCatalogContract;
import com.herballife.main.catalog.detail.viewmodel.DetailCatalogViewModel;
import com.herballife.main.catalog.util.ByteUtils;
import com.herballife.main.catalog.view.fragment.CatalogFragment;
import com.herballife.main.databinding.FragmentDetailCatalogBinding;
import com.herballife.main.model.Catalog;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailCatalogFragment extends Fragment implements DetailCatalogContract.View {

    private static final Integer OFFSET = 0;

    @BindView(R.id.nama_tumbuhan)
    public TextView mName;

    @BindView(R.id.kegunaan)
    public TextView mUse;

    @BindView(R.id.gambar)
    public ImageView mImage;

    @BindString(R.string.detail_catalog_use_title)
    public String mUseTitle;

    private DetailCatalogContract.ViewModel mViewModel;

    private Catalog mCatalog;

    public static DetailCatalogFragment newInstance(Catalog catalog) {
        DetailCatalogFragment detailCatalogFragment = new DetailCatalogFragment();
        Bundle bundle = new Bundle();

        bundle.putParcelable(CatalogFragment.CATALOG_EXTRAS_NAME, catalog);
        detailCatalogFragment.setArguments(bundle);

        return detailCatalogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null)
            mCatalog = getArguments().getParcelable(CatalogFragment.CATALOG_EXTRAS_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentDetailCatalogBinding fragmentDetailCatalogBinding = FragmentDetailCatalogBinding
                .inflate(inflater, container, false);
        fragmentDetailCatalogBinding.setView(this);
        fragmentDetailCatalogBinding.setDetailCatalogViewModel((DetailCatalogViewModel) mViewModel);

        View view = fragmentDetailCatalogBinding.getRoot();
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart(mCatalog);
    }

    @Override
    public String getUseTitle() {
        return mUseTitle;
    }

    @Override
    public void setViewModel(@NonNull DetailCatalogContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @BindingAdapter("app:items")
    public static void setItems(ImageView imageView, Byte[] image) {
        Bitmap imageBitmap = BitmapFactory.decodeByteArray(ByteUtils.toByteArray(image),
                OFFSET, image.length);
        imageView.setImageBitmap(imageBitmap);
    }
}
