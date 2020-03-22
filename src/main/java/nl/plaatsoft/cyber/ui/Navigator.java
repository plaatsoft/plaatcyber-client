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

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import nl.plaatsoft.cyber.tools.Constants;
import nl.plaatsoft.cyber.tools.ScoreGlobal;

public class Navigator {
		
	private static Intro intro;
	private static Home home;
	private static Game game;	
	private static Donate donate;
	private static HighScore1 highScore1;
	private static HighScore2 highScore2;
	private static Credits credits;	
	private static ReleaseNotes releaseNotes;
	private static Help help;
	private static Settings settings;	
	
	private static Scene scene = null;
			
	public static final int INTRO = 1;
	public static final int HOME = 2;
	public static final int GAME = 3;
	public static final int DONATE = 4;
	public static final int LOCAL_HIGHSCORE = 5;
	public static final int GLOBAL_HIGHSCORE = 6;
	public static final int CREDITS = 7;
	public static final int RELEASE_NOTES = 8;
	public static final int HELP = 9;
	public static final int SETTINGS = 10;
	public static final int EXIT = 11;
			
	public static void setScene(Parent root) {
		
		if (scene==null) {
			scene = new Scene(root, Constants.WIDTH, Constants.HEIGHT, false);
			scene.getStylesheets().add("style.css");
		} 
		scene.setRoot(root);
	}
	
	public static Scene getScene() {
		return scene;
	}
	
	public static void go(int page) {
				
		switch (page ) {
					
			case INTRO:
				intro = new Intro();				
				intro.draw();
				setScene(intro);
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				    public void handle(KeyEvent key) {
				    	Navigator.go(Navigator.HOME);			
				    }
				});		
				break;		
				
			case HOME:
				if (home==null) {
					home = new Home();
				}
				home.draw();
				setScene(home);	
				scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
				    public void handle(KeyEvent key) {
				       // switch it off
				    }
				});		
				break;		
		
			case GAME:
				game = new Game();
				game.draw();		
				setScene(game);					
				break;		
				
			case LOCAL_HIGHSCORE:
				ScoreGlobal.clear();
				
				highScore1 = new HighScore1();
				highScore1.draw();
				
				setScene(highScore1);
				break;
				
			case GLOBAL_HIGHSCORE:
				highScore2 = new HighScore2();
				setScene(highScore2);
				highScore2.draw();
				break;		
				
			case DONATE:
				donate = new Donate();
				setScene(donate);
				donate.draw();
				break;
								
			case CREDITS:
				credits = new Credits();
				credits.draw();
				setScene(credits);
				break;	
				
			case RELEASE_NOTES:
				releaseNotes = new ReleaseNotes();
				releaseNotes.draw();
				setScene(releaseNotes);				
				break;		
				
			case SETTINGS:
				settings = new Settings();
				settings.draw();
				setScene(settings);			
				break;	
				
			case HELP:
				help = new Help();
				help.draw();
				setScene(help);			
				break;	
				
			case EXIT:
				Platform.exit();
				break;
		}
	}
}
