package security.bercy.com.week3day3;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import security.bercy.com.week3day3.Interfae.MusicInterface;
import security.bercy.com.week3day3.Service.MusicService;

public class MusicPlayer extends AppCompatActivity {

    MusicInterface musicInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        Intent intent = new Intent(this, MusicService.class);
        startService(intent);//activity close will not kill the service
        bindService(intent,new MusicServiceConn(),BIND_AUTO_CREATE);//get the play and pause method
    }
    class MusicServiceConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            musicInterface = (MusicInterface) iBinder;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }


    public void play(View view) {
        musicInterface.play();
    }

    public void pause(View view) {
        musicInterface.pause();
    }
}
