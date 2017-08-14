package nl.plaatsoft.cyber.model;

public class Library {

	private ElementType nodeType;
	private ElementLevel level;
	private int strength;
	private int price;
	private int buildTime;
	
	public Library(ElementType nodeType, ElementLevel level, int strength, int price, int buildTime) {
		super();
		this.nodeType = nodeType;
		this.level = level;
		this.strength = strength;
		this.price = price;
		this.buildTime = buildTime;
	}
	
	public ElementType getNodeType() {
		return nodeType;
	}
	
	public void setNodeType(ElementType nodeType) {
		this.nodeType = nodeType;
	}
	
	public ElementLevel getLevel() {
		return level;
	}
	
	public void setLevel(ElementLevel level) {
		this.level = level;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public void setStrength(int strength) {
		this.strength = strength;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getBuildTime() {
		return buildTime;
	}
	
	public void setBuildTime(int buildTime) {
		this.buildTime = buildTime;
	}
	
}
