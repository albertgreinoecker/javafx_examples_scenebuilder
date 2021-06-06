package at.ac.htlinn.javafx_examples.scenebuilder.ex_04_canvas_game;

public class Sprite {
	private int x;
	private int y;

	public Sprite(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void down(int step) {
		this.y += step;
		this.x += (int) (Math.random() * -20) + 10; // move direction by random
	}

	public void up(int step) {
		this.y -= step;
	}
		
	/**
	 * 
	 * @param step can be negative
	 */
	public void moveX(int step)
	{
		this.x += step;
	}
	public boolean collision(Sprite other)
	{
		return Math.abs(x - other.getX()) < 20 && Math.abs(y - other.getY()) < 20;
	}
	
	@Override
	public String toString() {
		return "Monster [x=" + x + ", y=" + y + "]";
	}
}
