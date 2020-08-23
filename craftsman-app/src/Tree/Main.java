package com.example.java8.Tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuchang
 * @date 2020/8/23 0:15
 */

public class Main {
        public static void main(String[] args) {
            TreeUtils.build(Node.class).buildTree()
            Node dennis = new Node(1, 0, "dennis");
            Node calm = new Node(2, 0, "calm");
            Node daughter = new Node(3, 1, "daughter");
            Node daughter1 = new Node(9, 1, "daughter2");
            Node grandson = new Node(4, 3, "grandson");
            Node son = new Node(5, 2, "son");
            List<Node> nodes = new ArrayList();
            nodes.add(dennis);
            nodes.add(calm);
            nodes.add(daughter);
            nodes.add(grandson);
            nodes.add(son);
            nodes.add(daughter1);
//            List<Node> tree = TreeComponent.buildTree(nodes);
//            System.out.println(JSONObject.toJSONString(tree));
        }
}

