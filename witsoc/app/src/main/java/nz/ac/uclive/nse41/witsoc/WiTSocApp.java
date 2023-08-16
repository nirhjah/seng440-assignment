package nz.ac.uclive.nse41.witsoc;

import android.app.Application;

import android.app.Application;
import android.content.res.Resources;

public class WiTSocApp extends Application {
    private static Resources resources;

    @Override
    public void onCreate() {
        super.onCreate();

        resources = getResources();
    }

    public static Resources getAppResources() {
        return resources;
    }

}