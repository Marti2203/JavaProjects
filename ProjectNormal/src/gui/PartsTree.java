package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

public class PartsTree
{
	public static void main(String[] args)
	{
		// create a hierarchy of nodes
		MutableTreeNode root = new DefaultMutableTreeNode("Parts");
		MutableTreeNode beams = new DefaultMutableTreeNode("Beams");
		MutableTreeNode gears = new DefaultMutableTreeNode("Gears");
		root.insert(beams, 0);
		root.insert(gears, 1);
		beams.insert(new DefaultMutableTreeNode("1x4 black"), 0);
		beams.insert(new DefaultMutableTreeNode("1x6 black"), 1);
		beams.insert(new DefaultMutableTreeNode("1x8 black"), 2);
		beams.insert(new DefaultMutableTreeNode("1x12 black"), 3);
		gears.insert(new DefaultMutableTreeNode("8t"), 0);
		gears.insert(new DefaultMutableTreeNode("24t"), 1);
		gears.insert(new DefaultMutableTreeNode("40t"), 2);
		gears.insert(new DefaultMutableTreeNode("worm"), 3);
		gears.insert(new DefaultMutableTreeNode("crown"), 4);
		// create the JTree
		final DefaultTreeModel model = new DefaultTreeModel(root);
		final JTree tree = new JTree(model);
		// create a text field and button to modify the data model
		final JTextField nameField = new JTextField("16t");
		final JButton buttonAdd = new JButton("Add a part");
		buttonAdd.setEnabled(false);
		buttonAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				TreePath tp = tree.getSelectionPath();
				MutableTreeNode insertNode = (MutableTreeNode) tp.getLastPathComponent();
				int insertIndex = 0;
				if (insertNode.getParent() != null)
				{
					MutableTreeNode parent = (MutableTreeNode) insertNode.getParent();
					insertIndex = parent.getIndex(insertNode) + 1;
					insertNode = parent;
				}
				MutableTreeNode node = new DefaultMutableTreeNode(nameField.getText());
				model.insertNodeInto(node, insertNode, insertIndex);
			}
		});
		final JButton buttonRemove = new JButton("Remove selected part");
		buttonRemove.setEnabled(false);
		buttonRemove.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				TreePath tp = tree.getSelectionPath();
				MutableTreeNode node = (MutableTreeNode) tp.getLastPathComponent();
				if (node.getParent() == null) return;
				model.removeNodeFromParent(node);
			}
		});
		JPanel addPanel = new JPanel(new GridLayout(2, 1));
		addPanel.add(nameField);
		JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
		buttonPanel.add(buttonAdd);
		buttonPanel.add(buttonRemove);
		addPanel.add(buttonPanel);

		// listen for selections
		tree.addTreeSelectionListener(new TreeSelectionListener()
		{
			public void valueChanged(TreeSelectionEvent e)
			{
				TreePath tp = e.getNewLeadSelectionPath();
				buttonAdd.setEnabled(tp != null);
				buttonRemove.setEnabled(tp != null);
			}
		});
		// create a JFrame to hold the tree
		JFrame frame = new JFrame("PartsTree v1.0");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(tree));
		frame.add(addPanel, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
}