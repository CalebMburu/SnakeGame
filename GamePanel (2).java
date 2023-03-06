import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements ActionListener{

	//Sets up the Width of the game
	static final int GameWidth = 550;
	
	///Sets up the Height of the game
	static final int GameHeight = 550;
	
	//Sets up how large or how small u want the game to be.
	static final int GameSize = 20;

	
	//determines the speed at which the game is being played at.
	int SpeedOfGame = 80;
	
	//Holds the location of our snake parts.
	final int xaxis[] = new int[size];
	final int yaxis[] = new int[size];
	
	//Makes sure out game can fit everything it needs
	static final int size = (GameWidth*GameHeight)/(GameSize*GameSize);
	
	//Tells us how long the snake is.
	int SnakeLength = 3;
	
	//The amount of food the snake has consumed.
	int Score;
	
	//Holds the location our food
	int FoodLocationOnX;
	int FoodLocationOnY;
	
	//Holds location of Lava
	int LavaLocationOnX;
	int LavaLocationOnY;
	int L1LavaLocationOnX;
	int L1LavaLocationOnY;
	int L2LavaLocationOnX;
	int L2LavaLocationOnY;
	int L3LavaLocationOnX;
	int L3LavaLocationOnY;
	int L4LavaLocationOnX;
	int L4LavaLocationOnY;
	int L5LavaLocationOnX;
	int L5LavaLocationOnY;
	
	//The StartingDirection our snake needs to be facing when the game starts
	String StartingDirection = "Right";
	
	boolean GameInProgress = false;
	//timer
	Timer timer;
	
	//random
	Random random;
	
	GamePanel(){
		random = new Random();
		//SetSize is ruining the window setup
		this.setPreferredSize(new Dimension(GameWidth,GameHeight));
		this.setBackground(new Color(162,209,73));
		this.addKeyListener(new MyKeyAdapter());
		this.setFocusable(true);
		startGame();
	
	}
	
	public void playagain() {
        int choice = JOptionPane.showConfirmDialog(null, "Would you like to play again?");
        if (choice == JOptionPane.YES_OPTION) {
        	new SnakeGameFramingSetup();
        }
        else {
        	int secondndtimeasking = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?");
        	if(secondndtimeasking == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Thank you for playing!");
        }
        	else {
        		new SnakeGameFramingSetup();
        	}
	}
	}
   

	
	//Starting the game
	public void startGame() {
		//spawning a new food and lava
		SpawningFoodandLava();

		//Setting the game as GameInProgress
		GameInProgress = true;
		
		//Setting up the speed of the game
		timer = new Timer(SpeedOfGame,this);
		timer.start();
		
		
	}
	
	//Making the food appear
	public void SpawningFoodandLava(){
		/*Choosing a random location within the game board. We determine one of the axis at a time. First we divide Width by the
		size of objects in our game so that they are fitting.*/
		FoodLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		FoodLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
		
		LavaLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		LavaLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
		
		L1LavaLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		L1LavaLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
		
		L2LavaLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		L2LavaLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
		
		L3LavaLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		L3LavaLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
		
		L4LavaLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		L4LavaLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
		
		L5LavaLocationOnX = random.nextInt(GameWidth/GameSize)*GameSize;
		L5LavaLocationOnY = random.nextInt(GameHeight/GameSize)*GameSize;
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		//if the game is running then we will create food.
		if(GameInProgress) {
			//red food 
			g.setColor(Color.RED);
			//Sets up the location and the size of the food. 
			g.fillRect(FoodLocationOnX, FoodLocationOnY, GameSize, GameSize);
			
			//Lava food 
			g.setColor(Color.BLACK);
			//Sets up the location and the size of the lava. 
			g.fillRect(LavaLocationOnX, LavaLocationOnY, GameSize, GameSize);
			
			g.setColor(Color.BLACK);
			//Sets up the location and the size of the lava. 
			g.fillRect(L1LavaLocationOnX, L1LavaLocationOnY, GameSize, GameSize);
			
			g.setColor(Color.BLACK);
			//Sets up the location and the size of the lava. 
			g.fillRect(L2LavaLocationOnX, L2LavaLocationOnY, GameSize, GameSize);
			
			g.setColor(Color.BLACK);
			//Sets up the location and the size of the lava. 
			g.fillRect(L3LavaLocationOnX, L3LavaLocationOnY, GameSize, GameSize);
			
			g.setColor(Color.BLACK);
			//Sets up the location and the size of the lava. 
			g.fillRect(L4LavaLocationOnX, L4LavaLocationOnY, GameSize, GameSize);
			
			g.setColor(Color.BLACK);
			//Sets up the location and the size of the lava. 
			g.fillRect(L5LavaLocationOnX, L5LavaLocationOnY, GameSize, GameSize);
		
			for(int BodyCount = 0; BodyCount< SnakeLength; BodyCount++) {
			//setting up the color of the head
				//BodyCount is keeping track of which part of the boy we are on. 0 being the head, 1 behind 2nd block and so on.

				g.setColor(new Color(random.nextInt(255)));
				g.fillOval(xaxis[BodyCount], yaxis[BodyCount], GameSize, GameSize);	
			
				}			
	}
	}
	public void BasicSnakeMovement(){
		for(int i = SnakeLength;i>0;i--) {
			xaxis[i] = xaxis[i-1];
			yaxis[i] = yaxis[i-1];
		}
		
		switch(StartingDirection) {
		case "Up":
			//on y axis so up and down
			yaxis[0] = yaxis[0] - GameSize;
			break;
		case "Down":
			//on y axis so up and down
			yaxis[0] = yaxis[0] + GameSize;
			break;
		case "Left":
			//on x axis so left and right
			xaxis[0] = xaxis[0] - GameSize;
			break;
		case "Right":
			//on x axis so left and right
			xaxis[0] = xaxis[0] + GameSize;
			break;
		}
	}

		
		public void checkCollisions() {
			//Seeing if snake has ran into the cords which its body rests on.
			for(int i = SnakeLength;i>0;i--) {
				if((xaxis[0] == xaxis[i] && yaxis[0] == yaxis[i])) {
					//if snake has ran into those cords so its body then we end the game.
					GameInProgress = false;
					playagain();
				}
			}
			//Making sure that the snake doesn't run off the screen.
			if(xaxis[0] < 0 || xaxis[0] > GameWidth || yaxis[0] < 0 || yaxis[0] > GameHeight) {
				GameInProgress = false;
				playagain();
			}
			//Snake head on  and y-axis is in the same cord as the lava block then we run it.
			if((xaxis[0] == LavaLocationOnX && yaxis[0] == LavaLocationOnY)||
					(xaxis[0] == L1LavaLocationOnX && yaxis[0] ==L1LavaLocationOnY)||
					((xaxis[0] == L2LavaLocationOnX && yaxis[0] ==L2LavaLocationOnY))||
					(xaxis[0] == L3LavaLocationOnX && yaxis[0] ==L3LavaLocationOnY)||
					(xaxis[0] == L4LavaLocationOnX && yaxis[0] ==L4LavaLocationOnY)||
					(xaxis[0] == L5LavaLocationOnX && yaxis[0] ==L5LavaLocationOnY)) {
				//Decreasing the length of the body
				GameInProgress = false;
				playagain();
			}
		
	}
	public void CheckFood() {
		//Snake head on  and y-axis is in the same cord as the food then we run it.
		if((xaxis[0] == FoodLocationOnX && yaxis[0] == FoodLocationOnY)) {
			//increasing the length of the body
			SnakeLength++;
			//Increasing the number of food eaten.
			Score++;
			//Spawns another food for randomizes lava positions.
			SpawningFoodandLava();
			SpeedOfGame =  SpeedOfGame + 1000;

		}
	}
	
	public void CheckLava() {
		//Snake head on  and y-axis is in the same cord as the lava block then we run it.
		if((xaxis[0] == LavaLocationOnX && yaxis[0] == LavaLocationOnY)) {
			//Decreasing the length of the body
			SnakeLength--;
		}
	}

	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			//Making sure to not let the player go backwards on top of themselves. 
			case KeyEvent.VK_LEFT:
				//if they are not going right then they can turn left.
				if(StartingDirection != "Right") {
					StartingDirection = "Left";
				}
				break;
			case KeyEvent.VK_RIGHT:
				//if they are not going left then they can turn right.
				if(StartingDirection != "Left") {
					StartingDirection = "Right";
				}
				break;
			case KeyEvent.VK_UP:
				//if they are not going down then they can go up.
				if(StartingDirection != "Down") {
					StartingDirection = "Up";
				}
				break;
			case KeyEvent.VK_DOWN:
				//if they are not going up then they can go down.
				if(StartingDirection != "Up") {
					StartingDirection = "Down";
				}
				break;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if game is in progress
		if(GameInProgress) {
			//Starting moving 
			BasicSnakeMovement();
			//Checking if food is has been eaten.
			CheckFood();
			//Checking if lava has been touched.
			CheckLava();
			//If we have ran into the walls.
			checkCollisions();
		}
		repaint();
	}
}