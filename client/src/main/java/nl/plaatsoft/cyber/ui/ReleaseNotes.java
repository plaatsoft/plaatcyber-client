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

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

import nl.plaatsoft.cyber.tools.MyButton;
import nl.plaatsoft.cyber.tools.MyLabel;
import nl.plaatsoft.cyber.tools.MyPanel;

public class ReleaseNotes extends MyPanel {
	
	private static String[] version = {
							
			"03-08-2017 (Version 0.1)\n"
			+ "- Start working on this project.\n"
			+ "- Added two intro pages.\n"
			+ "- Added game page.\n"
			+ "- Added element 3D model.\n"
			+ "- Added upgrade element with timer.\n"};

	private static MyLabel text;
	
	public void draw() {
		
		Image image1 = new Image("images/background2.png");
    	BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
    	BackgroundImage backgroundImage = new BackgroundImage(image1, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
    	Background background = new Background(backgroundImage);
    	    	  
    	setBackground(background);
    	
    	 ScrollBar s1 = new ScrollBar();
    	 s1.setMin(0);
    	 s1.setMax(version.length-1);         
         s1.setValue(0);
         s1.setUnitIncrement(1);
         s1.setBlockIncrement(1);
         s1.setLayoutX(590);
         s1.setLayoutY(125);
         s1.setMinWidth(25);
         s1.setMinHeight(275);
         s1.setOrientation(Orientation.VERTICAL);
         
         s1.valueProperty().addListener(new ChangeListener<Number>() {
             public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
            	 text.setText(version[new_val.intValue()]);
             }
         });
         
         getChildren().add(s1);
                  
    	getChildren().add( new MyLabel(0, 20, "Release Notes", 60, "white", "-fx-font-weight: bold;"));
    	text = new MyLabel(30, 120, version[0], 20, "white");
    	getChildren().add( text );    	
    	getChildren().add( new MyButton(230, 420, "Close", 18, Navigator.HOME));     
	}
}
