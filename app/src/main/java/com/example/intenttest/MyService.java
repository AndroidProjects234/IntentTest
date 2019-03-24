package com.example.intenttest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final String TAG="com.example.intenttest";
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //This is what the service does
      Log.i(TAG,"onStartCommand method called");
      Runnable r=new Runnable() {
          @Override
          public void run() {
              for(int i=0;i<5;i++){
                  long futureTime=System.currentTimeMillis()+5000;
                while(System.currentTimeMillis()<futureTime){
                    synchronized (this){
                        try{
                            wait(futureTime-System.currentTimeMillis());
                           Log.i(TAG,"service is doing something");
                        }catch (Exception e){}
                    }
                }
              }
          }
      };
        Thread buckysThread=new Thread(r);
        buckysThread.start();
        return Service.START_STICKY;    //It restart the service if service is destroy by system
    }

    @Override
    public void onDestroy() {
        //when service destroyed
        Log.i(TAG,"onDestroy method called");
    }

    @Override
    public IBinder onBind(Intent intent) {
       return null;
    }
}
