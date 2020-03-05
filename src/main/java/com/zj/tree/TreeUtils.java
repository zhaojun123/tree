package com.zj.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * 构建树的工具类
 */
public class TreeUtils {

    public static <T>List<T> tree(List<T> treeList){
        return tree(treeList,null);
    }

    /**
     * 在组装树的过程中，调用Consumer函数执行自定义的业务逻辑
     * @param treeList
     * @param afterAddChildren
     * @param <T>
     * @return
     */
    public static <T> List<T> tree(List<T> treeList, Consumer<Tree> afterAddChildren){
        List<T> resultList = new ArrayList();
        for(Object object: treeList){
            Tree tree = (Tree)object;
            if(tree.topParentId()){
                resultList.add((T)tree);
                treeRecursion(tree,(List<Tree>)treeList,afterAddChildren);
            }
        }
        return resultList;
    }

    /**
     * 递归方法组装树
     * @param nodeTree
     * @param treeList
     * @param afterAddChildren
     */
    private static void treeRecursion(Tree nodeTree,List<Tree> treeList,Consumer<Tree> afterAddChildren){
        for(Tree tree:treeList){
            if(nodeTree.getTreeId().equals(tree.getTreeParentId())){
                nodeTree.getTreeChildrenList().add(tree);
                treeRecursion(tree,treeList,afterAddChildren);
            }
        }
        if(afterAddChildren!=null)
            afterAddChildren.accept(nodeTree);
    }

}
