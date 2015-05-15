import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashSet;
import javafx.scene.input.KeyCode;

public class Player extends GamePart implements Health {

	private int health;
	private ImageView sprite;
	private Position speed;
	private Position position;
	private Position lookPos;
	private boolean boosting;
	private double topspeed = 0.7;

	public Player() {
		health = 1;
		boosting = false;
		sprite = new ImageView(
			new Image("http://i.imgur.com/MrWeK4B.png")
		);
		sprite.setPreserveRatio(true);
		sprite.setFitHeight(100);
		sprite.setFitWidth(100);
		speed = new Position(0, 0);
		position = new Position(200, 200);
		Director.addMain(sprite);
	}

	public void setLookPos(Position p) {
		lookPos = p;
	}

	public Position getSpeed() {
		return speed;
	}

	public void setBoosting(boolean b) {
		this.boosting = b;
	}

	public int getHealth() {
		return health;
	}

	public void damage(int dmg) {
		health -= dmg;
	}

	public boolean isDead() {
		return health <= 0;
	}

	public void setPos(double x, double y) {
		sprite.setX(x);
		sprite.setY(y);
	}

	public void setPos(Position p) {
		sprite.setX(p.getX());
		sprite.setY(p.getY());
	}

	public void setSpeed(Position p) {
		this.speed = p;
	}

	public void translate(Position p) {
		Position p1 = new Position(sprite.getX(), sprite.getY());
		p1.add(p);
		this.setPos(p1);
	}

	public void update() {
		if (Input.isBoosting()) {
			speed.add(Input.getBoostVector().rotate(sprite.getRotate()));
		}
		if (speed.magnitude() > topspeed) {
			speed.normalize();
			speed.times(topspeed);
		}
		if (!Input.isBoosting() && speed.magnitude() > 0) {
			speed.times(0.99);
		}
		Position look = new Position(
			position.getX() + (sprite.getFitWidth() / 4),
			position.getY() + (sprite.getFitHeight() / 2));
		look.minus(lookPos);
		double x = look.getX();
		double y = look.getY();
		sprite.setRotate(-(Math.atan2(x, y) / (3.14159 * 2)) * 360);
		sprite.setFitHeight(Normalizer.normY(100));
		sprite.setFitWidth(Normalizer.normX(100));
		position.add(speed.copyTimes(Director.delta()));
		setPos(position);
	}
}