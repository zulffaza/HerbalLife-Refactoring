package com.herballife.main.catalog;

import java.sql.Blob;

public interface CatalogContract {

    interface View{
        // menampilkan tumbuhan
        void showTumbuhan();

        void showDetailTumbuhan();
    }

    interface Model {
        // ambil data tumbuhan dari SQLite
        void setTumbuhan(String nama, String kegunaan, Blob image);

        String getTumbuhan();
    }

    interface Presenter {
        // menghubungkan model dengan view
        void setView(CatalogContract.View view);

        void setDetailView(CatalogContract.View view);

        void submitTumbuhan(String nama, String kegunaan, Blob image);

    }
}
