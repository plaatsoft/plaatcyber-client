package nl.plaatsoft.cyber.ui;

import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import nl.plaatsoft.cyber.model.Element;
import nl.plaatsoft.cyber.model.ElementLevelUtils;
import nl.plaatsoft.cyber.model.ElementState;
import nl.plaatsoft.cyber.model.ElementType;
import nl.plaatsoft.cyber.tools.Constants;

public class ElementBox {

	private Group group;
	private Element element; 
	
	private PhongMaterial material1;
	private PhongMaterial material2; 
	private Sphere sphere;
	private Label levelLabel;
	private Label upgradeLabel;
		
	private String getDiff(Date d2) {
		
		String returnValue = null;
		
		long diff = d2.getTime() - new Date().getTime();
		if (diff>1000) {

			long seconds = TimeUnit.MILLISECONDS.toSeconds(diff);
			long minutes = TimeUnit.MILLISECONDS.toMinutes(diff); 
			long hours = TimeUnit.MILLISECONDS.toHours(diff);
			long days = TimeUnit.MILLISECONDS.toDays(diff);
		
			returnValue = String.format("%02d", days)+":"+String.format("%02d", hours)+":"+String.format("%02d", minutes)+":"+String.format("%02d", seconds);
		} 
		return returnValue;
	}
	
	public Cylinder createConnection(Point3D origin, Point3D target) {
	    Point3D yAxis = new Point3D(0, 1, 0);
	    Point3D diff = target.subtract(origin);
	    double height = diff.magnitude();

	    Point3D mid = target.midpoint(origin);
	    Translate moveToMidpoint = new Translate(mid.getX(), mid.getY(), mid.getZ());

	    Point3D axisOfRotation = diff.crossProduct(yAxis);
	    double angle = Math.acos(diff.normalize().dotProduct(yAxis));
	    Rotate rotateAroundCenter = new Rotate(-Math.toDegrees(angle), axisOfRotation);

	    Cylinder line = new Cylinder(2, height);

	    line.getTransforms().addAll(moveToMidpoint, rotateAroundCenter);

	    return line;
	}
		
	private ContextMenu popupMenu() {

		final ContextMenu contextMenu = new ContextMenu();
		MenuItem info = new MenuItem("Info");
		
		info.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Info...");
			}
		});
		
		contextMenu.getItems().add(info);
		
		
		MenuItem upgrade = new MenuItem("Upgrade");
		
		if (element.getNodeLevel().equals(Constants.MAX_NODE_LEVEL)) { 
			upgrade.setDisable(true);
		}
		
		upgrade.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Upgrade..");
		
				element.upgrade(5);				
			}
		});
		
		contextMenu.getItems().add(upgrade);
		
		
		MenuItem destroy = new MenuItem("Destroy");
			
		if (element.getNodeType().equals(ElementType.CORE)) { 
			destroy.setDisable(true);
			group = null;
		}
			
		destroy.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Destroy..");
				element.setNodeState(ElementState.DESTROYED);
			}
		});
			
		contextMenu.getItems().add(destroy);
		
		return contextMenu;
	}
	
	
	public ElementBox( final Element element) {
		
		this.element = element;
		
		Label label1 = new Label();
		label1.setText(""+element.getNodeType().toString().toLowerCase()) ;
		label1.setStyle("-fx-text-fill: \"white\";");
		label1.setLayoutX(element.getX()-18);
		label1.setLayoutY(element.getY()+20);
		
		levelLabel = new Label();
		levelLabel.setStyle("-fx-text-fill: \"white\";");
		levelLabel.setLayoutX(element.getX());
		levelLabel.setLayoutY(element.getY()-10);
				
		upgradeLabel = new Label();
		upgradeLabel.setStyle("-fx-text-fill: \"white\";");
		upgradeLabel.setLayoutX(element.getX()-18);
		upgradeLabel.setLayoutY(element.getY()+40);
		upgradeLabel.setVisible(false);
		
		material1 = new PhongMaterial();
		material1.setSpecularColor(Color.ORANGE);
		material1.setDiffuseColor(Color.ORANGE);
	    
	    material2 = new PhongMaterial();
	    material2.setSpecularColor(Color.ORANGE);
	    material2.setDiffuseColor(Color.RED);
	       
	    sphere = new Sphere(); 
	    sphere.setRadius(20.0);   
	    sphere.setTranslateX(element.getX()); 
	    sphere.setTranslateY(element.getY());         
	    sphere.setMaterial(material1);
	    	    
	    group = new Group(sphere, label1, levelLabel, upgradeLabel);
	   
	    Iterator <Element> iter1 = element.getNodes().iterator();	   
		while (iter1.hasNext()) {
			Element element1 = iter1.next();								
			Cylinder cylinder = createConnection(new Point3D(element.getX(),element.getY(),1), new Point3D(element1.getX(),element1.getY(),1));
			group.getChildren().add(cylinder);
		}
			
	    sphere.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {
			 
            public void handle(ContextMenuEvent event) {
            	popupMenu().show(sphere, event.getScreenX(), event.getScreenY());            		
            }
        });
		
	    group.setOnMouseEntered(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	sphere.setMaterial(material2);    
		    }
	    });
		
	    group.setOnMouseExited(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	sphere.setMaterial(material1);    	    
		    }
	    });
	    
	    AnimationTimer timer = new AnimationTimer() {			 
		 	
			@Override
			public void handle(long now) {
	            	
				levelLabel.setText(""+element.getNodeLevel().getLevelCode());
				
				switch (element.getNodeState()) {
				
					case UPGRADED:
							String time = getDiff(element.getUpgradeDate());
							if (time!=null) {
								
								upgradeLabel.setVisible(true);
								upgradeLabel.setText(time);
								
							} else {
								
								upgradeLabel.setVisible(false);
								element.setNodeState(ElementState.IDLE);
								element.setLevel(ElementLevelUtils.upgrade(element.getNodeLevel()));
							}							
							break;
							
					case DESTROYED:						
						    break;
						    
					case IDLE:
							break;
							
					case NEW:
							break;
					default:
							break;					
				}
			}
		};
		
		timer.start();		
	}

	public Group getGroup() {
		return group;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(final Element element) {
		this.element = element;
	}
}
