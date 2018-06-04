package com.kiwilss.dagger.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * FileName: MyProvider
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/4
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyProvider extends ContentProvider {

    public static final int TABLE1_DIR = 0 ;
    public static final int TABLE1_ITEM = 1 ;
    public static final int TABLE2_DIR = 2 ;
    public static final int TABLE2_ITEM = 3 ;

    private static UriMatcher mUriMatcher;

    static {
        mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        mUriMatcher.addURI("com.kiwilss.dagger.provider","table1",TABLE1_DIR);
        mUriMatcher.addURI("com.kiwilss.dagger.provider","table1/#",TABLE1_ITEM);
        mUriMatcher.addURI("com.kiwilss.dagger.provider","table2",TABLE2_DIR);
        mUriMatcher.addURI("com.kiwilss.dagger.provider","table2/#",TABLE2_ITEM);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        switch (mUriMatcher.match(uri)){
            case TABLE1_DIR:
                break;
            case TABLE1_ITEM:
                break;
            case TABLE2_DIR:
                break;
            case TABLE2_ITEM:
                break;
                default:
        }
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (mUriMatcher.match(uri)){
            case TABLE1_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table1";
            case TABLE1_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table1";
            case TABLE2_DIR:
                return "vnd.android.cursor.dir/vnd.com.example.app.provider.table2";
            case TABLE2_ITEM:
                return "vnd.android.cursor.item/vnd.com.example.app.provider.table2";
            default:
        }
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
