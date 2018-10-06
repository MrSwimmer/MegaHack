package com.memebattle.megahack.core;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.widget.Chronometer;

import com.memebattle.megahack.App;
import com.memebattle.megahack.main.fragment.profile.data.model.ProfileStatus;
import com.memebattle.megahack.main.fragment.profile.domain.ApiProfileService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


public class TimeService extends Service {
    private Chronometer chronometer;
    long elapsedMillis;
    @Override
    public void onCreate(){

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        EventBus.getDefault().register(this);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Subscribe
    public void PushNotification(boolean isOnline) {
        elapsedMillis = 0;
        chronometer.setOnChronometerTickListener(chronometer -> {
            elapsedMillis = SystemClock.elapsedRealtime() - chronometer.getBase();
            if (elapsedMillis>300000){
                App.apiProfileService.setStatus(new ApiProfileService.ProfileStatusCallback() {
                    @Override
                    public void onSuccess(String string) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                },new ProfileStatus(false, App.settingsService.getUserId()));
            }
        });
    }
}
