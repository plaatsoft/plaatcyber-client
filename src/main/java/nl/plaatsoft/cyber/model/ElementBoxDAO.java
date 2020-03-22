package nl.plaatsoft.cyber.model;

import java.util.ArrayList;
import java.util.Iterator;

import nl.plaatsoft.cyber.ui.ElementBox;

public class ElementBoxDAO {
	
	private ArrayList <ElementBox> nodes = new ArrayList<ElementBox>();
	
	public void add(ElementBox node) {
		
		nodes.add(node);
	}
	
	public void remove(ElementBox node) {
		
		nodes.remove(node);
	}
	
	public ArrayList <ElementBox> getNodes() {
		return nodes;
	}
				
	public ElementBox find(ElementType nodeType) {
		
		Iterator<ElementBox> iter = nodes.iterator();
		while (iter.hasNext()) {
			ElementBox node = iter.next();
			if (node.getElement().getNodeType().equals(nodeType)) {
				return node;
			}
		}
		return null;		
	}
}
