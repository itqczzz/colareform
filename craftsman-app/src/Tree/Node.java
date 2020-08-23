package com.example.java8.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuchang
 * @date 2020/8/23 0:14
 */
public class Node {
    @TreeInfo(field = TreeField.ID)
    private Integer id;
    @TreeInfo(field = TreeField.PID)
    private Integer pid;
    @TreeInfo(field = TreeField.LEVEL,clazz = Integer.class)
    private Integer level;
    private String name;
    @TreeInfo(field = TreeField.SUB)
    private List<Node> sub = new ArrayList<>();
    public Node(int id, int pid) {
        this.id = id;
        this.pid = pid;
    }

    public Node(int id, int pid, String name) {
        this(id, pid);
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Node> getSub() {
        return sub;
    }

    public void setSub(List<Node> sub) {
        this.sub = sub;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
