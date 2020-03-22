package nl.plaatsoft.cyber.ui;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import nl.plaatsoft.cyber.model.Factory;
import nl.plaatsoft.cyber.model.Library;
import nl.plaatsoft.cyber.model.Element;
import nl.plaatsoft.cyber.model.ElementLevel;
import nl.plaatsoft.cyber.model.ElementType;
import nl.plaatsoft.cyber.tools.Constants;
import nl.plaatsoft.cyber.tools.MyButton;

public class Shop {

	private Pane pane;	
	private Random random = new Random();
		
	private MyButton button00;
	private MyButton button01;
	
	private MyButton button1;
	private MyButton button2;
	private MyButton button3;
	private MyButton button4;
	private Group group;
	
	private MyButton button10;
	private MyButton button11;
	private MyButton button12;
	private MyButton button13;
	private MyButton button14;
	private Group group1;
	
	private MyButton button20;
	private MyButton button21;
	private MyButton button22;
	private MyButton button23;
	private Group group2;
	
	private MyButton button30;
	private MyButton button31;
	private MyButton button32;
	private Group group3;
	
	private MyButton button40;
	private MyButton button41;
	private MyButton button42;
	private Group group4;
		 
	public Shop() {
				
		pane = new Pane();
		
		pane.setLayoutX(1);
		pane.setLayoutY(1);
		pane.setMinWidth(Constants.WIDTH-25);
		pane.setMinHeight(40);
		
		int x = Constants.WIDTH-80;
		int y = Constants.HEIGHT-60;
			
		button00 = new MyButton(x, y, 70, 50, "Build", 0);		
 		button00.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
            	 group.setVisible(true);   
            	 group1.setVisible(true);   
            	 group2.setVisible(false);
            	 group3.setVisible(false);
            	 group4.setVisible(false); 
            	 
            	 button1.setDisable(true);
            	 button2.setDisable(false);
            	 button3.setDisable(false);
            	 button4.setDisable(false);
            	 
            	 button00.setVisible(false);            	 
            	 button01.setVisible(true);
             }
        });
 		
 		pane.getChildren().add(button00);
 		
 		button01 = new MyButton(x, y, 70, 50, "Close", 0);		
 		button01.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
            	 group.setVisible(false);
            	 group1.setVisible(false);
            	 group2.setVisible(false);
            	 group3.setVisible(false);
            	 group4.setVisible(false);
            	 
            	 button00.setVisible(true);            	 
            	 button01.setVisible(false);
             }
        });
 		button01.setVisible(false);
 		
 		pane.getChildren().add(button01);
 		
 		button10 = new MyButton(x, y, 70, 50, "Close", 0);	 			
		button10 = new MyButton(x, y, "Access Point", 0);
 		button10.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
             	buy(ElementType.ACCESS_POINT);   	
             }
         });
 		
		x = 10;
		y = Constants.HEIGHT-65;
		int width = 120;
		int height = 25;
		
		button10 = new MyButton(x, y, width, height, "Access Point", 0);
 		button10.setOnAction(new EventHandler<ActionEvent>() {
             public void handle(ActionEvent event) {
             	buy(ElementType.ACCESS_POINT);   	
             }
         });
 		 		
	    button11 = new MyButton(x+=width+10, y, width, height, "Web Server", 0);    
	    button11.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.WEB_SERVER);   	
            }
        });
	    
	    button12 = new MyButton(x+=width+10, y, width, height, "Web Database", 0); 
	    button12.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.WEB_DATABASE);   	
            }
        });
	    
	    button13 = new MyButton(x+=width+10, y, width, height, "Coin Server", 0); 
	    button13.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.COIN_SERVER);   	
            }
        });
	    
	    button14 = new MyButton(x+=width+10, y, width, height, "Coin Database", 0);
	    button14.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.COIN_DATABASE);   	
            }
        });
	    
	    group1 = new Group();
		group1.getChildren().addAll(button10, button11, button12, button13, button14);		
		pane.getChildren().add(group1);
	    
	    /* ------------------------ */
	    
		x = 10;
		y = Constants.HEIGHT-65;
		
		button20 = new MyButton(x, y, width, height, "Firewall", 0);
		button20.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.FIREWALL);   	
            }
        });
		
		button21 = new MyButton(x+=width+10, y, width, height, "Virus Scanner", 0);
		button21.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.VIRUS_SCANNER);   	
            }
        });
		
		button22 = new MyButton(x+=width+10, y, width, height, "Email Scanner", 0);
		button22.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.EMAIL_SCANNER);   	
            }
        });
		
		button23 = new MyButton(x+=width+10, y, width, height, "Mallware Scanner", 0);
		button23.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.MALLWARE_SCANNER);   	
            }
        });
		
		group2 = new Group();
		group2.getChildren().addAll(button20, button21, button22, button23);		
		pane.getChildren().add(group2);
		
		/* ------------------------ */
		
		x = 10;
		y = Constants.HEIGHT-65;
		
		button30 = new MyButton(x, y, width, height, "Compiler", 0);       
		button30.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.COMPILER);   	
            }
        });
		
	    button31 = new MyButton(x+=width+10, y, width, height,  "Evolver", 0);	
	    button31.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.EVOLVER);   	
            }
        });
	    
	    button32 = new MyButton(x+=width+10, y, width, height, "Library", 0);
	    button32.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.LIBRARY);   	
            }
        });
	    
	    group3 = new Group();
		group3.getChildren().addAll(button30, button31, button32);		
		pane.getChildren().add(group3);
	    
	    /* ------------------------ */
	    
	    x = 10;
		y = Constants.HEIGHT-65;
	    
		button40 = new MyButton(x, y, width, height, "1 Day Protection", 0);
		button40.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.ONE_DAY_PROTECTION);   	
            }
        });
		
		button41 = new MyButton(x+=width+10, y, width, height, "2 Day Protection", 0);
		button41.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.TWO_DAY_PROTECTION);   	
            }
        });
		
	    button42 = new MyButton(x+=width+10, y, width, height, "7 Day Protection", 0);
	    button42.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            	buy(ElementType.SEVEN_DAY_PROTECTION);   	
            }
        });
	    
	    group4 = new Group();
		group4.getChildren().addAll(button40, button41, button42);		
		pane.getChildren().add(group4);

	    /* ------------------------ */
	    
		x = 10;
		y = Constants.HEIGHT-32;
						
		button1 = new MyButton(x, y, width, height, "Business", 0);
		button1.setOnAction(new EventHandler<ActionEvent>() { 			
             public void handle(ActionEvent event) {            	
            	 group1.setVisible(true);   
            	 group2.setVisible(false);
            	 group3.setVisible(false);
            	 group4.setVisible(false); 
            	 
            	 button1.setDisable(true);
            	 button2.setDisable(false);
            	 button3.setDisable(false);
            	 button4.setDisable(false);
             }
		});
		
		button2 = new MyButton(x+=width+10, y, width, height, "Security", 0);
		button2.setOnAction(new EventHandler<ActionEvent>() { 			
            public void handle(ActionEvent event) {           	 
            	group1.setVisible(false);   
           	 	group2.setVisible(true);
           	 	group3.setVisible(false);
           	 	group4.setVisible(false); 
           	 
           	 	button1.setDisable(false);
           	 	button2.setDisable(true);
           	 	button3.setDisable(false);
           	 	button4.setDisable(false);
            }
		});
		
		button3 = new MyButton(x+=width+10, y, width, height, "Hacking", 0);
		button3.setOnAction(new EventHandler<ActionEvent>() { 			
            public void handle(ActionEvent event) {           	
            	group1.setVisible(false);   
           	 	group2.setVisible(false);
           	 	group3.setVisible(true);
           	 	group4.setVisible(false);
           	 
           	 	button1.setDisable(false);
           	 	button2.setDisable(false);
           	 	button3.setDisable(true);
           	 	button4.setDisable(false);
            }
		});
		
		button4 = new MyButton(x+=width+10, y, width, height, "Market", 0);
		button4.setOnAction(new EventHandler<ActionEvent>() { 			
            public void handle(ActionEvent event) {           	
            	group1.setVisible(false);   
           	 	group2.setVisible(false);
           	 	group3.setVisible(false);
           	 	group4.setVisible(true);
           	 
           	 	button1.setDisable(false);
           	 	button2.setDisable(false);
           	 	button3.setDisable(false);
           	 	button4.setDisable(true);
            }
		});
             
		group = new Group();
		group.getChildren().addAll(button1, button2, button3, button4);		
		pane.getChildren().add(group);
		
		group.setVisible(false);
		group1.setVisible(false);
		group2.setVisible(false);
		group3.setVisible(false);
		group4.setVisible(false);
	}
	
	private void buy(ElementType nodeType ) {
					
		Library library = Factory.getLibraryDAO().find(nodeType, ElementLevel.ONE);
		
		// Check if there is enough money
		if (library.getPrice()<Factory.getSettings().getMoney()) {
			
			// Get coreNode;
			ElementBox coreNode = Factory.getElementBoxDAO().find(ElementType.CORE);
			
			ArrayList<Element> nodes = new ArrayList<Element>();
			nodes.add(coreNode.getElement());
			
			// Created new node
			Element element = new Element(random.nextInt(Constants.WIDTH), random.nextInt(Constants.HEIGHT), nodeType, nodes);
			ElementBox elementBox = new ElementBox(element);					
			Factory.getElementBoxDAO().add(elementBox);     	
			
			// Remove money
			Factory.getSettings().setMoney(Factory.getSettings().getMoney()-library.getPrice());
		}
	}

	/*private void popup(String text ) {
		
		Label label = new Label(text);
	    
	    SequentialTransition t = new SequentialTransition();

	    if (this.group.getOpacity() == 1.0) {
	        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.5), group);
	        fadeOut.setFromValue(1.0);
	        fadeOut.setToValue(0.0);
	        t.getChildren().add(fadeOut);
	    }

	    FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.5), group));
	    fadeIn.setFromValue(0.0);
	    fadeIn.setToValue(1.0);

	    t.getChildren().add(fadeIn);
	    t.play();	    
	}*/

		
	public Pane getPane() {
		return pane;
	}	
}
