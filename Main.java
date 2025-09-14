class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so khong đc bang 0!");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return gcd(b, a % b);
    }

    public void rutGon() {
        int ucln = gcd(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
        if (mauSo < 0) {
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    public boolean laToiGian() {
        return gcd(tuSo, mauSo) == 1;
    }

    public PhanSo cong(PhanSo ps) {
        int ts = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
        int ms = this.mauSo * ps.mauSo;
        PhanSo kq = new PhanSo(ts, ms);
        kq.rutGon();
        return kq;
    }

    public PhanSo tru(PhanSo ps) {
        int ts = this.tuSo * ps.mauSo - ps.tuSo * this.mauSo;
        int ms = this.mauSo * ps.mauSo;
        PhanSo kq = new PhanSo(ts, ms);
        kq.rutGon();
        return kq;
    }

    public PhanSo nhan(PhanSo ps) {
        int ts = this.tuSo * ps.tuSo;
        int ms = this.mauSo * ps.mauSo;
        PhanSo kq = new PhanSo(ts, ms);
        kq.rutGon();
        return kq;
    }

    public PhanSo chia(PhanSo ps) {
        if (ps.tuSo == 0) {
            throw new ArithmeticException("Khong the chia cho 0!");
        }
        int ts = this.tuSo * ps.mauSo;
        int ms = this.mauSo * ps.tuSo;
        PhanSo kq = new PhanSo(ts, ms);
        kq.rutGon();
        return kq;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}

public class Main {
    public static void main(String[] args) {
        PhanSo sp1 = new PhanSo(1, 2);
        PhanSo sp2 = new PhanSo(3, 4);

        System.out.println("Phan so 1: " + sp1);
        System.out.println("Phan so 2: " + sp2);

        PhanSo spTong = sp1.cong(sp2);
        System.out.println("Tong: " + spTong);
        System.out.println("Hieu: " + sp1.tru(sp2));
        System.out.println("TTich: " + sp1.nhan(sp2));
        System.out.println("Thuong: " + sp1.chia(sp2));

        System.out.println("sp1 co toi gian khong? " + sp1.laToiGian());

        PhanSo ps3 = new PhanSo(6, 8);
        System.out.println("ps3 ban dau: " + ps3);
        ps3.rutGon();
        System.out.println("ps3 sau khi rut gons: " + ps3);
    }
}
