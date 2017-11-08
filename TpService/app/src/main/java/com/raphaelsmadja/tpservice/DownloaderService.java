package com.raphaelsmadja.tpservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.util.Log;

public class DownloaderService extends Service {

    public static final String TAG_DOWNLOADER_SERVICE = "TAG_Downloader_Service";

    public DownloaderService() {
    }
    private DownloaderThread downloaderThread;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG_DOWNLOADER_SERVICE,"onCreate");
        downloaderThread = new DownloaderThread();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG_DOWNLOADER_SERVICE,"onStartCommand");
        downloaderThread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG_DOWNLOADER_SERVICE,"onDestroy");
        downloaderThread.interrupt();
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Log.i(TAG_DOWNLOADER_SERVICE, "OnBind");
        return new DownloaderBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG_DOWNLOADER_SERVICE,"onUnbind");
        return super.onUnbind(intent);
    }

    public class DownloaderBinder extends Binder {
        public long getDownloadedNbByte() {
            return downloaderThread.getNbByte();
        }
    }
}
