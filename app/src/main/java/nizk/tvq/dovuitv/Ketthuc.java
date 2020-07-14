package nizk.tvq.dovuitv;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Ketthuc extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private TextView txt_ketthuc;
    private String namengchoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ketthuc);
        relativeLayout = findViewById(R.id.layoutketthuc);
        relativeLayout.setBackgroundResource(new thaydoigiaodien().thaydoigiaodien().getHinhanh());
        txt_ketthuc = findViewById(R.id.txtketthuc);
        Intent intent = getIntent();
        namengchoi = intent.getStringExtra("tenngchoi");
        txt_ketthuc.setText("Bạn " + namengchoi + " có " + intent.getIntExtra("cautraloidung", 0) + " câu trả lời đúng");
    }

    public void choilai(View view) {
        Intent intent = new Intent(Ketthuc.this, Play.class);
        intent.putExtra("tenngchoi", namengchoi);
        startActivity(intent);

    }

    public void khoe(View view) {
        Intent intent = new Intent(Ketthuc.this, kyniem.class);
        startActivity(intent);
    }
}
