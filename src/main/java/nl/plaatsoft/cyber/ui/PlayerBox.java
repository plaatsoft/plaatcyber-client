package nl.plaatsoft.cyber.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;
import nl.plaatsoft.cyber.model.Factory;
import nl.plaatsoft.cyber.tools.MyLabel;

public class PlayerBox {

	private Pane pane;
	
	private MyLabel label3;	
	private MyLabel label4;

	public Pane getPane() {
		return pane;
	}
	
	public PlayerBox() {
		
		pane = new Pane();
		pane.setLayoutX(10);
		pane.setLayoutY(10);
		
		int x = 1;
		int y = 0; 
		
		MyLabel label1 = new MyLabel(x, y, "Level", 12, "white");
		pane.getChildren().add(label1);
		
		MyLabel label2 = new MyLabel(x, y+=20, "Player", 12, "white");
		pane.getChildren().add(label2);
							
		x = 50;
		y = 0;
		
		label3 = new MyLabel(x, y, "", 12, "red");
		pane.getChildren().add(label3);
		
		label4 = new MyLabel(x, y+=20, "", 12, "green");
		pane.getChildren().add(label4);
						
		AnimationTimer timer = new AnimationTimer() {			 
		 	
			@Override
			public void handle(long now) {
	            		
				label3.setText("" + Factory.getSettings().getLevel());
				label4.setText("" + Factory.getSettings().getPlayerName());
			}
		};
		
		timer.start();		
	}
	
}
