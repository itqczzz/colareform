package com.example.java8.tree2.tree.service;


import com.example.java8.tree2.tree.domain.FayTreeNode;

import java.util.List;

public interface IFayTree {
	List<FayTreeNode> getTree();
    List<FayTreeNode> getRoot();
    FayTreeNode getFayTreeNode(String nodeId);
}
