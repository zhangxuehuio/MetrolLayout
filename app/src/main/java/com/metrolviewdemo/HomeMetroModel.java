package com.metrolviewdemo;


public class HomeMetroModel {
    /**
     * id : 8
     * name :
     * parentId : 0
     * imgUrl : Images/img01.png
     * bgColor :
     * actionLogo :
     * actionOrderNumber : 0
     * actionType : max
     * jumpToAction :
     */
    private int id;
    private String name;
    private int parentId;
    private String imgUrl;
    private String bgColor;
    private String actionLogo;
    private int actionOrderNumber;
    private String actionType;
    private String jumpToAction;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getBgColor() {
        return bgColor;
    }

    public void setBgColor(String bgColor) {
        this.bgColor = bgColor;
    }

    public String getActionLogo() {
        return actionLogo;
    }

    public void setActionLogo(String actionLogo) {
        this.actionLogo = actionLogo;
    }

    public int getActionOrderNumber() {
        return actionOrderNumber;
    }

    public void setActionOrderNumber(int actionOrderNumber) {
        this.actionOrderNumber = actionOrderNumber;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getJumpToAction() {
        return jumpToAction;
    }

    public void setJumpToAction(String jumpToAction) {
        this.jumpToAction = jumpToAction;
    }

}
