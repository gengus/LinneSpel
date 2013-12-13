package LinneSpel.Controller;
import LinneSpel.View.*;

import java.util.logging.Level;
import java.util.logging.Logger;



import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import LinneSpel.Model.*;




public class MasterController extends BasicGame
{
	private BallSimulation ballSimulation;
	private BallView ballView;

	
	public MasterController(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		
		ballSimulation = new BallSimulation();
		ballView = new BallView(gc.getWidth(), gc.getHeight());
		
		
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		ballSimulation.update();
	}

	
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.setBackground(Color.white);
		ballView.render(g, ballSimulation);
		
		
	}

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new MasterController("Labb1 övn4"));
			appgc.setDisplayMode(768, 768, false);
		
			appgc.setShowFPS(false);
			
			appgc.start();
			
		}
		catch (SlickException ex)
		{
			Logger.getLogger(MasterController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}