import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    protected ImageView imgview;

    protected int index; // 0-> immobile 1-> en train de courir 2->saut 3->chute
    protected int durationframe;
    protected int runframe;
    protected int indexmax;
    protected int sizeofwX;
    protected int sizeofwY;
    protected int offset;
    protected int deltatime;

    protected Rectangle2D hitbox;

    public AnimatedThing(double x, double y, String spritesheet,int sizeofwX,int sizeofwY) {
        this.x = x;
        this.y = y;
        this.index = 0;
        this.durationframe = 5;
        this.indexmax = 5;
        this.sizeofwX = sizeofwX;
        this.sizeofwY = sizeofwY;
        this.offset = 100;
        this.hitbox = new Rectangle2D(x,y,sizeofwX,sizeofwY);
        this.imgview = new ImageView(new Image(spritesheet));
        getImgview().setViewport(new Rectangle2D(0, 0, getSizeofwX(), getSizeofwY()));
        getImgview().setX(getX());
        getImgview().setY(getY());

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

    public void setIndex(int index) {
        this.index = index;
    }

    public void update(long time) {
    }

    public Rectangle2D getHitbox() {
        return hitbox;
    }
}
