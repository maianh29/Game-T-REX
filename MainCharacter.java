
package gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import utility.Animation;
import utility.Resource;

import static userInterface.GameScreen.GRAVITY;
import static userInterface.GameScreen.GROUNDY;;

public class MainCharacter {
	
	private float x=0,y=0;
	private float speedY = 0;
	private Animation characterRun;
	private Rectangle rect;
	
	public MainCharacter() {
		characterRun = new Animation(200);
		characterRun.addFrame(Resource.getResouceImage("data/main-character1.png"));
		characterRun.addFrame(Resource.getResouceImage("data/main-character2.png"));
		rect = new Rectangle();
	}
	
	public void update() {
		characterRun.update();
		//code for jumping
		if(y>= GROUNDY - characterRun.getFrame().getHeight()) {
			speedY = 0;
			y = GROUNDY - characterRun.getFrame().getHeight();
		}
		else {
			speedY+=GRAVITY;
			y+=speedY;
		}
		rect.x= (int) x;
		rect.y =(int) y;
		rect.width = characterRun.getFrame().getWidth();
		rect.height = characterRun.getFrame().getHeight();
	}
	
	public Rectangle getBound() {
		return rect;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawRect((int)x,(int) y, characterRun.getFrame().getWidth(), characterRun.getFrame().getHeight());//ve 1 hinh vuong
		g.drawImage(characterRun.getFrame(), (int)x,(int) y, null);
	}
	
	public void jump() {
		speedY = -4;
		y += speedY;
	}
	
	public float getX() {
		return x;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public float getSpeedY() {
		return speedY;
	}
	
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
}
