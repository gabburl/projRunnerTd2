import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.util.ArrayList;

public class Gamescene extends Scene{

    private Camera cam1;
    private StaticThing bkgrndl;
    private StaticThing bkgrndr;
    private StaticThing listcoeurs;
    private int nbofLives;
    private Héros hero;
    private int p;

    public Gamescene(Group root) {
        super(root);
        this.cam1 = new Camera(0,100);
        bkgrndl = new StaticThing(0,0,"C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\desert.png");
        root.getChildren().add(bkgrndl.getImgvw());
        bkgrndr = new StaticThing(800,0,"C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\desert.png");
        root.getChildren().add(bkgrndr.getImgvw());
        this.nbofLives =3;
        listcoeurs = new StaticThing(2,2,"C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\coeurs.png");
        root.getChildren().add(listcoeurs.getImgvw());
        listcoeurs.getImgvw().setX(listcoeurs.getX());
        listcoeurs.getImgvw().setY(listcoeurs.getY());
        listcoeurs.getImgvw().setViewport(new Rectangle2D(0, 0, 24*nbofLives,20 ));
        this.hero = new Héros(20,175,"C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\heros.png");
        root.getChildren().add(hero.getImgview());
        timer.start();
        this.p =0;
    }

    public void render(long time){
        double offsetX = cam1.getX()%800;
        double offsetY = cam1.getY()%800;
        bkgrndl.getImgvw().setViewport(new Rectangle2D(offsetX,offsetY ,600,300));
        bkgrndl.getImgvw().setX(0);
        bkgrndl.getImgvw().setY(0);
        if  ( offsetX > 200) {
            bkgrndr.getImgvw().setViewport(new Rectangle2D(0, offsetY, offsetX-200, 300));
            bkgrndr.getImgvw().setX(800 - offsetX);
        }
        else {
            bkgrndr.getImgvw().setViewport(new Rectangle2D(0, 0, 1, 1));
            bkgrndr.getImgvw().setX(0);
        }
        bkgrndr.getImgvw().setY(0);

        hero.getImgview().setX(hero.getX()-cam1.getX());
        hero.getImgview().setY(hero.getY());


    }

    public void removeLife(){
        nbofLives = nbofLives -1;
        listcoeurs.getImgvw().setViewport(new Rectangle2D(0, 0, 24*nbofLives,20 ));


    }

    /*
    this.setOnMouseClicked( (event)->{
        System.out.println("Jump");
            hero.jump();
            });

     */


    AnimationTimer timer = new AnimationTimer()
        {public void handle(long time) {
            hero.update(time);
            cam1.update(time,getHero().getX());
            render(time);
            p=p+1;


        }
    };

    public Héros getHero() {
        return hero;
    }

    public Camera getCam1() {
        return cam1;
    }
}
