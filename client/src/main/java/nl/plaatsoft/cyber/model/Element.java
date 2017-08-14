package nl.plaatsoft.cyber.model;

import java.util.ArrayList;
import java.util.Date;

public class Element {
	
	private int x;
	private int y;	
	private ElementLevel nodeLevel;
	private ElementType nodeType;
    private ElementState nodeState;    
    private ArrayList <Element> nodes = new ArrayList<Element>();
    private int timer;
    private int threads;
    private Date upgradeDate;
			
    public Element(int x, int y, ElementType nodeType,  ArrayList<Element> nodes) {
		
		this.x = x;
		this.y = y;
		this.nodeLevel = ElementLevel.ONE;		
		this.nodeState = ElementState.NEW; 
		this.nodeType = nodeType; 
		this.nodes = nodes;
		this.upgradeDate = new Date();
	}

	public boolean upgrade(int upgradeDelay) {
						
		ElementLevel nodeLevel2 = ElementLevelUtils.upgrade(nodeLevel);
		
		/* Max Level reached */
		if (nodeLevel2.equals(nodeLevel)) {
			return false;
		}
		
		/* Upgrade if there is money */
		if (Factory.getLibraryDAO().find(nodeType, nodeLevel2).getPrice()<=Factory.getSettings().getMoney()) {
			Factory.getSettings().setMoney(Factory.getSettings().getMoney()-Factory.getLibraryDAO().find(nodeType, nodeLevel2).getPrice());
			
			setUpgradeDate(new Date(new Date().getTime()+(upgradeDelay*1000)));
			nodeState = ElementState.UPGRADED;
			
			return true;
		}
		
		return false;
	}
	
	public ElementType getNodeType() {
		return nodeType;
	}
	
	public void setNodeType(ElementType nodeType) {
		this.nodeType = nodeType;
	}
	
	public ElementLevel getNodeLevel() {
		return nodeLevel;
	}
	
	public void setLevel(ElementLevel nodeLevel) {
		this.nodeLevel = nodeLevel;
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
		
	public ElementState getNodeState() {
		return nodeState;
	}

	public void setNodeState(ElementState nodeState) {
		this.nodeState = nodeState;
	}
	
	public ArrayList <Element> getNodes() {
		return nodes;
	}
	
	public void setNodes(ArrayList <Element> nodes) {
		this.nodes = nodes;
	}

	public int getThreads() {
		return threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	public Date getUpgradeDate() {
		return upgradeDate;
	}

	public void setUpgradeDate(Date upgradeDate) {
		this.upgradeDate = upgradeDate;
	}
}
