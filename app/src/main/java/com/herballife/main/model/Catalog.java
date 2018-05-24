package com.herballife.main.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.herballife.main.catalog.util.ByteUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Catalog implements Parcelable {

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public Catalog createFromParcel(Parcel in) {
            return new Catalog(in);
        }

        public Catalog[] newArray(int size) {
            return new Catalog[size];
        }
    };

    private Catalog(Parcel in) {
        id = in.readInt();
        name = in.readString();
        use = in.readString();

        byte[] bytes = new byte[in.readInt()];
        in.readByteArray(bytes);

        image = ByteUtils.toByteObjectArray(bytes);
    }

    public static final String ID_COLUMN_NAME = "TumbuhanID";

    public static final String NAME_COLUMN_NAME = "Nama";

    public static final String USE_COLUMN_NAME = "Kegunaan";

    public static final String IMAGE_COLUMN_NAME = "Gambar";

    private Integer id;

    private String name;

    private String use;

    private Byte[] image;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(use);

        dest.writeInt(image.length);
        dest.writeByteArray(ByteUtils.toByteArray(image));
    }
}
