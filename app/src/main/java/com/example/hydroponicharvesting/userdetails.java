package com.example.hydroponicharvesting;
import android.os.Parcel;
import android.os.Parcelable;
public class userdetails implements Parcelable{
    private String name;
    private String mPassword;
    public  userdetails(Parcel in){
        name = in.readString();
        mPassword= in.readString();
    }
        public static final Parcelable.Creator CREATOR=new Parcelable.Creator<userdetails>() {

            @Override
            public userdetails createFromParcel(Parcel in) {
                return new userdetails(in);


            }

            @Override
            public userdetails[] newArray(int size) {
                return new userdetails[size];
            }
        };

    public userdetails() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(mPassword);
    }
}
