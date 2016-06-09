package my.flagdownloader;

import android.app.Application;

/**
 * Created by pavelhunko on 10.06.2016
 */
public class FlagDownloaderApp extends Application {

    private static FlagDownloaderApp instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static FlagDownloaderApp getInstance(){
        return instance;
    }
}
