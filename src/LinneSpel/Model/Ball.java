package LinneSpel.Model;
import org.newdawn.slick.geom.Vector2f;

public class Ball {
	private Vector2f pos;
	private Vector2f speed;
	private float radius;
	
	public Ball(Vector2f pos, Vector2f speed, float radius)
	{
		this.pos = pos;
		this.speed = speed;
		this.radius = radius;
	}

	public Vector2f getPos()
	{
		return this.pos;
	}
	
	public float getSpeedX()
	{
		return this.speed.x;
	}
	
	public float getSpeedY()
	{
		return this.speed.y;
	}
	

	public void setPos(Vector2f newPos)
	{
		this.pos = newPos;
	}
	
	public void setSpeedX(float newSpeed)
	{
		this.speed.x = newSpeed;
	}
	
	public void setSpeedY(float newSpeed)
	{
		this.speed.y = newSpeed;
	}
	
	public float getRadius()
	{
		return this.radius;
	}
	
	public void update()
	{
		this.pos.add(this.speed);
	}
	
}

