package security.bercy.com.week3day3.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.io.IOException;

import security.bercy.com.week3day3.Interfae.MusicInterface;
import security.bercy.com.week3day3.R;

public class MusicService extends Service {

    MediaPlayer mediaPlayer;
    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {

        return new MusicController();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
    }

    class MusicController extends Binder implements MusicInterface{

        public void play() {
            MusicService.this.play();

        }
        public void pause() {
            MusicService.this.pause();
        }


    }

    public void play() {
        mediaPlayer.reset();


            mediaPlayer = MediaPlayer.create(this,R.raw.changan);
          //  mediaPlayer.prepare();
            mediaPlayer.start();




    }
    public void pause() {
        mediaPlayer.pause();

    }
}
