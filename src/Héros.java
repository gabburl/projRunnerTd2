import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Héros extends AnimatedThing {

    private double ay;
    private double vy;
    private double g;


    public Héros(double x,double y ,String spritesheet) {
        super(x,y, spritesheet);
        this.g = 3;
    }

    @Override
    public void update(long time) {
        super.update(time);

        x= x + 2;


        if (y<175) {
            ay = ay - g;
            double deltavy = ay * 0.016;
            vy = vy - deltavy;
            double deltay = vy * 0.016;
            y = y + deltay;
            if(vy > 0){
                index = 3;
            }
        }
        if (y>175){
            index =1;
            y=175;
            vy=0;
        }


        if (deltatime ==0){
            switch(index){
                case 0 :
                    getImgview().setViewport(new Rectangle2D(10,0,getSizeofwX(), getSizeofwY()));
                    break;
                case 1 :
                    switch (runframe){
                        case 0 :
                            getImgview().setViewport(new Rectangle2D(15,0,getSizeofwX(), getSizeofwY()));
                            break;
                        case 1 :
                            getImgview().setViewport(new Rectangle2D(95,0,getSizeofwX(), getSizeofwY()));
                            break;
                        case 2 :
                            getImgview().setViewport(new Rectangle2D(175,0,getSizeofwX(), getSizeofwY()));
                            break;
                        case 3 :
                            getImgview().setViewport(new Rectangle2D(265,0,getSizeofwX(), getSizeofwY()));
                            break;
                        case 4 :
                            getImgview().setViewport(new Rectangle2D(340,0,getSizeofwX(), getSizeofwY()));
                            break;
                        case 5 :
                            getImgview().setViewport(new Rectangle2D(425,0,getSizeofwX(), getSizeofwY()));
                            break;
                    }
                    runframe = (runframe +1)%6;
                    break;
                case 2 :
                    getImgview().setViewport(new Rectangle2D(13,161,getSizeofwX(), getSizeofwY()));
                    break;
                case 3 :
                    getImgview().setViewport(new Rectangle2D(93,161,getSizeofwX(), getSizeofwY()));
                    break;
            }
        }
        deltatime= (deltatime+1)%durationframe;
    }

    public void jump(){
        y = y-1;
        ay =175;
        index =2;
    }

}
