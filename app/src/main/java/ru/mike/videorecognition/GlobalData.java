package ru.mike.videorecognition;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Shishov M.V. on 10/07/2015.
 */
public class GlobalData extends Application {

    private static final String rootSDCard = "/sdcard/";
    private static final String keyRootPath = "rootPathKey";
    private static final String keyDBPath = "dbPathKey";
    private static final String keyFilesPath = "filesPathKey";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public String getRootPath() {
        final SharedPreferences settings = PreferenceManager.
                getDefaultSharedPreferences(getApplicationContext());
        return settings==null ?
                rootSDCard + getText(R.string.app_name).toString() :
                settings.getString(keyRootPath, rootSDCard + getText(R.string.app_name).toString());
    }

    public String getDBPath() {
        final SharedPreferences settings = PreferenceManager.
                getDefaultSharedPreferences(this);
        return settings==null ?
                rootSDCard + getText(R.string.app_name).toString() :
                settings.getString(keyDBPath, rootSDCard + getText(R.string.app_name).toString());
    }

    public String getFilesPath() {
        final SharedPreferences settings = PreferenceManager.
                getDefaultSharedPreferences(this);
        return settings==null ?
                rootSDCard + getText(R.string.app_name).toString() :
                settings.getString(keyFilesPath, rootSDCard + getText(R.string.app_name).toString());
    }

    public void SaveSettings(String rootPath, String dbPath, String filesPath) {
        final SharedPreferences settings = PreferenceManager.
                getDefaultSharedPreferences(this);
        final SharedPreferences.Editor edit = settings.edit();
        edit.putString(keyRootPath,rootPath);
        edit.putString(keyDBPath,dbPath);
        edit.putString(keyFilesPath,filesPath);
        edit.apply();
    }
}
