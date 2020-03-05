package com.zj.tree;

/**
 * 单位模型
 */
public class OrganTree extends Tree{

    public OrganTree(String organId,String parentOrganId,String organName){
        this.organId = organId;
        this.parentOrganId = parentOrganId;
        this.organName = organName;
    }

    /**
     * 这里需要将业务字段 和 树的关系字段绑定，确定id 和 parentId
     * @return
     */
    @Override
    public Object getTreeId() {
        return organId;
    }

    @Override
    public Object getTreeParentId() {
        return parentOrganId;
    }

    private String organId;

    private String parentOrganId;

    private String organName;

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId;
    }

    public String getParentOrganId() {
        return parentOrganId;
    }

    public void setParentOrganId(String parentOrganId) {
        this.parentOrganId = parentOrganId;
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName;
    }
}
