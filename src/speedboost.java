import javafx.geometry.Rectangle2D;

public class speedboost extends AnimatedThing{
    public speedboost(double x, double y, String spritesheet, int sizeofwX, int sizeofwY, int indexmax) {
        super(x, y, spritesheet);
        this.id = "speedboost";
        this.sizeofwX =26;
        this.sizeofwY=27;
        this.indexmax=2;
    }

    @Override
    public void update(long time){
        if (deltatime ==0){
            getImgview().setViewport(new Rectangle2D(sizeofwX*animframe,0,sizeofwX, sizeofwY));
            animframe = (animframe+1)%indexmax;
        }

        deltatime= (deltatime+1)%(durationframe*2);
    }

}
