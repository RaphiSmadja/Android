package com.raphaelsmadja.tpservice;

import android.util.Log;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by raphi on 03/10/2017.
 */

public class DownloaderThread extends Thread {
    public static final String TAG_DOWNLOADER_THREAD = "TAG_DownloaderThread";
    private AtomicLong nbByte = new AtomicLong(0);
    @Override
    public void run() {
        while (!isInterrupted()) {
            if (nbByte.incrementAndGet()%10000 == 0) {
                Log.i(TAG_DOWNLOADER_THREAD, "Downloaded" + nbByte.get());
            }
        }
    }
    /*
    public static void main(String args[]) throws InterruptedException {
        DownloaderThread downloaderThread = new DownloaderThread();
        downloaderThread.start();
        /**
         *  start permet d'executer la methode dans un thread a part
         *  interrupt permet de stoper le thread
         */
        /*Thread.sleep(1000);
        downloaderThread.interrupt();

    }*/
        public long getNbByte() {
            return nbByte.get();
        }
}
