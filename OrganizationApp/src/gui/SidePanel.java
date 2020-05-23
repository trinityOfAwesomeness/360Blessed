package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import model.Data;

/**
 * Class to Side Panel for GUI.
 * @author Seoungdeok Jeon
 *
 */
public class SidePanel extends JPanel {

	private List<Data> myDataList;
	private JTree myTree;
	
	/**
	 * Constructor for SidePanel object.
	 */
	public SidePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		setBorder(BorderFactory.createLineBorder(Color.black));
		setLayout(new BorderLayout());
		
//		//create the root node
//		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("Root");
//		myTree = new JTree(rootNode);
//        myTree.setShowsRootHandles(true);
//        add(new JScrollPane(myTree), BorderLayout.CENTER);
	}
	
	public void setData(List<Data> theDataList) {
		this.myDataList = theDataList;
	}
	
	public void update() {
//		removeAll();
//			
//	        //create the child nodes
//	        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
//	        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
//	        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
//	        vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
//	        vegetableNode.add(new DefaultMutableTreeNode("Potato"));
//	        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
//	        fruitNode.add(new DefaultMutableTreeNode("Banana"));
//	        fruitNode.add(new DefaultMutableTreeNode("Mango"));
//	        fruitNode.add(new DefaultMutableTreeNode("Apple"));
//	        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
//	        fruitNode.add(new DefaultMutableTreeNode("Orange"));
//	        //add the child nodes to the root node
////	        myRootNode.add(vegetableNode);
////	        myRootNode.add(fruitNode);
//	        //create the tree by passing in the root node
//	       // myTree = new JTree(root);
//		//}
//	        DefaultTreeModel model = (DefaultTreeModel) myTree.getModel();
//	        DefaultMutableTreeNode root = (DefaultMutableTreeNode)model.getRoot();
//	        System.out.println(root);
//	       // root.add(new DefaultMutableTreeNode("another_child"));
//	        root.add(vegetableNode);
//	        root.add(fruitNode);
//	        model.nodeChanged(root);
//        validate();
	}
}
