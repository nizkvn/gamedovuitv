package nizk.tvq.dovuitv;

public class Cauhoi {
    String cauhoi, tld, tls1, tls2;
    int id;

    public Cauhoi(String cauhoi, String tld, String tls1, String tls2, int id) {
        this.cauhoi = cauhoi;
        this.tld = tld;
        this.tls1 = tls1;
        this.tls2 = tls2;
        this.id = id;
    }

    public String getCauhoi() {
        return cauhoi;
    }

    public void setCauhoi(String cauhoi) {
        this.cauhoi = cauhoi;
    }

    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    public String getTls1() {
        return tls1;
    }

    public void setTls1(String tls1) {
        this.tls1 = tls1;
    }

    public String getTls2() {
        return tls2;
    }

    public void setTls2(String tls2) {
        this.tls2 = tls2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
