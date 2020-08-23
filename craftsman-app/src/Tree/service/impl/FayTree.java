package com.example.java8.tree2.tree.service.impl;



import com.example.java8.tree2.tree.domain.FayTreeNode;
import com.example.java8.tree2.tree.service.IFayTree;
import com.example.java8.tree2.tree.service.IFayTreeNode;

import java.util.*;

public class FayTree implements IFayTree {
	private HashMap<String, FayTreeNode> treeNodesMap = new LinkedHashMap<String, FayTreeNode>();
    private List<FayTreeNode> treeNodesList = new ArrayList<FayTreeNode>();

    public FayTree(List<IFayTreeNode> list){
        initTreeNodeMap(list);
        initTreeNodeList();
    }

    private void initTreeNodeMap(List<IFayTreeNode> list){
    	FayTreeNode treeNode = null;
        for(IFayTreeNode item : list){
            treeNode = new FayTreeNode(item);
            treeNodesMap.put(treeNode.getNodeId(), treeNode);
        }

        Iterator<FayTreeNode> iter = treeNodesMap.values().iterator();
        FayTreeNode parentTreeNode = null;
        while(iter.hasNext()){
            treeNode = iter.next();
            if(treeNode.getParentNodeId() == null || treeNode.getParentNodeId() == ""){
                continue;
            }

            parentTreeNode = treeNodesMap.get(treeNode.getParentNodeId());
            if(parentTreeNode != null){
                treeNode.setParent(parentTreeNode);
                parentTreeNode.addChild(treeNode);
            }
        }
    }

    private void initTreeNodeList(){
        if(treeNodesList.size() > 0){
            return;
        }
        if(treeNodesMap.size() == 0){
            return;
        }
        Iterator<FayTreeNode> iter = treeNodesMap.values().iterator();
        FayTreeNode treeNode = null;
        while(iter.hasNext()){
            treeNode = iter.next();
            if(treeNode.getParent() == null){
                this.treeNodesList.add(treeNode);
                this.treeNodesList.addAll(treeNode.getAllChildren());
            }
        }
    }

    @Override
    public List<FayTreeNode> getTree() {
        return this.treeNodesList;
    }

    @Override
    public List<FayTreeNode> getRoot() {
        List<FayTreeNode> rootList = new ArrayList<FayTreeNode>();
        if (this.treeNodesList.size() > 0) {
            for (FayTreeNode node : treeNodesList) {
                if (node.getParent() == null) {
                    rootList.add(node);
                }
            }
        }
        return rootList;
    }

    @Override
    public FayTreeNode getFayTreeNode(String nodeId) {
        return this.treeNodesMap.get(nodeId);
    }
}
