import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Gamescene extends Scene{

    private Camera cam1;
    private StaticThing bkgrndl;
    private StaticThing bkgrndr;
    private StaticThing listcoeurs;
    private int nbofLives;
    private Héros hero;
    private int p;
    private ArrayList<AnimatedThing> ATlist;

    public Gamescene(Pane pane, double v, double v1, boolean b) {
        super(pane, v, v1, b);
        this.cam1 = new Camera(0,100);
        bkgrndl = new StaticThing(0,0,"img/desert.png");
        pane.getChildren().add(bkgrndl.getImgvw());
        bkgrndr = new StaticThing(800,0,"img/desert.png");
        pane.getChildren().add(bkgrndr.getImgvw());
        this.nbofLives =5;
        listcoeurs = new StaticThing(2,2,"img/coeurs.png");
        pane.getChildren().add(listcoeurs.getImgvw());
        listcoeurs.getImgvw().setX(listcoeurs.getX());
        listcoeurs.getImgvw().setY(listcoeurs.getY());
        listcoeurs.getImgvw().setViewport(new Rectangle2D(0, 0, 24*nbofLives,20 ));
        this.hero = new Héros(20,250,"img/héroscrono.png");
        pane.getChildren().add(hero.getImgview());
        timer.start();
        this.p =0;
        this.ATlist = new ArrayList<AnimatedThing>();
        ATlist.add(new slime(400,300,"img/DS DSi - Dragon Quest Heroes Rocket Slime - Rocket.png",44,46,8));
        pane.getChildren().add(ATlist.get(0).getImgview());
    }

    public void update(long time){
        double offsetX = cam1.getX()%800;
        bkgrndl.getImgvw().setViewport(new Rectangle2D(offsetX,0 ,800,400));
        bkgrndl.getImgvw().setX(0);
        bkgrndl.getImgvw().setY(0);
        bkgrndr.getImgvw().setViewport(new Rectangle2D(0,0, offsetX, 400));
        bkgrndr.getImgvw().setX(800 - offsetX);
        bkgrndr.getImgvw().setY(0);

        hero.getImgview().setX(hero.getX()-cam1.getX());
        hero.getImgview().setY(hero.getY());

        for (AnimatedThing AT : ATlist){
            AT.getImgview().setX(AT.getX()-cam1.getX());
        }

        if (hero.getInvincibility()<0){
            for (AnimatedThing AT : ATlist){
                if (AT.testHitbox(hero.getX(), hero.getY(), hero.getSizeofwX(), hero.getSizeofwY())){
                    switch (AT.getId()){
                        case "foe":
                            removeLife();
                            hero.setInvincibility(50);
                            Foe foe = (Foe)AT;
                            foe.setAlive(false);
                            break;
                        case "speedboost":
                            hero.setDeltax(hero.getDeltax()+0.5);
                            hero.setInvincibility(50);

                    }



                }
            }
        }
        else {
            hero.setInvincibility(hero.getInvincibility()-1);

        }



    }

    public void removeLife(){
        nbofLives = nbofLives -1;
        listcoeurs.getImgvw().setViewport(new Rectangle2D(0, 0, 24*nbofLives,20 ));


    }

    public Héros getHero() {
        return hero;
    }

    AnimationTimer timer = new AnimationTimer()
        {public void handle(long time) {
            hero.update(time);
            for (AnimatedThing AT : ATlist){
                AT.update(time);
            }
            cam1.update(time,hero.getX());
            update(time);
        }
    };




}
