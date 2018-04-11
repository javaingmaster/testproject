import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;


public class tree implements TreeModelListener 
{
	JLabel l1;
	String nodename=null;
	public void test()
	{
		JFrame jf=new JFrame("test");
		Container cp=jf.getContentPane();
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("buy");
		DefaultMutableTreeNode node1=new DefaultMutableTreeNode("fruit");
		DefaultMutableTreeNode node2=new DefaultMutableTreeNode("clothes");
		DefaultMutableTreeNode node3=new DefaultMutableTreeNode("ball");
		DefaultMutableTreeNode node4=new DefaultMutableTreeNode("game");
		root.add(node1);
		root.add(node2);
		root.add(node3);
		root.add(node4);
		DefaultMutableTreeNode leafnode=new DefaultMutableTreeNode("apple");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("banana");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("orange");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("pear");
		node1.add(leafnode);
		leafnode=new DefaultMutableTreeNode("jeans");
		node2.add(leafnode);
		leafnode=new DefaultMutableTreeNode("sweater");
		node2.add(leafnode);
		leafnode=new DefaultMutableTreeNode("basetball");
		node3.add(leafnode);
		leafnode=new DefaultMutableTreeNode("bowling");
		node3.add(leafnode);
		leafnode=new DefaultMutableTreeNode("lol");
		node4.add(leafnode);
		leafnode=new DefaultMutableTreeNode("ava");
		node4.add(leafnode);
		JTree tree=new JTree(root);
	    tree.setEditable(true);
	    tree.addMouseListener(new MouseHandle());
	    DefaultTreeModel treemodel=( DefaultTreeModel)tree.getModel();
	    treemodel.addTreeModelListener(this);
	    JScrollPane sp=new JScrollPane();
	    sp.setViewportView(tree);
	    l1=new JLabel("更改数据为:");
	    cp.add(sp,BorderLayout.CENTER);
	    cp.add(l1,BorderLayout.SOUTH);
	    jf.pack();
	    jf.setVisible(true);
	    jf.addWindowListener(new WindowAdapter()
	    {
	    	public void windowClosing(WindowEvent e)
	    	{
	    		System.exit(0);
	    	}
	    });
	}
	public void treeNodesChanged(TreeModelEvent e)
	{
		TreePath treepath=e.getTreePath();
		DefaultMutableTreeNode node=(DefaultMutableTreeNode)treepath.getLastPathComponent();
		try{
			int[] index=e.getChildIndices();
			node=(DefaultMutableTreeNode)node.getChildAt(index[0]);
		}catch(NullPointerException exc){}
		l1.setText(nodename+"change to"+(String)node.getUserObject());
	}
	public void treeNodesInserted(TreeModelEvent e){}
	public void treeNodesRemoved(TreeModelEvent e){}
	public void treeStructureChanged(TreeModelEvent e){}
	public static void main(String[] args)
	{
		new tree().test();;
	}
	class MouseHandle extends MouseAdapter
	{
		public void mousePressed(MouseEvent e)
		{
			try{
				JTree tree=(JTree)e.getSource();
				int rowLocation=tree.getRowForLocation(e.getX(), e.getY());
				TreePath treepath=tree.getPathForRow(rowLocation);
				TreeNode treenode=(TreeNode)treepath.getLastPathComponent();
				nodename=treenode.toString();
			}catch(NullPointerException ne){}
			}
	}
	}
