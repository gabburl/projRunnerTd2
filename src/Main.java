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
        Image spriteSheet = new Image("C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\heros.png");
        ImageView sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));
        sprite.setX(200);
        sprite.setY(300);



        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        Camera cam1 = new Camera(0,0);
        StaticThing leftbkgd = new StaticThing(0,0,"C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\desert.png");
        StaticThing rightbkgd = new StaticThing(800,0,"C:\\Users\\gabri\\IdeaProjects\\projRunnerTd\\img\\desert.png");

        Gamescene theScene = new Gamescene(pane, 600, 400,true,cam1,leftbkgd,rightbkgd);
        rightbkgd.getImgvw().setX(rightbkgd.getX());

        primaryStage.setScene(theScene);
        primaryStage.show();
        root.getChildren().add(leftbkgd.getImgvw());
        root.getChildren().add(rightbkgd.getImgvw());
        root.getChildren().add(sprite);

    }
    public static void main(String[] args) {
        launch(args);

    }
}
