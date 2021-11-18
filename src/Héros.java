import javafx.geometry.Rectangle2D;

public class Héros extends AnimatedThing {

    private double ay;
    private double deltax;
    private double vy;
    private double g;
    private int k;
    private long invincibility;
    private int nbjump ;
    private int compteur;


    public Héros(double x,double y ,String spritesheet) {
        super(x,y, spritesheet);
        this.g = 10;
        this.k=0;
        this.deltax=3;
        this.invincibility =-1;
        this.id = "hero";
        this.sizeofwX =84;
        this.sizeofwY=111;
        this.indexmax=6;
        this.index =1;
        this.nbjump=0;
        this.compteur=0;
    }

    public long getInvincibility() {
        return invincibility;
    }

    public void setInvincibility(long invincibility) {
        this.invincibility = invincibility;
    }

    public double getDeltax() {
        return deltax;
    }

    public void setDeltax(double deltax) {
        this.deltax = deltax;
    }



    public void update(long time) {

        x= x + deltax;


        if (y<250) {
            ay = ay - g;
            double deltavy = ay * 0.016;
            vy = vy - deltavy;
            double deltay = vy * 0.016;
            y = y + deltay;
            if(vy > 0){
                index = 3;
            }
        }
        if (y>250){
            index =1;
            y=250;
            vy=0;
            nbjump =0;
        }
         if (invincibility<0){
             k=0;
         }
         else{
             k=3;
         }


        if (deltatime ==0){
            switch(index){
                case 0 :
                    getImgview().setViewport(new Rectangle2D(2*sizeofwX,sizeofwY+k*sizeofwY,sizeofwX, sizeofwY));
                    break;
                case 1 :
                    getImgview().setViewport(new Rectangle2D(animframe * sizeofwX, k*sizeofwY, sizeofwX, sizeofwY));
                    animframe = (animframe +1)%indexmax;
                    if(deltax>4){
                        index=4;
                    }
                    break;
                case 2 :
                    getImgview().setViewport(new Rectangle2D(3*sizeofwX,sizeofwY + sizeofwY*k,sizeofwX, sizeofwY));
                    break;
                case 3 :
                    getImgview().setViewport(new Rectangle2D(4*sizeofwX,sizeofwY + sizeofwY*k,sizeofwX, sizeofwY));
                    break;
                case 4 :
                    getImgview().setViewport(new Rectangle2D(animframe * sizeofwX, 2*sizeofwY +k*sizeofwY, sizeofwX, sizeofwY));
                    animframe = (animframe +1)%indexmax;
                    if(deltax<=4){
                        index=1;
                    }
                    break;
                case 5:
                    getImgview().setViewport(new Rectangle2D(0,sizeofwY + sizeofwY*k,sizeofwX, sizeofwY));
                    compteur = compteur +1;
                    if (compteur%2 ==1){
                        index=2;
                    }
                    break;

            }
        }
        deltatime= (deltatime+1)%durationframe;
    }

    public void jump(){
        if (nbjump<3){
            y = y-1;
            ay =200;
            vy = -150;
            index =2;
            nbjump = nbjump +1;

            index =5;
        }

    }



}
