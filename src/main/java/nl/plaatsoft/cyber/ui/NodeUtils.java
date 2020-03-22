package nl.plaatsoft.cyber.ui;

import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;

public class NodeUtils {

    public static <T extends Pane> List<Node> paneNodes(T parent) {
        return paneNodes(parent, new ArrayList<Node>());
    }

    private static <T extends Pane> List<Node> paneNodes(T parent, List<Node> nodes) {
        for (Node node : parent.getChildren()) {
            if (node instanceof Pane) {
                paneNodes((Pane) node, nodes);
            } else {
                nodes.add(node);
            }
        }

        return nodes;
    }
}