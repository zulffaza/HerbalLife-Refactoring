package com.herballife.main.util;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/**
 * Class yang bertugas untuk membantu memberikan hal yang dibutuhkan oleh activity
 *
 * @author Faza Zulfika P P
 * @version 1.0
 * @since 8 Oktober 2017
 */
public class ActivityUtils {

    /**
     * Method ini digunakan untuk menambahkan fragment ke dalam frame yang diinginkan
     *
     * @param fragmentManager merupakan fragment managet dari activity yang aktif
     * @param fragment        merupakan fragment yang ingin ditambahkan
     * @param frameId         merupakan id frame yang akan ditambahkan fragment didalamnya
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId) {
        fragmentManager.beginTransaction().add(frameId, fragment).commit();
    }

    /**
     * Method ini digunakan untuk menambahkan fragment ke dalam frame yang diinginkan
     *
     * @param fragmentManager merupakan fragment managet dari activity yang aktif
     * @param fragment        merupakan fragment yang ingin ditambahkan
     * @param frameId         merupakan id frame yang akan ditambahkan fragment didalamnya
     * @param tag             merupakan tag pengenal fragment
     */
    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager,
                                             @NonNull Fragment fragment, int frameId,
                                             @NonNull String tag) {
        fragmentManager.beginTransaction().add(frameId, fragment, tag).commit();
    }

    /**
     * Method ini digunakan untuk mereplace fragment didalam frame dengan fragment baru yang diinginkan
     *
     * @param fragmentManager merupakan fragment managet dari activity yang aktif
     * @param fragment        merupakan fragment yang ingin ditambahkan dan menggantikan fragment lama
     * @param frameId         merupakan id frame yang akan ditambahkan fragment didalamnya
     */
    public static void replaceFragmentOnActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId) {
        fragmentManager.beginTransaction().replace(frameId, fragment).commit();
    }

    /**
     * Method ini digunakan untuk mereplace fragment didalam frame dengan fragment baru yang diinginkan
     *
     * @param fragmentManager merupakan fragment managet dari activity yang aktif
     * @param fragment        merupakan fragment yang ingin ditambahkan dan menggantikan fragment lama
     * @param frameId         merupakan id frame yang akan ditambahkan fragment didalamnya
     * @param tag             merupakan tag pengenal fragment
     */
    public static void replaceFragmentOnActivity(@NonNull FragmentManager fragmentManager,
                                                 @NonNull Fragment fragment, int frameId,
                                                 @NonNull String tag) {
        fragmentManager.beginTransaction().replace(frameId, fragment, tag).commit();
    }
}
