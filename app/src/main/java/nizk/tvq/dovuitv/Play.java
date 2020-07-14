package nizk.tvq.dovuitv;

import android.app.Dialog;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Play extends AppCompatActivity {
    private String namengchoi;
    private Dialog dialog;
    private int dem = 1;
    private int dung = 0;
    private int tg = 0;
    private TextView cauhoithu, thoigian, cauhoi;
    private Button btn1, btn2, btn3;
    private Boolean kq = false;
    private ArrayList<Cauhoi> dulieu = null;
    private int a = 0;
    private CountDownTimer countDownTimer;
    private RelativeLayout relativeLayout;
    private String[] mangdung = {"Bạn trả lời thật tuyệt!!!", "Hay quá bạn ơi, Hâm mộ bạn rồi đấy", "Xuất sắc, Bạn ở hành tinh nào vậy", "Ôi giỏi thế, chúc mừng chúc mừng", "Hơ đúng rồi à, lợi hại lợi hại"};
    private String[] mangsai = {"Ahihi Sai rồi", "Sai!!! Phật không độ bạn rồi", "Chúc bạn may mắn lần sau :)", "Hơ vậy cũng sai, chua rồi nhen", "Quá sai hehe,nhưng sai câu này ta bày câu khác"};
    private String[] hetgio = {"Hết giờ rồi nhé", "Tiếc quá, thời gian không cho phép", "Nhanh lên nào", "Tập trung tập trung", "Ui câu này suy nghĩ tới mai luôn"};
    private SoundPool mSoundPool;
    private int dung_sound;
    private int sai_sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choitrochoi);
        mSoundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        dung_sound = mSoundPool.load(getApplicationContext(), R.raw.dung, 1);
        sai_sound = mSoundPool.load(getApplicationContext(), R.raw.sai, 1);
        cauhoithu = findViewById(R.id.txtcauhoithu);
        thoigian = findViewById(R.id.txtthoigian);
        Intent intent = getIntent();
        namengchoi = intent.getStringExtra("tenngchoi");
        cauhoi = findViewById(R.id.txtcauhoi);
        btn1 = findViewById(R.id.btncautrl1);
        btn2 = findViewById(R.id.btncautrl2);
        btn3 = findViewById(R.id.btncautrl3);
        relativeLayout = findViewById(R.id.layoutplay);
        relativeLayout.setBackgroundResource(new thaydoigiaodien().thaydoigiaodien().getHinhanh());
        dulieu = new ArrayList<>();
        dulieu.add(new Cauhoi("Tí để ... cho Bo một cây kẹo", "dành", "giành", "rành", 0));
        dulieu.add(new Cauhoi("Anh Tuấn vừa mới thu phục được 1 con thú hoang ...", "dã", "giã", "giả", 1));
        dulieu.add(new Cauhoi("... Công việc cũng đã hoàn thành", "Rốt cuộc", "Rốt cục", "Rút cục", 2));
        dulieu.add(new Cauhoi("“Trong một buổi lể, Anh ấy đã tặng cho em 1 cành hoa”. Trong câu này có bao nhiêu từ viết sai chính tả:", "1", "2", "Không từ nào", 3));
        dulieu.add(new Cauhoi("Chia …. Là 1 đức tín tốt", "sẻ", "rẻ", "sẽ", 4));
        dulieu.add(new Cauhoi("... máy này thật là tốt", "Cỗ", "Cổ", "Cố", 5));
        dulieu.add(new Cauhoi("Anh Hòa mới đỗ tốt nghiệp, tương lai của anh ấy rất ...", "xán lạn", "sáng lạn", "sáng lạng", 6));
        dulieu.add(new Cauhoi("Tự coi mình là người ngoài cuộc, không dính líu đến mình có nghĩa là", "Bàng quan", "Bàng quang", "bàn quan", 7));
        dulieu.add(new Cauhoi("Đâu là từ có nghĩa là nghe thoáng nghe được, chưa thật rõ ràng, chưa chắc chắn", "phong thanh", "phong phanh", "phong khanh", 8));
        dulieu.add(new Cauhoi("Mọi người đang ... một cái bánh", "giành giật", "dành giật", "giành dật", 9));
        dulieu.add(new Cauhoi("Từ nào gần nghĩa với quan trọng", "Yếu điểm", "Điểm yếu", "Điểm mạnh", 10));
        dulieu.add(new Cauhoi("Điện máy trần anh đã ... với điện máy xanh", "sáp nhập", "sát nhập", "sác nhập", 11));
        dulieu.add(new Cauhoi("Vua nào áo vải, Đánh bại quân Thanh?", "Nguyễn Huệ", "Trần Hưng Đạo", "Lý Thường Kiệt", 12));
        dulieu.add(new Cauhoi("Ai viết Đại cáo bình Ngô?", "Nguyễn Trãi", " Trần Hưng Đạo", "Trần Thủ Độ", 13));
        dulieu.add(new Cauhoi("Đâu là từ nói về con gái yêu quý của cha mẹ", "Ái nữ", "Yêu nữ", "Nữ nhân", 14));
        dulieu.add(new Cauhoi("Người ăn xin đang mặc bộ đồ ...", "rách rưới", "dách dưới", "rách dưới", 15));
        dulieu.add(new Cauhoi("... tôi đều đi qua 1 con đường", "Hằng ngày", " hàng ngày", "hàng ngầy", 16));
        dulieu.add(new Cauhoi("Đâu là 1 từ có nghĩa", "chẩn đoán", " chuẩn đoán", "chuẫn đoán", 17));
        dulieu.add(new Cauhoi("Bố hay đưa tôi ... bảo tàng thành phố", "tham quan", "thăm quan", "tham quang", 18));
        dulieu.add(new Cauhoi("... của bộ phim thật là buồn", "Kết cục", "Kết cuộc", "Rốt cuộc", 19));
        dulieu.add(new Cauhoi("Đâu không phải 1 từ dùng để gọi mẹ", "Mả", "U", "Bu", 20));
        dulieu.add(new Cauhoi("1 khẩu ngữ nói về một ai đó giả vờ như đã biết rồi để người nghe phải giật mình nói ra điều đang giấu", "bắt nọn", "bắt lọn", "bắt lọng", 21));
        dulieu.add(new Cauhoi("Cách nói chuyện ồn ào là nghĩa của từ nào", "huyên thiên", "luyên thuyên", "huyên thuyên", 22));
        dulieu.add(new Cauhoi("Cầu thủ là người có ... chấn thương khá cao", "xác suất", "sác xuất", " xác xuất", 23));
        dulieu.add(new Cauhoi("Tớ vừa để dành được 1 ... kha khá", "khoản", "khoảng", "khản", 24));
        dulieu.add(new Cauhoi("Đâu là từ chỉ người đọc sách báo?", "độc giả", "đọc giả", "đọc giã", 25));
        dulieu.add(new Cauhoi("Ông Huy vừa về làng ta .....", "nhậm chức", "nhận chức", "nhậm chứt", 26));
        dulieu.add(new Cauhoi("Chờ thời điểm ..., chúng ta sẽ phản công", "chín muồi", "chín mùi", "chín tới", 27));
        dulieu.add(new Cauhoi("Bài văn rất là ...", "súc tích", "xúc tích", "xút tích", 28));
        dulieu.add(new Cauhoi("1 anh đang chạy xe ... trên đường", "bạt mạng", "bạc mạng", "bạt mạn", 29));
        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 30));
        dulieu.add(new Cauhoi("Từ nào có nghĩa là trống hoàn toàn, không có gì che chắn ở chung quanh", "Trống trải", "Trống chải", "Chống chải", 31));
        dulieu.add(new Cauhoi("Từ nào khác nghĩa so với các từ còn lại", "Đong đầy", "Cô đơn", "Trống vắng", 32));
        dulieu.add(new Cauhoi("Từ nào khác nghĩa so với các từ còn lại", "Nhân từ", "Yêu mến", "Thích thú", 33));
        dulieu.add(new Cauhoi("Cá lóc nướng là món ăn ... của miền Tây", "dân dã", "dâng dã", "dân rã", 34));
        dulieu.add(new Cauhoi("Ăn uống ... sẽ khiến sức khỏe tốt hơn", "Sạch sẽ", "Sạch xẽ", "Xạch xẽ", 35));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 36));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 37));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 38));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 39));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 40));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 41));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 42));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 43));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 44));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 45));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 46));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 47));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 48));
//        dulieu.add(new Cauhoi("Đội tuyển Việt Nam được thi đấu ... với các đội bóng ở Châu Âu", "cọ xát", "cọ sát", "cọ cự", 49));
        Showcauhoi();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn1.getText().toString() == dulieu.get(a).tld) {
                    kq = true;
                    dung += 1;
                }
                ShowDialog();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn2.getText().toString() == (dulieu.get(a).tld)) {
                    kq = true;
                    dung += 1;
                }
                ShowDialog();
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (btn3.getText().toString() == dulieu.get(a).tld) {
                    kq = true;
                    dung += 1;
                }
                ShowDialog();
            }
        });
    }

    private void ShowDialog() {
        countDownTimer.cancel();
        Random random = new Random();
        int ma = random.nextInt(mangdung.length);
        dulieu.remove(a);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        RelativeLayout linearLayout;
        TextView textView;
        Button button;
        button = dialog.findViewById(R.id.btn_dialog);
        textView = dialog.findViewById(R.id.dialog_txt);
        if (dem == 10) {
            button.setText("Kết thúc nhen");
        }
        if (tg == 0) {
            mSoundPool.play(sai_sound,1,1,1,0,1);
            dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialogsai);
            textView.setText(hetgio[ma]);
        } else {
            if (kq == true) {
                mSoundPool.play(dung_sound,1,1,1,0,1);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialogdung);
                textView.setText(mangdung[ma]);
            } else {
                mSoundPool.play(sai_sound,1,1,1,0,1);
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialogsai);
                textView.setText(mangsai[ma]);
            }
        }
        dialog.show();
        dialog.getWindow().setLayout(700, 700);


    }

    public void choitiep(View view) {
        dem += 1;
        dialog.dismiss();
        if (dem == 11) {
            Intent intent = new Intent(Play.this, Ketthuc.class);
            intent.putExtra("cautraloidung", dung);
            intent.putExtra("tenngchoi", namengchoi);
            startActivity(intent);
        } else {
            Showcauhoi();
            kq = false;
        }


    }

    public void Showcauhoi() {
        cauhoithu.setText(dem + "");
        dongho();
        relativeLayout.setBackgroundResource(new thaydoigiaodien().thaydoigiaodien().getHinhanh());
        Random random = new Random();
        a = random.nextInt(dulieu.size()) + 1;
        cauhoi.setText(dulieu.get(a).cauhoi);
        int b = random.nextInt(6) + 1;
        switch (b) {
            case 1:
                btn1.setText(dulieu.get(a).tld);
                btn2.setText(dulieu.get(a).tls1);
                btn3.setText(dulieu.get(a).tls2);
                break;
            case 2:
                btn1.setText(dulieu.get(a).tls1);
                btn2.setText(dulieu.get(a).tld);
                btn3.setText(dulieu.get(a).tls2);
                break;
            case 3:
                btn1.setText(dulieu.get(a).tls1);
                btn2.setText(dulieu.get(a).tls2);
                btn3.setText(dulieu.get(a).tld);
                break;
            case 4:
                btn1.setText(dulieu.get(a).tld);
                btn2.setText(dulieu.get(a).tls2);
                btn3.setText(dulieu.get(a).tls1);
                break;
            case 5:
                btn1.setText(dulieu.get(a).tls2);
                btn2.setText(dulieu.get(a).tls1);
                btn3.setText(dulieu.get(a).tld);
                break;
            case 6:
                btn1.setText(dulieu.get(a).tls2);
                btn2.setText(dulieu.get(a).tld);
                btn3.setText(dulieu.get(a).tls1);
                break;
        }


    }

    private void dongho() {
        tg = 10;
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tg -= 1;
                thoigian.setText(tg + "");
            }

            @Override
            public void onFinish() {
                ShowDialog();
            }
        }.start();

    }
}
