package com.herballife.main.catalog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.herballife.main.R;

public class CatalogActivity extends AppCompatActivity implements CatalogContract.View {

    private ListView listView;
    private CatalogContract.Presenter presenter;

    @Override
    protected void onCreate (Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.list_katalog);

        listView = (ListView) findViewById(R.id.list_tumbuhan);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // tampilkan detail tumbuhan plus kegunaan
            }
        });

    }


    @Override
    public void showTumbuhan() {
//        presenter.setView();
    }

    @Override
    public void showDetailTumbuhan() {
//        presenter.setDetailView();
    }
}
