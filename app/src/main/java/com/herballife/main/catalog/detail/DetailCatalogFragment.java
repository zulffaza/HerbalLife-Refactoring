package com.herballife.main.catalog.detail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.herballife.main.R;
import com.herballife.main.catalog.CatalogFragment;
import com.herballife.main.model.Catalog;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailCatalogFragment extends Fragment {

    @BindView(R.id.nama_tumbuhan)
    public TextView mName;

    @BindView(R.id.kegunaan)
    public TextView mUse;

    @BindView(R.id.gambar)
    public ImageView mImage;

    @BindString(R.string.detail_catalog_use_title)
    public String mUseTitle;

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
        View view = inflater.inflate(R.layout.fragment_detail_catalog, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (isCatalogSet())
            showCatalog();
    }

    private Boolean isCatalogSet() {
        return mCatalog != null;
    }

    private void showCatalog() {
        String use = mUseTitle + mCatalog.getUse();
        Bitmap image = BitmapFactory.decodeByteArray(mCatalog.getImage(),
                0, mCatalog.getImage().length);

        mName.setText(mCatalog.getName());
        mUse.setText(use);
        mImage.setImageBitmap(image);
    }
}
