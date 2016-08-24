package com.adobe.entity;

import java.util.List;

public class ProjectDisplayItem {
    private String project;
    private String manager;
    private List<String> staff;
    /**
     * 
     */
    public ProjectDisplayItem() {
    }
    /**
     * @param project
     * @param manager
     * @param staff
     */
    public ProjectDisplayItem(String project, String manager, List<String> staff) {
        this.project = project;
        this.manager = manager;
        this.staff = staff;
    }
    /**
     * @return the project
     */
    public final String getProject() {
        return project;
    }
    /**
     * @param project the project to set
     */
    public final void setProject(String project) {
        this.project = project;
    }
    /**
     * @return the manager
     */
    public final String getManager() {
        return manager;
    }
    /**
     * @param manager the manager to set
     */
    public final void setManager(String manager) {
        this.manager = manager;
    }
    /**
     * @return the staff
     */
    public final List<String> getStaff() {
        return staff;
    }
    /**
     * @param staff the staff to set
     */
    public final void setStaff(List<String> staff) {
        this.staff = staff;
    }
}
