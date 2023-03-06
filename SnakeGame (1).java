import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class SnakeGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageIcon icon = new ImageIcon("Snakess.PNG");
		int choice = JOptionPane.showConfirmDialog(null, "Would you like to play Snake?", "Snake Game", 0, 0, icon);
        if (choice == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(null, "Snake is a game in which you control a snake and your aim is to acquire red-colored food. Try to stay away from the black blocks. Every time you eat food, your speed will rise and the position of the blocks will be randomized. Good luck!");
            new SnakeGameFramingSetup();

        }
    }
}
