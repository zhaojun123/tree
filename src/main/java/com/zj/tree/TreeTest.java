package com.zj.tree;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class TreeTest {

    public static void main(String[] args) {
        TreeTest treeTest = new TreeTest();
        List<OrganTree> organList = treeTest.getOrganList();
        List<OrganTree> resultList = TreeUtils.tree(organList
                ,(tree -> {
                        //如果树节点是单位，则继续查下面的部门
                        if(tree instanceof OrganTree){
                            OrganTree organTree = (OrganTree)tree;
                            List<DeptTree> deptTreeList
                                    = treeTest.getDeptByOrgan(organTree.getOrganId());
                            //把部门加入单位的子节点中，继续构造部门树
                            tree.getTreeChildrenList().addAll(TreeUtils.tree(deptTreeList));
                        }
                    }
                )
        );
        System.out.println(new Gson().toJson(resultList));
    }

    /**
     * 模拟数据库查询获取所有公司的列表
     * @return
     */
    public List<OrganTree> getOrganList(){
        List<OrganTree> list = new ArrayList<>();
        list.add(new OrganTree("1",null,"中科美络"));
        list.add(new OrganTree("2",null,"移动互联"));
        list.add(new OrganTree("3","1","中科子公司1"));
        list.add(new OrganTree("4","1","中科子公司2"));
        return list;
    }

    /**
     * 模拟数据库查询 中科美络 和 子公司2下面的部门
     * @param organId
     * @return
     */
    public List<DeptTree> getDeptByOrgan(String organId){
        List<DeptTree> list = new ArrayList<>();
        if(organId.equals("4")){
            list.add(new DeptTree("1",null,"1","总经办"));
            list.add(new DeptTree("2","1","1","人事"));
            list.add(new DeptTree("3","1","1","财务"));
            list.add(new DeptTree("4","2","1","开发"));
        }
        if(organId.equals("1")){
            list.add(new DeptTree("1",null,"1","总经办"));
        }
        return list;
    }

}
