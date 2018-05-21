package com.herballife.main;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.herballife.main.catalog.model.Catalog;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamal on 5/8/17.
 */

public class SQLiteDBHelper extends SQLiteAssetHelper {

    // Table Names
    private static final String TABLE_CATALOG = "Katalog";

    // Common column names
    private static final String KEY_ID = "id";

    // Catalog Table - column nmaes
    private static final String KEY_NAMAKATALOG = "nama";
    private static final String KEY_KEGUNAANKATALOG = "kegunaan";
    private static final String KEY_GAMBARKATALOG = "gambar";

    private static final String DATABASE_NAME = "data2.sqlite";
    private static final int DATABASE_VERSION = 1;



    public SQLiteDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public SQLiteDatabase getDb(){
        return getWritableDatabase();
    }

    /*
    * Getting all Catalog
    * */

    public List<String> getAllCatalog(){
        ArrayList<String > listitem1 = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();

        String sql = "select * from Katalog";
        Cursor c = db.rawQuery(sql, null);
        c.moveToFirst();


        int i = 0;
        while (!c.isAfterLast())
        {
            int index = c.getColumnIndex("Nama");
            String temp = c.getString(index);
            listitem1.add(temp);

            i++;
            c.moveToNext();
        }

        return listitem1;
    }

}
