package com.herballife.main.catalog.datasource.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.herballife.main.catalog.datasource.CatalogDataSource;
import com.herballife.main.db.SQLiteDBHelper;
import com.herballife.main.model.Catalog;

import java.util.ArrayList;
import java.util.List;

public class CatalogLocalDataSource implements CatalogDataSource {

    private static final String SQL = "select * from Katalog";

    private static CatalogLocalDataSource sInstance = null;

    private SQLiteDBHelper mSqLiteDBHelper;

    private CatalogLocalDataSource(Context context) {
        mSqLiteDBHelper = new SQLiteDBHelper(context);
    }

    public static CatalogLocalDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new CatalogLocalDataSource(context);

        return sInstance;
    }

    @Override
    public void loadCatalog(LoadCatalogCallback loadCatalogCallback) {
        try {
            SQLiteDatabase sqLiteDatabase = mSqLiteDBHelper.getDb();

            Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
            List<Catalog> catalogs = getDataSet(cursor);

            loadCatalogCallback.onLoadSuccess(catalogs);
        } catch (SQLException e) {
            loadCatalogCallback.onLoadFailed(e.getMessage());
        }
    }

    private List<Catalog> getDataSet(Cursor cursor) {
        List<Catalog> catalogs = new ArrayList<>();

        if (isMoveToFirst(cursor))
            readCursor(catalogs, cursor);

        return catalogs;
    }

    private Boolean isMoveToFirst(Cursor cursor) {
        return cursor.moveToFirst();
    }

    private void readCursor(List<Catalog> catalogs, Cursor cursor) {
        while (isMoveToNext(cursor)) {
            Catalog catalog = readCatalog(cursor);
            catalogs.add(catalog);
        }

        cursor.close();
    }

    private Boolean isMoveToNext(Cursor cursor) {
        return cursor.moveToNext();
    }

    private Catalog readCatalog(Cursor cursor) {
        Integer id = cursor.getInt(cursor.getColumnIndex(Catalog.ID_COLUMN_NAME));
        String name = cursor.getString(cursor.getColumnIndex(Catalog.NAME_COLUMN_NAME));
        String use = cursor.getString(cursor.getColumnIndex(Catalog.USE_COLUMN_NAME));
        byte[] image = cursor.getBlob(cursor.getColumnIndex(Catalog.IMAGE_COLUMN_NAME));

        return Catalog.builder()
                .id(id)
                .name(name)
                .use(use)
                .image(image)
                .build();
    }
}
