package gameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import utility.Resource;

public class Cactus extends Enemy {
	
	private BufferedImage image;
	private int posX, posY;
	private Rectangle rect;
	
	public Cactus() {
		image = Resource.getResouceImage("data/cactus1.png");
		posX = 200;
		posY = 95;
		rect = new Rectangle();
	}
	
	public void update() {
		posX -= 2;
		rect.x = posX;
		rect.y = posY;
		rect.width = image.getWidth();
		rect.height = image.getHeight();
	}
	
	@Override
	public Rectangle getBound() {
		return rect;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, posX, posY, null);
	}
	
	public void setX(int x) {
		posX = x;
	}
	
	public void setY(int y) {
		posY = y;
	}
	
	public void setImage (BufferedImage image) {
		this.image = image;
	}

	@Override
	public boolean isOutOfScreen() {
		return (posX + image.getWidth() <0);
	}
	
	
}
