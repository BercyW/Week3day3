package security.bercy.com.week3day3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void musicplayer(View view) {

        Intent intent = new Intent(this,MusicPlayer.class);
        startActivity(intent);


    }

    public void showData(View view) {
        Intent intent = new Intent(this,ShowData.class);
        startActivity(intent);

    }
}
