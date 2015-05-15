import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Polygon;
import javafx.scene.image.Image;
import java.util.Arrays;

public class WorldGenerator {

	@SuppressWarnings("unchecked")
    public static <Double> Double[] concatAll(Double[] first, Double[]... rest) {
        int totalLength = first.length;
        for (Double[] array : rest) {
            totalLength += array.length;
        }
        Double[] result = Arrays.copyOf(first, totalLength);
        int offset = first.length;
        for (Double[] array : rest) {
            System.arraycopy(array, 0, result, offset, array.length);
            offset += array.length;
        }
        return result;
    }

	public static void generateWorld() {
		Polygon polygon = new Polygon();
	    polygon.getPoints().addAll(concatAll(
	        Normalizer.normPoint(0, 200),
	        Normalizer.normPoint(200, 400),
	        Normalizer.normPoint(300, 200),
	        Normalizer.normPoint(100, 100)
	    	));
	    polygon.setFill(new ImagePattern(
	        new Image("http://superwalrusland.com/ohr/issue26/pa/stone4_b.jpg"),
	        0, 0,
	        Normalizer.normX(100), Normalizer.normY(100),
	        false));
	    Director.addMain(polygon);
	}
}