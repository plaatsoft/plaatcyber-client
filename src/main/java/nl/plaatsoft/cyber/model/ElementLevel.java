package nl.plaatsoft.cyber.model;

public enum ElementLevel {
   ONE (1),
   TWO (2),
   THREE (3),
   FOUR (4),
   FIVE (5);
	
	private final int levelCode;
	
	private ElementLevel(int levelCode) {
	  this.levelCode = levelCode;
	}
	
	public int getLevelCode() {
        return this.levelCode;
    }
}
