package com.example.start_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

public class MyService extends Service {
    Timer timer;
    int i=0;
    public MyService() {



    }

    @Override
    public void onCreate(){
        super.onCreate();
        Log.v("oncreate","oncreate");
        timer=new Timer();
        timer.schedule(new MyTask(),0,1000);


    }

    public class MyTask extends TimerTask{

        @Override
        public void run() {
            Log.v("Brad","i="+i++);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {  //前景activity傳過來的東西
        int rand=intent.getIntExtra("i",-1);
        i=rand;
        Log.v("onStartCommand","onStartCommand");
        return super.onStartCommand(intent, flags, startId);

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("Destory","Destory");
        timer.cancel();
        timer.purge();
        timer=null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}
