import javafx.geometry.Point2D;

public class Position {

	private double x;
	private double y;

	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Point2D asPoint() {
		return new Point2D(x, y);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public String toString() {
		return x + "   " + y;
	}

	public void setPosition(Position p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public int hashCode() {
		int result = 31;
		result += x * 31;
		result += y * 31;
		return result;
	}

	public void times(double factor) {
		x *= factor;
		y *= factor;
	}

	public Position copyTimes(double factor) {
		return new Position(x * factor, y * factor);
	}

	public void divide(double factor) {
		x /= factor;
		y /= factor;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (this == o) {
			return true;
		}
		if (!(o instanceof Position)) {
			return false;
		}
		Position p = (Position) o;
		return (x == p.getX() && y == p.getY());
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void moveBy(double x, double y) {
		this.x += x;
		this.y += y;
	}

	public void add(Position p) {
		this.x += p.getX();
		this.y += p.getY();
	}

	public Position rotate(double degrees) {
		double rads = (degrees / 360) * (3.14159 * 2);
		return new Position(
			x * Math.cos(rads) - y * Math.sin(rads),
			x * Math.sin(rads) + y * Math.cos(rads)
		);
	}

	public void normalize() {
		double magnitude = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		this.divide(magnitude);
	}

	public double magnitude() {
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public double minusProduct(Position p) {
		Position result = new Position(x, y);
		result.minus(p);
		return (
			Math.sqrt(Math.pow(result.getX(), 2) + Math.pow(result.getY(), 2)));
	}

	public void minus(Position p) {
		this.x -= p.getX();
		this.y -= p.getY();
	}
}