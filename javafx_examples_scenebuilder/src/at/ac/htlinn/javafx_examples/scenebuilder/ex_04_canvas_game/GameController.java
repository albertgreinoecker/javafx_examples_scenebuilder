package at.ac.htlinn.javafx_examples.scenebuilder.ex_04_canvas_game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class GameController {
	private ArrayList<Sprite> monsters;
	private GameTimer gameLoop;
	private Timer newMonsterTimer, monsterDownTimer;
	private int stepDown = 10;
	private Image monsterImg = new Image("at/ac/htlinn/javafx_examples/scenebuilder/ex_04_canvas_game/monster.png");
	private Image shipImg = new Image("at/ac/htlinn/javafx_examples/scenebuilder/ex_04_canvas_game/ship.png");
	private Image backImg = new Image("at/ac/htlinn/javafx_examples/scenebuilder/ex_04_canvas_game/back.jpg");
	private Image gameOverImg = new Image("at/ac/htlinn/javafx_examples/scenebuilder/ex_04_canvas_game/explosion.jpg");
	private GraphicsContext gc;
	private Sprite player;

	@FXML
	private Canvas field;

	@FXML
	private Button startBtn;

	@FXML
	private Label noMonsterLbl;

	@FXML
	private Label feedbackLbl;

	@FXML
	public void initialize() {
		monsters = new ArrayList<>();
		gameLoop = new GameTimer();
		NewMonsterTask monsterTask = new NewMonsterTask();
		newMonsterTimer = new Timer(true);
		newMonsterTimer.schedule(monsterTask, 0, 500);
		monsterDownTimer = new Timer(true);
		MonsterDownTask monsterDownTask = new MonsterDownTask();
		monsterDownTimer.schedule(monsterDownTask, 0, 100);
		gc = field.getGraphicsContext2D();

		player = new Sprite((int) (field.getWidth() / 2), (int) (field.getHeight() - 30));

		field.setOnMouseMoved(e -> {
			double x = e.getX();
			if (x < player.getX()) {
				player.moveX(-20);
			} else {
				player.moveX(20);
			}
		});

		field.setOnMouseClicked(e -> {
			player.up(10);
		});

		gameLoop.start();
	}

	class GameTimer extends AnimationTimer {
		@Override
		protected void finalize() throws Throwable {
			super.finalize();
		}

		@Override
		public void start() {
			super.start();
		}

		@Override
		public void stop() {
			super.stop();
		}

		@Override
		public void handle(long now) {
			gc.drawImage(backImg, 0, 0);
			for (Sprite m : monsters) {
				gc.drawImage(monsterImg, m.getX(), m.getY());
				if (player.collision(m)) {
					gc.drawImage(gameOverImg, 100, 100);
					feedbackLbl.setText("Verloren!");
					stopGame();
				} else if (player.getY() < 20) // reached top of game field
				{
					feedbackLbl.setText("Gewonnen!");
					stopGame();
				}
			}
			gc.drawImage(shipImg, player.getX(), player.getY());
		}
	}

	private void stopGame() {
		newMonsterTimer.cancel();
		monsterDownTimer.cancel();
		gameLoop.stop();
	}

	class NewMonsterTask extends TimerTask {
		@Override
		public void run() {
			Sprite m = new Sprite((int) (Math.random() * field.getWidth()), 0);
			System.out.println(m);
			monsters.add(m);
			Platform.runLater(() -> {
				noMonsterLbl.setText(String.format("M: %d", monsters.size()));
			});
		}
	}

	class MonsterDownTask extends TimerTask {
		@Override
		public void run() {
			for (Sprite m : monsters) {
				m.down(stepDown);
			}
		}
	}
}
