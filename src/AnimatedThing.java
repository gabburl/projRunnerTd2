import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private ImageView imgview ;
    private int state;

    private int index;
    private int durationf;
    private int indexmax;
    private int sizeofwX;
    private int sizeofwY;
    private int offset;

    public AnimatedThing(double x,double y, String spritesheet) {
        this.x = x;
        this.y = y;
        this.state = 0;
        this.index = 0;
        this.durationf = 16;
        this.indexmax = 6;
        this.sizeofwX = 75;
        this.sizeofwY = 100;
        this.offset = 100;
        this.imgview = new ImageView(new Image(spritesheet));

    }

    public ImageView getImgview() {
        return imgview;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getSizeofwX() {
        return sizeofwX;
    }

    public int getSizeofwY() {
        return sizeofwY;
    }

    public void update(long time) {

    }
}
