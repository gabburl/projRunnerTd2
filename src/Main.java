import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main  extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        Gamescene theScene = new Gamescene(pane,800,400,true);


        primaryStage.setScene(theScene);

        theScene.setOnKeyPressed( (event)->{
            theScene.getHero().jump();
        });
        primaryStage.show();




    }
    public static void main(String[] args) {
        launch(args);

    }
}
