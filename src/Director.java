import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import javafx.scene.Node;
import javafx.scene.Scene;

public class Director {

	private static ArrayList<GamePart> parts
		= new ArrayList<GamePart>();
	private static Stage stage;
	private static Player player;
	private static Scene scene;
	private static long millis = System.currentTimeMillis();
	private static int delta;

	public static void setLook(Position p) {
		player.setLookPos(p);
	}

	public static void setPlayerSpeed(Position p) {
		player.setSpeed(p);
	}

	public static Position getPlayerSpeed() {
		return player.getSpeed();
	}

	public static void setPlayerBoosting(boolean b) {
		player.setBoosting(b);
	}

	public static void addPlayer() {
		player = new Player();
		parts.add(player);
	}

	public static void setScene(Scene scenex) {
		scene = scenex;
	}

	public static void setStage(Stage stagex) {
		stage = stagex;
	}

	public static Scene getScene() {
		return scene;
	}

	public static Stage getStage() {
		return stage;
	}

	public static int delta() {
		return (int) (System.currentTimeMillis() - millis);
	}

	public static void update(ActionEvent e) {
		for (GamePart p : parts) {
			p.update();
		}
		millis = System.currentTimeMillis();
	}

	public static void addGui(Node o) {
		Main.addGui(o);
	}

	public static void removeGui(Node o) {
		Main.removeGui(o);
	}

	public static void removeMain(Node o) {
		Main.removeMain(o);
	}

	public static void addMain(Node o) {
		Main.addMain(o);
	}
}