package com.pracha.orderorganic.models.models.sidemenu;

/**
 * @author nirwannursabda
 * @date 07/03/18
 */

public class ChildModel {
    String title;
    boolean isSelected;
    int my_id;

    public int getMy_id() {
        return my_id;
    }

    public void setMy_id(int my_id) {
        this.my_id = my_id;
    }

    public ChildModel(String title){
        this.title = title;
    }

    public ChildModel(String title, int my_id) {
        this.title = title;
        this.my_id = my_id;
    }

    public ChildModel(String title, boolean isSelected){
        this.title = title;
        this.isSelected = isSelected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
