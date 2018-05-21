package com.herballife.main.penyakit.datasource.local;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.herballife.main.db.SQLiteDBHelper;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;

import java.util.ArrayList;
import java.util.List;

public class PenyakitLocalDataSource implements PenyakitDataSource {

    private static final String SQL = "select * from data_penyakit";

    private static PenyakitLocalDataSource sInstance = null;

    private SQLiteDBHelper mSqLiteDBHelper;

    private PenyakitLocalDataSource(Context context) {
        mSqLiteDBHelper = new SQLiteDBHelper(context);
    }

    public static PenyakitLocalDataSource getInstance(Context context) {
        if (sInstance == null)
            sInstance = new PenyakitLocalDataSource(context);

        return sInstance;
    }

    @Override
    public void loadPenyakit(LoadPenyakitCallback loadPenyakitCallback) {
        try {
            SQLiteDatabase sqLiteDatabase = mSqLiteDBHelper.getDb();

            Cursor cursor = sqLiteDatabase.rawQuery(SQL, null);
            List<Penyakit> penyakits = getDataSet(cursor);

            loadPenyakitCallback.onLoadSuccess(penyakits);
        } catch (SQLException e) {
            loadPenyakitCallback.onLoadFailed(e.getMessage());
        }
    }

    private List<Penyakit> getDataSet(Cursor cursor) {
        List<Penyakit> penyakits = new ArrayList<>();

        if (isMoveToFirst(cursor))
            readCursor(penyakits, cursor);

        return penyakits;
    }

    private Boolean isMoveToFirst(Cursor cursor) {
        return cursor.moveToFirst();
    }

    private void readCursor(List<Penyakit> penyakits, Cursor cursor) {
        while (isMoveToNext(cursor)) {
            Penyakit penyakit = readPenyakit(cursor);
            penyakits.add(penyakit);
        }

        cursor.close();
    }

    private Boolean isMoveToNext(Cursor cursor) {
        return cursor.moveToNext();
    }

    private Penyakit readPenyakit(Cursor cursor) {
        Integer id = cursor.getInt(cursor.getColumnIndex(Penyakit.ID_COLUMN_NAME));
        String name = cursor.getString(cursor.getColumnIndex(Penyakit.NAME_COLUMN_NAME));
        String herbalMedicine = cursor.getString(cursor.getColumnIndex(Penyakit.HERBAL_MEDICINE_COLUMN_NAME));
        String tutorial = cursor.getString(cursor.getColumnIndex(Penyakit.TUTORIAL_COLUMN_NAME));

        return Penyakit.builder()
                .id(id)
                .name(name)
                .herbalMedicine(herbalMedicine)
                .tutorial(tutorial)
                .build();
    }
}
