package org.example.service;

import org.example.model.MyTreeModel;
import org.example.model.MyTreeNode;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;

public class MyTree extends JFrame
{
    private JTree myTree = null;
    private DefaultTreeModel model = null;
    public void createDefaultTree()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        //We create the tree model
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode child = new DefaultMutableTreeNode("child");
        DefaultMutableTreeNode subChild = new DefaultMutableTreeNode("subChild");
        child.add(subChild);
        root.add(child);
        this.model = new DefaultTreeModel(root);
        this.myTree = new JTree(this.model);
        this.myTree.setShowsRootHandles(true); //Thanks to this option we will see the handler for root
        this.myTree.setEditable(true); //We can modify our nodes
        //We add the tree to panel and show it
        add(new JScrollPane(this.myTree), BorderLayout.CENTER);
        JButton addChild = new JButton("Dodaj element podrzędny");
        addChild.addActionListener(event ->{
            addChildElement();
        });
        JButton addSiblings = new JButton("Dodaj element równorzędny");
        addSiblings.addActionListener(event ->{
            addSiblingElement();
        });
        JButton removeEle = new JButton("Usuń element");
        removeEle.addActionListener(event ->{
            removeElement();
        });
        JPanel panel = new JPanel();
        panel.add(new JScrollPane(addChild));
        panel.add(new JScrollPane(addSiblings));
        panel.add(new JScrollPane(removeEle));
        add(panel, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    private void addChildElement()
    {
        //We get the information about the current chosen node
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) this.myTree.getLastSelectedPathComponent();
        //We create completely new node
        DefaultMutableTreeNode completelyNewChild = new DefaultMutableTreeNode("NEW");
        //We change the model and update it - DefaultTreeModel has listener on it
        this.model.insertNodeInto(completelyNewChild, currentNode, currentNode.getChildCount());
    }
    private void addSiblingElement()
    {
        //We get the information about the current chosen node
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) this.myTree.getLastSelectedPathComponent();
        //We have to know who the parent is
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) currentNode.getParent();
        //We create completely new node
        DefaultMutableTreeNode completelyNewChild = new DefaultMutableTreeNode("NEW");
        //We change the model and update it - DefaultTreeModel has listener on it
        this.model.insertNodeInto(completelyNewChild, parent, currentNode.getChildCount());
    }
    private void removeElement()
    {
        //We get the information about the current chosen node
        DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) this.myTree.getLastSelectedPathComponent();
        //We delete the chosen node
        this.model.removeNodeFromParent(currentNode);
    }

}
