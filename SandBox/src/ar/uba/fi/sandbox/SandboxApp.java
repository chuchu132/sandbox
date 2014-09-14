package ar.uba.fi.sandbox;

import android.app.Application;
import android.content.Context;

public class SandboxApp extends Application {
    private static SandboxApp instance;

    public static SandboxApp getInstance() {
        return instance;
    }

    public static Context getContext(){
        return instance;
    }

    public void onCreate() {
        instance = this;
        super.onCreate();
    }
    
}