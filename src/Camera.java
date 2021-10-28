public class Camera {
    private double x;
    private double y;
    private double k;
    private double f;
    private double m;
    private double ax;
    private double vx;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;
        this.k=1;
        this.f=1.5;
        this.m=1;
        this.ax=0;
        this.vx=0;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "x : " +x +  " y : " +y;
    }

    public void update(long time,double xHeros) {
        double ax =  (k/m) *  (xHeros-x) + (f/m)*vx;
        double deltavx = ax * 0.016;
        vx = vx - deltavx;
        double deltax = vx *0.016;
        x= x - deltax;
    }

    public void setCamera(int x,int y){
        this.x=x;
        this.y = y;
    }

}
