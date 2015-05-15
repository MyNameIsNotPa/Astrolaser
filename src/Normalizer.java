public class Normalizer {

	public static Position norm(Position c) {
		return new Position(
			normX(c.getX()),
			normY(c.getY()));
	}

	public static Double[] normPoint(int x, int y) {
		return normPoint(x * 1.0, y * 1.0);
	}

	public static Double[] normPoint(double x, double y) {
		Double[] point = new Double[2];
		point[0] = normX(x);
		point[1] = normY(y);
		return point;
	}

	public static Double normX(int i) {
		return normX(i * 1.0);
	}

	public static Double normY(int i) {
		return normY(i * 1.0);
	}

	public static Double normX(Double d) {
		double xLimit = Director.getStage().getWidth();
		return (d / 1000) * xLimit;
	}

	public static Double normY(Double d) {
		double yLimit = Director.getStage().getHeight();
		return (d / 1000) * yLimit;
	}
}