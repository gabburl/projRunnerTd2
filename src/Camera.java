public class Camera {
    private double x;
    private final double y;
    private final double k;
    private final double f;
    private final double m;
    private double ax;
    private double vx;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
        this.k=5;
        this.f=3;
        this.m=1;
        this.ax=0;
        this.vx=0;
    }

    public double getX() {
        return x;
    }


    @Override
    public String toString() {
        return "x : " +x +  " y : " +y;
    }

    public void update(long time,double xHeros) {
        ax =  (k/m) *  (xHeros-x) + (f/m)*vx;
        double deltavx = ax * 0.016;
        vx = vx - deltavx;
        double deltax = vx *0.016;
        x= x - deltax;
    }



}
