package nizk.tvq.dovuitv;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class Nhapten extends AppCompatActivity {
    private EditText editText;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhapten);
        (editText = findViewById(R.id.edit_tennv)).getText();
        relativeLayout = findViewById(R.id.layoutnhapten);
        relativeLayout.setBackgroundResource(new thaydoigiaodien().thaydoigiaodien().getHinhanh());
        new CountDownTimer(30000, 500) {
            @Override
            public void onTick(long millisUntilFinished) {
                ((Button) findViewById(R.id.btn_nhaptem_play
                )).setBackgroundResource(new thaydoigiaodien().thaydoinutplay().getGdplay());
            }

            @Override
            public void onFinish() {
                this.start();
            }
        }.start();
    }

    public void vaochoi(View view) {
        Intent intent = new Intent(Nhapten.this, Play.class);
        String name = editText.getText().toString();
        intent.putExtra("tenngchoi", name);
        startActivity(intent);
    }
}