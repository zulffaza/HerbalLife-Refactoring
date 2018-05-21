package com.herballife.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Penyakit implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Penyakit createFromParcel(Parcel in) {
            return new Penyakit(in);
        }

        public Penyakit[] newArray(int size) {
            return new Penyakit[size];
        }
    };

    private Penyakit(Parcel in) {
        id = in.readInt();
        name = in.readString();
        herbalMedicine = in.readString();
        tutorial = in.readString();
    }

    public static final String ID_COLUMN_NAME = "PenyakitID";

    public static final String NAME_COLUMN_NAME = "Nama";

    public static final String HERBAL_MEDICINE_COLUMN_NAME = "BahanObat";

    public static final String TUTORIAL_COLUMN_NAME = "Tutorial";

    private Integer id;

    private String name;

    private String herbalMedicine;

    private String tutorial;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(herbalMedicine);
        dest.writeString(tutorial);
    }
}
