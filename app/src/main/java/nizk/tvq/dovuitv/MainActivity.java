package nizk.tvq.dovuitv;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.giaodien);

        relativeLayout = findViewById(R.id.layoutMain);
        relativeLayout.setBackgroundResource(new thaydoigiaodien().thaydoigiaodien().getHinhanh());
        new CountDownTimer(30000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                ((Button) findViewById(R.id.btn_play)).setBackgroundResource(new thaydoigiaodien().thaydoinutplay().getGdplay());
            }

            @Override
            public void onFinish() {
                this.start();
            }
        }.start();
        new CountDownTimer(600000, 60000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.nhacnen);
                mediaPlayer.setVolume(5, 5);
                mediaPlayer.start();
            }

            @Override
            public void onFinish() {
                mediaPlayer.stop();
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    public void vaonhapten(View view) {
        Intent intent = new Intent(MainActivity.this, Nhapten.class);
        startActivity(intent);


    }


}
