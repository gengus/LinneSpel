package LinneSpel.View;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;

public class AnimationSystem {
	
	private Vector2f startPos;
	private Vector2f res;
	private final int NR_OF_EXPLOSIONS = 1;
	Explosion[] explosion;
	
public AnimationSystem(Vector2f resolution, Image spriteSheet, int nrOfFramesX, int nrOfFramesY)
{
	explosion = new Explosion[NR_OF_EXPLOSIONS];
	startPos = new Vector2f(0.5f, 0.5f);
	res = resolution;
	
	for (int i = 0; i < NR_OF_EXPLOSIONS; i++) {
		explosion[i] = new Explosion(startPos, nrOfFramesX, nrOfFramesY);
	}
}


public void update(int elapsedTime)
{
	for (int i = 0; i < NR_OF_EXPLOSIONS; i++) {
		explosion[i].update(elapsedTime);
	}
}

public void draw(Image image)
{
	for (int i = 0; i < NR_OF_EXPLOSIONS; i++) {
		explosion[i].draw(image, res);
	}
	
}

}