package nl.plaatsoft.cyber.ui;

import javafx.animation.AnimationTimer;
import javafx.scene.layout.Pane;

import nl.plaatsoft.cyber.model.Factory;
import nl.plaatsoft.cyber.tools.Constants;
import nl.plaatsoft.cyber.tools.MyLabel;

public class ResourceBox {

	private Pane pane;
	
	private MyLabel label5;	
	private MyLabel label6;
	private MyLabel label7;
	private MyLabel label8;

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

	public ResourceBox() {
		
		pane = new Pane();
		pane.setLayoutX(Constants.WIDTH-100);
		pane.setLayoutY(10);
		
		int x = 1;
		int y = 0; 
				
		MyLabel label1 = new MyLabel(x, y, "Money", 12, "white");
		pane.getChildren().add(label1);
		
		MyLabel label2 = new MyLabel(x, y+=20, "BCoin", 12, "white");
		pane.getChildren().add(label2);
		
		MyLabel label3 = new MyLabel(x, y+=20, "Gold", 12, "white");
		pane.getChildren().add(label3);
		
		MyLabel label4 = new MyLabel(x, y+=20, "Thread", 12, "white");
		pane.getChildren().add(label4);
					
		x = 50;
		y = 0;
		
		label5 = new MyLabel(x, y, "", 12, "green");
		pane.getChildren().add(label5);
		
		label6 = new MyLabel(x, y+=20, "", 12, "orange");
		pane.getChildren().add(label6);
				
		label7 = new MyLabel(x, y+=20, "", 12, "yellow");
		pane.getChildren().add(label7);		
		
		label8 = new MyLabel(x, y+=20, "", 12, "red");
		pane.getChildren().add(label8);
		
		AnimationTimer timer = new AnimationTimer() {			 
		 	
			@Override
			public void handle(long now) {
	            		
				label5.setText("" + Factory.getSettings().getMoney());
				label6.setText("" + Factory.getSettings().getBcoins());		
				label7.setText("" + Factory.getSettings().getGold());
				label8.setText("" + Factory.getSettings().getThread());		
			}
		};
		
		timer.start();		
	}
	
}
