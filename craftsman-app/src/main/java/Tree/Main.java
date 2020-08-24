package Tree;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuchang
 * @date 2020/8/25 1:10
 */
public class Main {
    public static void main(String[] args) {
        TreeNode p = new TreeNode();
        p.setNodeId("p1");
        p.setNodePid(null);
        TreeNode c1 = new TreeNode();
        c1.setNodePid("p1");
        c1.setNodeId("c1");
        List<TreeNode> list = new ArrayList<>();
        list.add(p);
        list.add(c1);
        TreeNode node = TreeUtil.buildTree(list, t -> {
            return t.getPid() == null;
        });
        System.out.println(JSONObject.toJSONString(node));
    }
}
