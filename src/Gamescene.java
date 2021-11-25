import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Gamescene extends Scene{

    private final Camera cam1;
    private final StaticThing bkgrndl;
    private final StaticThing bkgrndr;
    private final StaticThing gameover;
    private final StaticThing listcoeurs;
    private final Hero hero;
    private final ArrayList<AnimatedThing> ATlist;


    //constructeur de la classe
    public Gamescene(Pane pane, double v, double v1, boolean b) {
        super(pane, v, v1, b);
        //ajout de la caméra aux coordonées initiales choisies
        this.cam1 = new Camera(0,100);

        //ajout du background
        bkgrndl = new StaticThing(0,0,"img/desert.png");
        pane.getChildren().add(bkgrndl.getImgvw());
        bkgrndr = new StaticThing(800,0,"img/desert.png");
        pane.getChildren().add(bkgrndr.getImgvw());



        // ajout du perso
        this.hero = new Hero(20,250,"img/héroscrono.png");
        pane.getChildren().add(hero.getImgview());

        //ajout des vies du perso

        listcoeurs = new StaticThing(2,2,"img/coeurs.png");
        pane.getChildren().add(listcoeurs.getImgvw());
        listcoeurs.getImgvw().setX(listcoeurs.getX());
        listcoeurs.getImgvw().setY(listcoeurs.getY());
        listcoeurs.getImgvw().setViewport(new Rectangle2D(0, 0, 24*hero.getNbofLives(),20 ));

        timer.start();

        //ajout des ennemis/items
        this.ATlist = new ArrayList<>();
        ATlist.add(new zubat(400  ,250,"img/bat.png"));
        pane.getChildren().add(ATlist.get(0).getImgview());
        for (int q =1;q<30;q++){
            double r = Math.random();
            if (r<0.65) {
                ATlist.add(new slime(400 * q + Math.random() * 400, 300, "img/DS DSi - Dragon Quest Heroes Rocket Slime - Rocket.png"));
                pane.getChildren().add(ATlist.get(q).getImgview());
            }
            else if (r<0.90){
                ATlist.add(new speedboost(400*q + Math.random()*400 ,300,"img/speedboost.png"));
                pane.getChildren().add(ATlist.get(q).getImgview());
            }
            else{
                ATlist.add(new zubat(400*q + Math.random()*400 ,200,"img/bat.png"));
                pane.getChildren().add(ATlist.get(q).getImgview());
            }
        }

        gameover = new StaticThing(0,0,"img/gameover.png");
        pane.getChildren().add(gameover.getImgvw());
        gameover.getImgvw().setViewport(new Rectangle2D(0,0 ,1,1));
    }

    public void update(long time){
        //affichage du background qui défile continuellement
        double offsetX = cam1.getX()%800;
        //affichage de la partie gauche du background
        bkgrndl.getImgvw().setViewport(new Rectangle2D(offsetX,0 ,800,400));
        bkgrndl.getImgvw().setX(0);
        bkgrndl.getImgvw().setY(0);
        //affichage de la partie droite du background
        bkgrndr.getImgvw().setViewport(new Rectangle2D(0,0, offsetX, 400));
        bkgrndr.getImgvw().setX(800 - offsetX);
        bkgrndr.getImgvw().setY(0);

        //affichage du perso dans le champ de la caméra
        hero.getImgview().setX(hero.getX()-cam1.getX());
        hero.getImgview().setY(hero.getY());

        //affichage des ennemis/items dans le champ de la caméra
        for (AnimatedThing AT : ATlist){
            AT.getImgview().setX(AT.getX()-cam1.getX());
            AT.getImgview().setY(AT.getY());
        }

        //interraction avec les ennemis/items
        if (hero.getInvincibility()<0){//si le héros n'est pas invincible
            for (AnimatedThing AT : ATlist){
                if (AT.testHitbox(hero.getX(), hero.getY(), hero.getSizeofwX(), hero.getSizeofwY())){
                    switch (AT.getId()) {
                        case "foe" -> { //enlève une vie, ralentit le héros et active l'invincibilté si le héros percute un ennemi
                            Foe foe = (Foe) AT;
                            if (foe.isAlive()) {
                                removeLife();
                                hero.setInvincibility(50);
                                foe.setAlive(false); //l'ennemi n'est plus en vie : active soon animation de mort
                                if (hero.getDeltax() > 2) {
                                    hero.setDeltax(hero.getDeltax() - 1);
                                }
                            }
                        }
                        case "speedboost" -> { // accélère le héros + invincibilité
                            hero.setDeltax(hero.getDeltax() + 1);
                            hero.setInvincibility(50);
                        }
                    }
                }
            }
        }
        else { //si le héros est invincible, on diminue son temps d'invincibilité restant
            hero.setInvincibility(hero.getInvincibility()-1);

        }
        if (hero.getY()>400){//affiche l'écran GameOver à la fin de l'animation de mort du héros
            gameover.getImgvw().setViewport(new Rectangle2D(0,0 ,800,400));
        }



    }

    //fonction qui gère la perte des vies, modifie l'affichage des vies en conséquence, et déclenche l'animation de mort
    public void removeLife(){

        if(hero.getNbofLives()>0){
            hero.setNbofLives(hero.getNbofLives() -1);
            listcoeurs.getImgvw().setViewport(new Rectangle2D(0, 0, 24*hero.getNbofLives(),20 ));
        }
        if (hero.getNbofLives()==0){
            hero.setDeltax(0);
            hero.setIndex(6);


        }



    }

    public Hero getHero() {
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
