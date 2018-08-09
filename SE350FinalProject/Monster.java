package seFinal;

import java.awt.Point;
import java.util.Random;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class MonsterSprite{
	int x;
	int y;
	int scalingFactor;
	Image sharkImage;
	ImageView sharkImageView;
	
	//static OceanMap oceanMap;
	//ShipStrategy shipStrategy;
	//Point currentMonsterLocation;
	
	MonsterSprite(int x, int y, int scalingFactor){
		this.x = x;
		this.y = y;
		this.scalingFactor = scalingFactor;
		sharkImage = new Image("image\\shark.jpg",scalingFactor,scalingFactor,true,true); 
		sharkImageView = new ImageView(sharkImage);
	}
	
	public ImageView getImage(){
		return sharkImageView;
	}
	void setX(int x){
		sharkImageView.setX(x * scalingFactor);
	}
	
	void setY(int y){
		sharkImageView.setY(y* scalingFactor);
	}
	
	int getX(){
		return x;
	}
	
	int getY(){
		return y;
	}
}
	
public class Monster implements Runnable {
	
	Boolean running = true;
	Random random = new Random();
	int scalingFactor;
	MonsterSprite[] monsterSprites = new MonsterSprite[10];//was 20
	public Monster(int scalingFactor){
		for(int j = 0; j < 10; j++){ // was 20
			int x = random.nextInt(25);// was 50
			int y = random.nextInt(25);// was 50
			monsterSprites[j] = new MonsterSprite(x,y,scalingFactor);
		}
		
		this.scalingFactor = scalingFactor;
	}
	
	public void addToPane(ObservableList<Node> sceneGraph){
		for(MonsterSprite monsterSprite: monsterSprites){
			ImageView sharkImageView = monsterSprite.getImage();
			System.out.println("Adding circle to pane: " + sharkImageView.getX() + " " + sharkImageView.getY());
			sceneGraph.add(sharkImageView);
		}
	}
			
	@Override
    public void run() {
      while (true) {
    	try {
    		// This is the speed
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	for(MonsterSprite monsterSprite: monsterSprites){
    		// Move X
    		int xMove = monsterSprite.getX() + random.nextInt(3)-1;
    		if (xMove >=0 && xMove <= 24)// was 50
    			monsterSprite.setX(xMove);
    		// Move Y
    		int yMove = monsterSprite.getY() + random.nextInt(3)-1;
    		if (yMove >=0 && yMove <=24)// was 50
    			monsterSprite.setY(yMove);
    		
    		
    		// This is where we were thinking about trying to add a if statement to see if the ship and monster on in the same cell
    	}
      }
      
	}
}
