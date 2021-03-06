package Tree;

import org.springframework.lang.NonNull;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author qiuchang
 * @date 2020/8/25 1:00
 */
public final class TreeUtil {
    private TreeUtil() {
    }

    /**
     * 构建树形结构，并返回根节点
     * <p>通过 id 和 pid 构建树，若 id 有重复可能会造成相同id对象只有一个有子节点的情况，请自行去重</p>
     * <p>传入一个 Predicate 对想来判别跟节点，若节点满足此条件，则设置为根节点。如果多个节点满足，则只取一个。</p>
     *
     * @param vos       所有节点数据
     * @param predicate 判别式，为true则为根节点
     * @return 根节点
     */
    public static <T extends Treeable> T buildTree(List<T> vos, @NonNull Predicate<T> predicate) {
        List<T> maybeRoots = constructTree(vos);
        for (T vo : maybeRoots) {
            if (predicate.test(vo)) {
                return vo;
            }
        }
        return null;
    }

    /**
     * 构建树形结构，并返回所有根节点
     * <p>传入一个 Predicate 对想来判别根节点，若节点满足此条件，则设置为根节点。</p>
     *
     * @param vos       所有节点数据
     * @param predicate 判别式，为true则为根节点
     * @return 所有根节点
     */
    public static <T extends Treeable> List<T> buildTreeForList(List<T> vos, @NonNull Predicate<T> predicate) {
        List<T> maybeRoots = constructTree(vos);
        // 从疑似父节点中查找真正的父节点
        List<T> roots = new ArrayList<>();
        for (T vo : maybeRoots) {
            if (predicate.test(vo)) {
                roots.add(vo);
            }
        }
        return roots;
    }

    /**
     * 构建树形结构，并返回根节点
     *
     * @param vos 所有节点数据
     * @param id  指定根节点的id，不可为null
     * @return 根节点
     */
    public static <T extends Treeable> T buildTreeOfRootId(List<T> vos, String id) {
        if (null == id) {
            throw new IllegalArgumentException("构建树失败！根节点id不能为空！");
        }
        return buildTree(vos, vo -> id.equals(vo.getId()));
    }

    /**
     * 构建树形结构，并返回根节点
     *
     * @param vos 所有节点数据
     * @param pid 指定根节点的父id， 可为 null
     * @return 根节点
     */
    public static <T extends Treeable> T buildTreeOfRootPId(List<T> vos, String pid) {
        return buildTree(vos, vo -> Objects.equals(vo.getPid(), pid));
    }

    /**
     * 构建树形结构，并返回所有根节点
     *
     * @param vos 所有节点数据
     * @param pid 指定根节点的父id， 可为 null
     * @return 所有根节点
     */
    public static <T extends Treeable> List<T> buildTreeOfRootPIdForList(List<T> vos, String pid) {
        return buildTreeForList(vos, vo -> Objects.equals(vo.getPid(), pid));
    }

    /**
     * 计算树上有多少个节点
     * @param trees 数结构
     * @return 节点数量
     */
    public static <T extends Treeable> int countNodes(List<T> trees) {
        if (null == trees || trees.isEmpty()) {
            return 0;
        }
        Queue<Treeable> queue = new LinkedList<>(trees);
        int count = 0;
        while (!queue.isEmpty()) {
            Treeable current = queue.poll();
            count++;

            List<Treeable> children;
            if (null == current || null == current.getChildren()) {
                children = Collections.emptyList();
            } else {
                children = current.getChildren();
            }
            if (!children.isEmpty()) {
                queue.addAll(children);
            }
        }
        return count;
    }


    /**
     * 构造树核心方法
     * @param vos 树节点对象集合
     * @param <T> 树节点
     * @return 返回无父节点的节点
     */
    private static <T extends Treeable> List<T> constructTree(List<T> vos) {
        if (null == vos || vos.isEmpty()) {
            return Collections.emptyList();
        }
        List<T> maybeRoots = new ArrayList<>();
        Map<Object, List<T>> temp = vos.stream().filter(t -> {
            return t.getId() != null;
        }).filter(t->{
            boolean flag = true;
            if(t.getPid() == null){
                maybeRoots.add(t);
                flag = false;
            }
            return flag;
        }).collect(Collectors.groupingBy(Treeable::getPid));
        // 构造树
        vos.stream().forEach(t->{
            if(temp.get(t.getId()) == null){
                return;
            }
            t.setChildren(temp.get(t.getId()));
        });
        return maybeRoots;
    }
}