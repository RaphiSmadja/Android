package com.raphaelsmadja.tpservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startDownload(View view) {
        Intent intent = new Intent(this,DownloaderService.class);
        startService(intent);
    }
    public void stopDownload(View view) {
        Intent intent = new Intent(this,DownloaderService.class);
        stopService(intent);
    }
    ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            connected = true;
            downloaderBinder = (DownloaderService.DownloaderBinder) binder;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            connected = false;
        }
    };
    private boolean connected = false;
    private DownloaderService.DownloaderBinder downloaderBinder;
    public void connect(View view) {
        if (!connected) {
            Intent intent = new Intent(this, DownloaderService.class);
            bindService(intent, sc, BIND_AUTO_CREATE);
        } else {
            long nbByte = downloaderBinder.getDownloadedNbByte();
            Toast.makeText(this, " => " + nbByte, Toast.LENGTH_SHORT).show();
        }
    }


    public void disconnect(View view){
        unbindService(sc);
    }
}
