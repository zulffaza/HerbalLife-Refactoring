package com.herballife.main.base;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public abstract class BaseAdapter<T> extends ArrayAdapter<T> {

    public BaseAdapter(Context context, int resource, List<T> catalogs) {
        super(context, resource, catalogs);
    }

    public void replaceData(List<T> catalogs) {
        clear();
        addAll(catalogs);

        notifyDataSetChanged();
    }
}
