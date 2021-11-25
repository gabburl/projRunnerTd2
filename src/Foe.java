abstract public class Foe extends AnimatedThing {
    protected boolean alive;
    protected int animframedeath;


    public Foe(double x, double y, String spritesheet) {
        super(x, y, spritesheet);
        this.alive=true;
        this.id = "foe";
        this.animframedeath=0;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }
}
