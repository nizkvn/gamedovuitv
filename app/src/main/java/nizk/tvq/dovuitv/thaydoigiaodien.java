package nizk.tvq.dovuitv;

import java.util.ArrayList;
import java.util.Random;

public class thaydoigiaodien {
    ArrayList<Giaodien> Arr_giaodien;
    ArrayList<giaodienplay> Arr_gdplay;

    public Giaodien thaydoigiaodien() {
        Arr_giaodien = new ArrayList<>();
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh1));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh2));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh3));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh4));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh5));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh6));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh7));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh8));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh9));
        Arr_giaodien.add(new Giaodien(1, R.drawable.hinh10));
        Random random = new Random();
        int a = random.nextInt(Arr_giaodien.size());
        return Arr_giaodien.get(a);
    }

    public giaodienplay thaydoinutplay() {
        Arr_gdplay = new ArrayList<>();
        Arr_gdplay.add(new giaodienplay(R.drawable.play_do));
        Arr_gdplay.add(new giaodienplay(R.drawable.play_trang));
        Arr_gdplay.add(new giaodienplay(R.drawable.play_xanh));
        Arr_gdplay.add(new giaodienplay(R.drawable.play_vang));
        Arr_gdplay.add(new giaodienplay(R.drawable.play_xanhla));
        Random random = new Random();
        int a = random.nextInt(Arr_gdplay.size());
        return Arr_gdplay.get(a);
    }
}
