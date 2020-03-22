/**
 *  @file
 *  @brief 
 *  @author wplaat
 *
 *  Copyright (C) 2008-2016 PlaatSoft
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, version 3.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package nl.plaatsoft.cyber.ui;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.animation.AnimationTimer;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import nl.plaatsoft.cyber.model.Factory;
import nl.plaatsoft.cyber.model.Element;
import nl.plaatsoft.cyber.model.ElementState;
import nl.plaatsoft.cyber.model.ElementType;
import nl.plaatsoft.cyber.tools.MyPanel;

public class Game extends MyPanel {
	
	
	Game() {
		Image image1 = new Image("images/background2.png");
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
		BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		setBackground(background);
				
		PlayerBox playerBox = new PlayerBox();
		getChildren().add(playerBox.getPane());
		
		ResourceBox resourceBox = new ResourceBox();
		getChildren().add(resourceBox.getPane());
				
		Shop shop = new Shop();
		getChildren().add(shop.getPane());
						
		// Create Core
		Element element1 = new Element(150, 150, ElementType.CORE, new ArrayList<Element>());
		ElementBox elementBox1 = new ElementBox(element1);		
		Factory.getElementBoxDAO().add(elementBox1);	
				
		// Create Access Point
		ArrayList<Element> list1 = new ArrayList<Element>();
		list1.add(element1);		
		Element element2 = new Element(250, 250, ElementType.ACCESS_POINT, list1);
		ElementBox elementBox2 = new ElementBox(element2);		
		Factory.getElementBoxDAO().add(elementBox2);	
		
		AnimationTimer timer = new AnimationTimer() {			 
						 	
			@Override
			public void handle(long now) {
	            		
				ArrayList <ElementBox> list = Factory.getElementBoxDAO().getNodes();
				Iterator <ElementBox> iter = list.iterator();
				while (iter.hasNext()) {
							
					ElementBox elementBox = iter.next();
					
					switch (elementBox.getElement().getNodeState()) {
						
						case NEW:
							getChildren().add(elementBox.getGroup());
							elementBox.getElement().setNodeState(ElementState.IDLE);
							//rotate3dGroup(elementBox.getGroup());
							break;
							
						case DESTROYED:
							getChildren().remove(elementBox.getGroup());
							Factory.getElementBoxDAO().remove(elementBox);
							return;
					}					
				}				
			}
		};
		
		timer.start();   
		
		
	}

	private RotateTransition rotate3dGroup(Group group) {
	    RotateTransition rotate = new RotateTransition(Duration.seconds(10), group);
	    rotate.setAxis(Rotate.Y_AXIS);
	    rotate.setFromAngle(0);
	    rotate.setToAngle(360);
	    rotate.setInterpolator(Interpolator.LINEAR);
	    rotate.setCycleCount(RotateTransition.INDEFINITE);

	    return rotate;
	  }
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
}
