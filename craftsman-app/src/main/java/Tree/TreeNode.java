package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiuchang
 * @date 2020/8/25 1:02
 */
public class TreeNode extends Treeable<String>{

    private String nodeId;

    private String nodePid;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodePid() {
        return nodePid;
    }

    public void setNodePid(String nodePid) {
        this.nodePid = nodePid;
    }


    @Override
    public String getId() {
        return nodeId;
    }
    
    @Override
    public String getPid() {
        return nodePid;
    }

}
