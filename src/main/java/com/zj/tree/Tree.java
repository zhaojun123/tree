package com.zj.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的抽象
 */
public abstract class Tree{

    private List<Tree> childrenList = new ArrayList<>();

    /**
     * 获取树节点id
     * @return
     */
    abstract Object getTreeId();

    /**
     * 获取树父节点id
     * @return
     */
    abstract Object getTreeParentId();

    /**
     * 该节点的子节点集合
     * @return
     */
    public List<Tree> getTreeChildrenList(){
        return childrenList;
    }

    /**
     * 判断是否是根节点，默认TreeParentId为null即为根节点，子类可以覆盖该逻辑
     * @return
     */
    protected boolean topParentId(){
        return getTreeParentId() == null;
    }
}
