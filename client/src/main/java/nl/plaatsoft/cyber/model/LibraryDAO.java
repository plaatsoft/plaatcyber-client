package nl.plaatsoft.cyber.model;

import java.util.ArrayList;
import java.util.Iterator;

public class LibraryDAO {

	private ArrayList <Library> library = new ArrayList<Library>();
	
	public void add(Library node) {
		
		library.add(node);
	}
		
	public ArrayList <Library> getLibrary() {
		return library;
	}
			
	public Library find(ElementType nodeType, ElementLevel nodeLevel) {
		
		Iterator<Library> iter = this.library.iterator();
		while (iter.hasNext()) {
		
			Library library = iter.next();
			if (library.getNodeType().equals(nodeType) && library.getLevel().equals(nodeLevel)) {
				return library;
			}
		}
		return null;		
	}
	
	public void init() {
				
		/* LEVEL ONE */
		add( new Library(ElementType.CORE, ElementLevel.ONE, 50, 100, 60));	
			
		add( new Library(ElementType.ACCESS_POINT, ElementLevel.ONE, 50, 20, 10));	
		add( new Library(ElementType.WEB_SERVER, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.WEB_DATABASE, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.COIN_SERVER, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.COIN_DATABASE, ElementLevel.ONE, 50, 20, 10));
				
		add( new Library(ElementType.FIREWALL, ElementLevel.ONE, 50, 20, 10));	
		add( new Library(ElementType.VIRUS_SCANNER, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.EMAIL_SCANNER, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.MALLWARE_SCANNER, ElementLevel.ONE, 50, 20, 10));
		
		add( new Library(ElementType.COMPILER, ElementLevel.ONE, 50, 20, 10));	
		add( new Library(ElementType.EVOLVER, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.LIBRARY, ElementLevel.ONE, 50, 20, 10));
		
		add( new Library(ElementType.ONE_DAY_PROTECTION, ElementLevel.ONE, 50, 20, 10));	
		add( new Library(ElementType.TWO_DAY_PROTECTION, ElementLevel.ONE, 50, 20, 10));
		add( new Library(ElementType.SEVEN_DAY_PROTECTION, ElementLevel.ONE, 50, 20, 10));
		
		/* LEVEL TWO */
		add( new Library(ElementType.CORE, ElementLevel.TWO, 50, 100, 60));	
			
		add( new Library(ElementType.ACCESS_POINT, ElementLevel.TWO, 50, 20, 10));	
		add( new Library(ElementType.WEB_SERVER, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.WEB_DATABASE, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.COIN_SERVER, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.COIN_DATABASE, ElementLevel.TWO, 50, 20, 10));
				
		add( new Library(ElementType.FIREWALL, ElementLevel.TWO, 50, 20, 10));	
		add( new Library(ElementType.VIRUS_SCANNER, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.EMAIL_SCANNER, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.MALLWARE_SCANNER, ElementLevel.TWO, 50, 20, 10));
		
		add( new Library(ElementType.COMPILER, ElementLevel.TWO, 50, 20, 10));	
		add( new Library(ElementType.EVOLVER, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.LIBRARY, ElementLevel.TWO, 50, 20, 10));
		
		add( new Library(ElementType.ONE_DAY_PROTECTION, ElementLevel.TWO, 50, 20, 10));	
		add( new Library(ElementType.TWO_DAY_PROTECTION, ElementLevel.TWO, 50, 20, 10));
		add( new Library(ElementType.SEVEN_DAY_PROTECTION, ElementLevel.TWO, 50, 20, 10));	
		
		/* LEVEL THREE */
		add( new Library(ElementType.CORE, ElementLevel.THREE, 50, 100, 60));	
			
		add( new Library(ElementType.ACCESS_POINT, ElementLevel.THREE, 50, 20, 10));	
		add( new Library(ElementType.WEB_SERVER, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.WEB_DATABASE, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.COIN_SERVER, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.COIN_DATABASE, ElementLevel.THREE, 50, 20, 10));
				
		add( new Library(ElementType.FIREWALL, ElementLevel.THREE, 50, 20, 10));	
		add( new Library(ElementType.VIRUS_SCANNER, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.EMAIL_SCANNER, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.MALLWARE_SCANNER, ElementLevel.THREE, 50, 20, 10));
		
		add( new Library(ElementType.COMPILER, ElementLevel.THREE, 50, 20, 10));	
		add( new Library(ElementType.EVOLVER, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.LIBRARY, ElementLevel.THREE, 50, 20, 10));
		
		add( new Library(ElementType.ONE_DAY_PROTECTION, ElementLevel.THREE, 50, 20, 10));	
		add( new Library(ElementType.TWO_DAY_PROTECTION, ElementLevel.THREE, 50, 20, 10));
		add( new Library(ElementType.SEVEN_DAY_PROTECTION, ElementLevel.THREE, 50, 20, 10));	
		
		/* LEVEL FOUR */
		add( new Library(ElementType.CORE, ElementLevel.FOUR, 50, 100, 60));	
			
		add( new Library(ElementType.ACCESS_POINT, ElementLevel.FOUR, 50, 20, 10));	
		add( new Library(ElementType.WEB_SERVER, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.WEB_DATABASE, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.COIN_SERVER, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.COIN_DATABASE, ElementLevel.FOUR, 50, 20, 10));
				
		add( new Library(ElementType.FIREWALL, ElementLevel.FOUR, 50, 20, 10));	
		add( new Library(ElementType.VIRUS_SCANNER, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.EMAIL_SCANNER, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.MALLWARE_SCANNER, ElementLevel.FOUR, 50, 20, 10));
		
		add( new Library(ElementType.COMPILER, ElementLevel.FOUR, 50, 20, 10));	
		add( new Library(ElementType.EVOLVER, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.LIBRARY, ElementLevel.FOUR, 50, 20, 10));
		
		add( new Library(ElementType.ONE_DAY_PROTECTION, ElementLevel.FOUR, 50, 20, 10));	
		add( new Library(ElementType.TWO_DAY_PROTECTION, ElementLevel.FOUR, 50, 20, 10));
		add( new Library(ElementType.SEVEN_DAY_PROTECTION, ElementLevel.FOUR, 50, 20, 10));	
		
		/* LEVEL FIVE */
		add( new Library(ElementType.CORE, ElementLevel.FIVE, 50, 100, 60));	
			
		add( new Library(ElementType.ACCESS_POINT, ElementLevel.FIVE, 50, 20, 10));	
		add( new Library(ElementType.WEB_SERVER, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.WEB_DATABASE, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.COIN_SERVER, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.COIN_DATABASE, ElementLevel.FIVE, 50, 20, 10));
				
		add( new Library(ElementType.FIREWALL, ElementLevel.FIVE, 50, 20, 10));	
		add( new Library(ElementType.VIRUS_SCANNER, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.EMAIL_SCANNER, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.MALLWARE_SCANNER, ElementLevel.FIVE, 50, 20, 10));
		
		add( new Library(ElementType.COMPILER, ElementLevel.FIVE, 50, 20, 10));	
		add( new Library(ElementType.EVOLVER, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.LIBRARY, ElementLevel.FIVE, 50, 20, 10));
		
		add( new Library(ElementType.ONE_DAY_PROTECTION, ElementLevel.FIVE, 50, 20, 10));	
		add( new Library(ElementType.TWO_DAY_PROTECTION, ElementLevel.FIVE, 50, 20, 10));
		add( new Library(ElementType.SEVEN_DAY_PROTECTION, ElementLevel.FIVE, 50, 20, 10));
	}
}
