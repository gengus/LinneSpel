package LinneSpel.Model;
import org.newdawn.slick.geom.Vector2f;


public class BallSimulation {
	
	public Ball b = new Ball(new Vector2f(0.2f,0.5f), new Vector2f(0.01f, 0.01f), 0.05f);

	public void update()
	{		
		if(b.getPos().x>=0.90f-b.getRadius()*2)
		{
			b.setSpeedX(b.getSpeedX()*-1);
		}
		
		if(b.getPos().y>=0.90f-b.getRadius()*2)
		{
			b.setSpeedY(b.getSpeedY()*-1);
		}
		
		if(b.getPos().x<=0.10f)
		{
			b.setSpeedX(b.getSpeedX()*-1);
		}
		
		if(b.getPos().y<=0.10f)
		{
			b.setSpeedY(b.getSpeedY()*-1);
		}	
			b.update();
	}

}
