public class Camera {
    private double x;
    private double y;

    public Camera(int x, int y) {
        this.x = x;
        this.y = y;

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
    public void update(long time) {

    }


}
