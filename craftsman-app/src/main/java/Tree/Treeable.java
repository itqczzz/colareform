package Tree;

import java.util.List;

/**
 * @author qiuchang
 * @date 2020/8/25 1:00
 */
public abstract class Treeable<T> {
    List<Treeable> subs;

    public List<Treeable> getSubs() {
        return subs;
    }

    public void setSubs(List<Treeable> subs) {
        this.subs = subs;
    }

    /**
     * 获取树节点 id
     * @return 树节点 id
     */
    abstract T getId();

    /**
     * 获取树节点父节点 id
     * @return 父节点 id
     */
    abstract T getPid();

    /**
     * 获取子节点
     * @return 孩子节点
     */
    List<Treeable> getChildren(){
        return subs;
    };

    /**
     * 设置子节点信息
     * @param children 子节点信息
     */
    void setChildren(List<Treeable> children){
        subs = children;
    };
}