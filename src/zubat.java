import javafx.geometry.Rectangle2D;

public class zubat extends Foe{
    private int sens;

    public zubat(double x, double y, String spritesheet) {
        super(x, y, spritesheet);

        this.sizeofwX =54;
        this.sizeofwY=42;
        this.indexmax=2;
        this.sens =1;
    }


    public void update(long time){

        //dépacement vertical de la chauve-souris
        if (y<0){
            sens =1;

        }
        if (y > 300) {

            sens = -1;
        }
        y=y +sens*2;


        if (deltatime ==0){
            if (alive) { //animation en vie
                animframe = (animframe + 1) % indexmax;
                getImgview().setViewport(new Rectangle2D(animframe * sizeofwX, 0, sizeofwX, sizeofwY));
            }
            else {// animation de mort
                animframedeath=animframedeath+1;
                getImgview().setViewport(new Rectangle2D((animframedeath*sizeofwX),sizeofwY,sizeofwX, sizeofwY));
            }
        }
        deltatime= (deltatime+1)%durationframe;


    }
}
