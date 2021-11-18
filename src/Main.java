import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.*;



public class Main  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        Gamescene theScene = new Gamescene(pane,800,400,true);

        //primaryStage.setWidth(800);
        //primaryStage.setHeight(400);
        primaryStage.setScene(theScene);
        theScene.setOnKeyPressed( (event)->{
            System.out.println("Jump");
            theScene.getHero().jump();
        });
        primaryStage.show();




    }
    public static void main(String[] args) {
        launch(args);

    }
}
