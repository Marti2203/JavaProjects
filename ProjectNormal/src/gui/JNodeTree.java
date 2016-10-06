package gui;

import javax.swing.JFrame;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class JNodeTree
{
	public static void main(String[] args)
	{
		MutableTreeNode root = new DefaultMutableTreeNode("Root node");
		MutableTreeNode group = new DefaultMutableTreeNode("Group");
		root.insert(group, 0);
		root.insert(new DefaultMutableTreeNode("Node 1"), 1);
		group.insert(new DefaultMutableTreeNode("Node 2"), 0);
		group.insert(new DefaultMutableTreeNode("Node 3"), 1);
		TreeModel model = new DefaultTreeModel(root);
		JTree tree = new JTree(model);
		tree.addTreeSelectionListener(new TreeSelectionListener()
		{

			public void valueChanged(TreeSelectionEvent e)
			{
				TreePath tp = e.getNewLeadSelectionPath();
				System.out.println(tp.getLastPathComponent());
			}
		});
		JFrame frame = new JFrame();
		frame.add(tree);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}
