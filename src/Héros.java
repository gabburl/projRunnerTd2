import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Héros {
    private double x;
    private double y;
    private static ImageView sprite;
    private static Image spritesheet;

    public Héros(int x, int y,String filename) throws Exception {
        if (x<0 || y <0 ){
            throw new Exception("");
        }

        this.x = x;
        this.y = y;
        spritesheet = new Image(filename);
        sprite = new ImageView();


    }
}
