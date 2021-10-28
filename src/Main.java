import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        Group root = new Group();


        Gamescene theScene = new Gamescene(root);
        theScene.getHero().setIndex(1);
        theScene.getCam1().setCamera(0,50);
        //theScene.render();
        primaryStage.setScene(theScene);
        primaryStage.show();


    }
    public static void main(String[] args) {
        launch(args);

    }
}
