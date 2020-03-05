package com.zj.tree;

/**
 * 部门模型
 */
public class DeptTree extends Tree{

    public DeptTree(String deptId,String parentDeptId,String organId,String deptName){
        this.deptId = deptId;
        this.parentDeptId = parentDeptId;
        this.organId = organId;
        this.deptName = deptName;
    }

    private String deptId;

    private String parentDeptId;

    private String organId;

    private String deptName;

    /**
     * 这里需要将业务字段 和 树的关系字段绑定，确定id 和 parentId
     * @return
     */
    @Override
    public Object getTreeId() {
        return deptId;
    }

    @Override
    public Object getTreeParentId() {
        return parentDeptId;
    }

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getParentDeptId() {
        return parentDeptId;
    }

    public void setParentDeptId(String parentDeptId) {
        this.parentDeptId = parentDeptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
