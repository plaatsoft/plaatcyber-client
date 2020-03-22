package nl.plaatsoft.cyber.model;

public class ElementLevelUtils {

	public static ElementLevel upgrade(ElementLevel nodeLevel) {
		 
		switch (nodeLevel) {
		
			case ONE: 
				return ElementLevel.TWO;
					  
			case TWO: 
				return ElementLevel.THREE;
			  		  
			case THREE: 
				return ElementLevel.FOUR;
			   	
			case FOUR: 
				return ElementLevel.FIVE;
				
			default:
				return ElementLevel.FIVE;			
		}
	}
	
}
