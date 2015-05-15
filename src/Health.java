/**
 * This interface defines if a GamePart has health.
 * GameParts with health can be hurt and 'die'.
 * @author Patrick Sewell
 * @version 1.0
 */
public interface Health {

	public int getHealth();
	public void damage(int dmg);
	public boolean isDead();
}