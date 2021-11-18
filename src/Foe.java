import javafx.geometry.Rectangle2D;


public class Foe extends AnimatedThing {


    public Foe(double x, double y, String spritesheet,int sizeofwX,int sizeofwY) {
        super(x, y, spritesheet, sizeofwX, sizeofwY);

    }

    public boolean testHitbox(Rectangle2D hitboxhero){
        return hitbox.intersects(hitboxhero);
    }
}
