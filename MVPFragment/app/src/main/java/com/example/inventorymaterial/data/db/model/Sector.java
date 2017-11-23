package com.example.inventorymaterial.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by usuario on 30/10/17.
 */

public class Sector implements Parcelable {
    private int _ID;
    private String name;
    private String shortname;
    private String description;
    private int dependencyId;
    private boolean enable;
    private boolean _default;

    public Sector(int _ID, String name, String shortname, String description, int dependencyId, boolean enable, boolean _default) {
        this._ID = _ID;
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.dependencyId = dependencyId;
        this.enable = enable;
        this._default = _default;
    }

    protected Sector(Parcel in) {
        _ID = in.readInt();
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
        dependencyId = in.readInt();
        enable = in.readByte() != 0;
        _default = in.readByte() != 0;
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public boolean is_default() {
        return _default;
    }

    public void set_default(boolean _default) {
        this._default = _default;
    }

    public int get_ID() {
        return _ID;
    }

    public void set_ID(int _ID) {
        this._ID = _ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDependencyId() {
        return dependencyId;
    }

    public void setDependencyId(int dependencyId) {
        this.dependencyId = dependencyId;
    }


    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(_ID);
        parcel.writeString(name);
        parcel.writeString(shortname);
        parcel.writeString(description);
        parcel.writeInt(dependencyId);
        parcel.writeByte((byte) (enable ? 1 : 0));
        parcel.writeByte((byte) (_default ? 1 : 0));
    }
}
