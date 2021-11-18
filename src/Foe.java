import javafx.geometry.Rectangle2D;


abstract public class Foe extends AnimatedThing {
    protected boolean alive;

    public Foe(double x, double y, String spritesheet) {
        super(x, y, spritesheet);
        this.alive=true;
        this.id = "foe";
    }


    public void setAlive(boolean alive) {
        this.alive = alive;
    }


}
