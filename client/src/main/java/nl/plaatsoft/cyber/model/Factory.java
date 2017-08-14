package nl.plaatsoft.cyber.model;

public class Factory {

	private static Settings settings = null;
	private static ElementBoxDAO elementBoxDAO = null;
	private static LibraryDAO libraryDAO = null;

	public static ElementBoxDAO getElementBoxDAO() {
		
		if (elementBoxDAO==null) {
			elementBoxDAO = new ElementBoxDAO();
		}
		return elementBoxDAO;
	}
	
	public static LibraryDAO getLibraryDAO() {
		
		if (libraryDAO==null) {
			libraryDAO = new LibraryDAO();
			libraryDAO.init();
		}
		return libraryDAO;
	}
		
	public static Settings getSettings() {
		
		if (settings==null) {
			settings = new Settings();
		}
		return settings;
	}
}
