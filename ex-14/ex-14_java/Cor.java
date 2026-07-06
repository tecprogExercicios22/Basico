public class Cor {
    public int r;
    public int g;
    public int b;
    public int a;

    public Cor(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public Cor(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public static Cor Black() {
        return new Cor(0, 0, 0);
    }

    public static Cor Yellow() {
        return new Cor(255, 255, 0);
    }

    public static Cor Cyan() {
        return new Cor(0, 255, 255);
    }
}
