package com.herballife.main.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.herballife.main.penyakit.PenyakitActivity;
import com.herballife.main.catalog.CatalogActivity;
import com.herballife.main.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainFragment extends Fragment {

    @OnClick(R.id.btn_search)
    public void moveToSearchActivity() {
        moveActivity(PenyakitActivity.class);
    }

    @OnClick(R.id.btn_catalog)
    public void moveToCatalogActivity() {
        moveActivity(CatalogActivity.class);
    }

    @OnClick(R.id.btn_help)
    public void showHelpDialog() {
        String title = getString(R.string.main_help_title);
        String message = getString(R.string.main_help_message);
        String ok = getString(R.string.ok);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        AlertDialog helpDialog = builder.create();
        helpDialog.setIcon(R.drawable.help);
        helpDialog.setTitle(title);
        helpDialog.show();
    }

    @OnClick(R.id.btn_exit)
    public void showExitDialog() {
        String title = getString(R.string.main_exit_title);
        String message = getString(R.string.main_exit_message);

        String ya = getString(R.string.ya);
        String tidak = getString(R.string.tidak);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(tidak, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setNegativeButton(ya, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        getActivity().finish();
                    }
                });

        AlertDialog exitDialog = builder.create();
        exitDialog.setIcon(R.drawable.exit);
        exitDialog.setTitle(title);
        exitDialog.show();
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    private void moveActivity(Class destinationActivity) {
        Intent intent = new Intent(getContext(), destinationActivity);
        startActivity(intent);
    }
}
