package br.com.lcruz.banners.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Lucas Cruz on 27/07/2017.
 */

public class BannerItem implements Parcelable {

    public String src;
    public String type;
    public String link;
    public String title;
    public String description;
    public String from;
    public int localSrc;

    public BannerItem(int localSrc) {
        this.localSrc = localSrc;
    }


    protected BannerItem(Parcel in) {
        src = in.readString();
        type = in.readString();
        link = in.readString();
        title = in.readString();
        description = in.readString();
        from = in.readString();
        localSrc = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(src);
        dest.writeString(type);
        dest.writeString(link);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(from);
        dest.writeInt(localSrc);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BannerItem> CREATOR = new Creator<BannerItem>() {
        @Override
        public BannerItem createFromParcel(Parcel in) {
            return new BannerItem(in);
        }

        @Override
        public BannerItem[] newArray(int size) {
            return new BannerItem[size];
        }
    };
}
