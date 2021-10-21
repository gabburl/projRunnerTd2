import javafx.scene.Parent;
import javafx.scene.Scene;

public class Gamescene extends Scene{
    private Camera cam1;
    private StaticThing bkgrndl;
    private StaticThing bkgrndr;
    private int nbofLives;

    public Gamescene(Parent parent, double v, double v1, boolean b, Camera cam1,StaticThing bckgl,StaticThing bckgr) {
        super(parent, v, v1, b);
        this.cam1 = cam1;
        this.bkgrndl =  bckgl;
        this.bkgrndr =  bckgr;
        this.nbofLives =3;
    }


}
