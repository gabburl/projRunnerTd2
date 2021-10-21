import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    private double x;
    private double y;
    private Image img;
    private ImageView imgview ;
    private int state;

    private int index;
    private int durationf;
    private int indexmax;
    private int sizeofw;
    private int offset;

    public AnimatedThing(double x, double y, int state, int index, int durationf, int indexmax, int sizeofw, int offset, String spritesheet) {
        this.x = x;
        this.y = y;
        this.state = state;
        this.index = index;
        this.durationf = durationf;
        this.indexmax = indexmax;
        this.sizeofw = sizeofw;
        this.offset = offset;
        this.img = new Image(spritesheet);
        this.imgview = new ImageView(img);

    }

    public ImageView getImgview() {
        return imgview;
    }
}
