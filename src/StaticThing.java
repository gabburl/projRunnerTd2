import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double x;
    private double y;
    private final  ImageView imgvw;

    public StaticThing(double x,double y, String backgrd) {
        this.x = x;
        this.y = y;
        this.imgvw =new ImageView(new Image(backgrd));

    }

    public ImageView getImgvw() {
        return imgvw;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
