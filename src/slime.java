import javafx.geometry.Rectangle2D;

public class slime extends Foe{
    private int animframedeath;

    public slime(double x, double y, String spritesheet, int sizeofwX, int sizeofwY, int indexmax) {
        super(x, y, spritesheet);
        this.animframedeath=0;
        this.sizeofwX =44;
        this.sizeofwY=46;
        this.indexmax=8;
    }


    public void update(long time){

        if (deltatime ==0){
            if (alive) {
                animframe = (animframe + 1) % indexmax;
                getImgview().setViewport(new Rectangle2D(0 + animframe * sizeofwX, 0, sizeofwX, sizeofwY));
            }
            else {
                animframedeath=animframedeath+1;
                getImgview().setViewport(new Rectangle2D((animframedeath*sizeofwX),sizeofwY,sizeofwX, sizeofwY));
            }
        }
        deltatime= (deltatime+1)%durationframe;


    }
}
