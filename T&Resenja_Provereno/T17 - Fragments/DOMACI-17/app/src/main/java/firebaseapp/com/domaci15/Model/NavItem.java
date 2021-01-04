package firebaseapp.com.domaci15.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class NavItem implements Parcelable {

    private String title;
    private String subtitle;
    private int icon;

    // generalno treba konstruktor getteri i setteri to strings
    // treba promeniti nav item protected metodu i write to parcel metodu

    //konstruktor
    public NavItem(String title, String subtitle, int icon) {
        this.title = title;
        this.subtitle = subtitle;
        this.icon = icon;
    }

    protected NavItem(Parcel in) {
        title = in.readString();
        subtitle = in.readString();
        icon = in.readInt();
    }

    public static final Creator<NavItem> CREATOR = new Creator<NavItem>() {
        @Override
        public NavItem createFromParcel(Parcel in) {
            return new NavItem(in);
        }

        @Override
        public NavItem[] newArray(int size) {
            return new NavItem[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subtitle);
        dest.writeInt(icon);
    }
}
