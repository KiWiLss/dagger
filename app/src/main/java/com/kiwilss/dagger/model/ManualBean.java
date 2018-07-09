package com.kiwilss.dagger.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * FileName: ManualBean
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class ManualBean implements Parcelable {
    private String name;
    private int age;

    public ManualBean(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    protected ManualBean(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<ManualBean> CREATOR = new Parcelable.Creator<ManualBean>() {
        @Override
        public ManualBean createFromParcel(Parcel source) {
            return new ManualBean(source);
        }

        @Override
        public ManualBean[] newArray(int size) {
            return new ManualBean[size];
        }
    };

    @Override
    public String toString() {
        return "ManualBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
