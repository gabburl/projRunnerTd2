import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    protected ImageView imgview;

    protected int index; // 0-> immobile 1-> en train de courir 2->saut 3->chute
    protected int durationframe;
    protected int animframe;
    protected int indexmax;
    protected int sizeofwX;
    protected int sizeofwY;
    protected int offset;
    protected int deltatime;
    protected String id;

    protected Rectangle2D hitbox;

    public AnimatedThing(double x, double y, String spritesheet) {
        this.x = x;
        this.y = y;
        this.animframe=0;
        this.index = 0;
        this.durationframe = 5;
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


    public String getId() {
        return id;
    }

    abstract void update(long time);

    public boolean testHitbox(double xhero,double yhero,int sizeX, int sizeY){
        return hitbox.intersects(new Rectangle2D(xhero,yhero,sizeX,sizeY));
    }


}
