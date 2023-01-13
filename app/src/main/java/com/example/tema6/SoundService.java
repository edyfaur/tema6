package com.example.tema6;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class SoundService extends Service {

    private MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int period = intent.getIntExtra("period", 0);
        int volume = intent.getIntExtra("volume", 0);
        int duration = intent.getIntExtra("duration", 0);
        SystemClock.sleep(period * 1000);

        mediaPlayer = MediaPlayer.create(this, R.raw.sound);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setVolume(volume/100f, volume/100f);
        mediaPlayer.start();
        SystemClock.sleep(duration);
        mediaPlayer.stop();
        mediaPlayer.release();
        stopSelf();
        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }
    }
}
