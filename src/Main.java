import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.Node;
import javafx.scene.paint.ImagePattern;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    private static Pane root;
    private static Pane menu;
    private static Pane guiLayer;
    private static Pane mainLayer;
    private static Scene scene;
    private static Timeline timeline;
    private static Rectangle2D primaryScreenBounds;

    //Useful getter methods for main display

    public static void addGui(Node o) {
        guiLayer.getChildren().add(o);
    }

    public static double screenHeight() {
        return primaryScreenBounds.getHeight();
    }

    public static double screenWidth() {
        return primaryScreenBounds.getWidth();
    }

    public static void removeGui(Node o) {
        guiLayer.getChildren().remove(o);
    }

    public static void removeMain(Node o) {
        mainLayer.getChildren().remove(o);
    }

    public static void addMain(Node o) {
        mainLayer.getChildren().add(o);
    }

    @Override public void start(Stage stage) throws Exception {

        stage.setFullScreen(false);

        primaryScreenBounds = Screen.getPrimary().getBounds();

        root = new Pane();
        root.setPrefSize(Main.screenWidth(), Main.screenHeight());
        guiLayer = new Pane();
        guiLayer.setPrefSize(Main.screenWidth(), Main.screenHeight());
        mainLayer = new Pane();
        mainLayer.setPrefSize(Main.screenWidth(), Main.screenHeight());
        root.getChildren().addAll(mainLayer, guiLayer);
        mainLayer.setStyle("-fx-background-color: black;");

        scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Ship Game");
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        stage.show();

        Director.setStage(stage);
        Director.setScene(scene);
        Director.addPlayer();
        Input.bindInputs();

        timeline = new Timeline(new KeyFrame(
            Duration.millis(5), Director::update));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
}