import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import java.util.HashSet;

public class Input {

	private static HashSet<KeyCode> keys = new HashSet<KeyCode>();
	private static double speed = 0.01;

	public static HashSet<KeyCode> getKeys() {
		return keys;
	}

	public static boolean isBoosting() {
		return isKeyDown(KeyCode.W);
	}

	public static Position getBoostVector() {
		return new Position(0, -speed);
	}

	public static boolean isKeyDown(KeyCode c) {
		return keys.contains(c);
	}

	public static void bindInputs() {
		Scene scene = Director.getScene();
		scene.setOnMouseMoved(e -> {
			double x = e.getX();
			double y = e.getY();
			Director.setLook(new Position(x, y));
		});
		scene.setOnKeyPressed(e -> {
			keys.add(e.getCode());
		});
		scene.setOnKeyReleased(e -> {
			keys.remove(e.getCode());
		});
	}
}