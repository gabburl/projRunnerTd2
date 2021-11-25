import javafx.geometry.Rectangle2D;

public class slime extends Foe{


    public slime(double x, double y, String spritesheet) {
        super(x, y, spritesheet);

        this.sizeofwX =44;
        this.sizeofwY=46;
        this.indexmax=8;
    }


    public void update(long time){

        if (deltatime ==0){
            if (alive) {//animation en vie
                animframe = (animframe + 1) % indexmax;
                getImgview().setViewport(new Rectangle2D(animframe * sizeofwX, 0, sizeofwX, sizeofwY));
            }
            else {//animation de mort
                animframedeath=animframedeath+1;
                getImgview().setViewport(new Rectangle2D((animframedeath*sizeofwX),sizeofwY,sizeofwX, sizeofwY));
            }
        }
        deltatime= (deltatime+1)%durationframe;


    }
}
