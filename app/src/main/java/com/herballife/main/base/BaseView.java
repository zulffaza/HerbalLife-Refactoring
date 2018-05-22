package com.herballife.main.base;

import android.support.annotation.NonNull;

public interface BaseView<T> {

    void setViewModel(@NonNull T viewModel);
}
