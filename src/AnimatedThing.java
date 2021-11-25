import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class AnimatedThing {
    protected double x;
    protected double y;
    protected ImageView imgview;

    protected int index; //défini l'état de l'objet animé
    protected int durationframe;
    protected int animframe;
    protected int indexmax;
    protected int sizeofwX;
    protected int sizeofwY;
    protected int offset;
    protected int deltatime;
    protected String id;


    public AnimatedThing(double x, double y, String spritesheet) {
        this.x = x;
        this.y = y;
        this.animframe=0;
        this.index = 0;
        this.durationframe = 5;
        this.offset = 100;

        this.imgview = new ImageView(new Image(spritesheet));
        getImgview().setViewport(new Rectangle2D(0, 0, getSizeofwX(), getSizeofwY()));
        getImgview().setX(getX());
        getImgview().setY(getY());

    }

    //tous les getter utiles
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

    //fonction qui teste la collision de l'objet animé avec une autre hitbox(celle du héros en générale)
    public boolean testHitbox(double xhero,double yhero,int sizeX, int sizeY){
        Rectangle2D hitbox = new Rectangle2D(x,y,sizeofwX,sizeofwY);
        return hitbox.intersects(new Rectangle2D(xhero,yhero,sizeX,sizeY));
    }


}
