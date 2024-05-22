
package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import utility.Resource;

public class EnemiesManager {
	
	private List<Enemy> enemies;
	private Random random;
	private BufferedImage[] cactusImages;
	
	public EnemiesManager() {	
		random = new Random();		
		enemies = new ArrayList<Enemy>();
		
		cactusImages = new BufferedImage[3];
		cactusImages[0] = Resource.getResouceImage("data/cactus1.png");
		cactusImages[1] = Resource.getResouceImage("data/cactus2.png");
		cactusImages[2] = Resource.getResouceImage("data/cactus3.png");
		
		enemies.add(getRandomCactus());
	}
	

	public void update() {
		for(Enemy e : enemies) {
			e.update();
		}
		Enemy firstEnemy = enemies.get(0);
		if(firstEnemy.isOutOfScreen()) {
			enemies.remove(firstEnemy);
			enemies.add(getRandomCactus());
		}

	}
	
	public void draw(Graphics g) {
		for(Enemy e : enemies) {
			e.draw(g);
		}
	}
	
	private Cactus getRandomCactus() {
		Cactus cactus = new Cactus();
		cactus.setX(600);
		cactus.setImage(cactusImages[random.nextInt(cactusImages.length)]);
        return cactus;
	}

}
