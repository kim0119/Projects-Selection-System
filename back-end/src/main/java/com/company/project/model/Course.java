package com.company.project.model;

import com.company.project.common.PageParam;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_course")
public class Course extends PageParam {
    /**
     * 记录ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 是否删除(0false未删除 1true已删除)
     */
    @Column(name = "is_delete")
    private Boolean isDelete;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 业务状态
     */
    private Long status;

    /**
     * 教师ID
     */
    @Column(name = "teacher_id")
    private Long teacherId;

    /**
     * 最大人数
     */
    @Column(name = "max_num")
    private Integer maxNum;

    /**
     * 已选人数
     */
    @Column(name = "selected_num")
    private Integer selectedNum;

    /**
     * 确定人数
     */
    @Column(name = "determine_num")
    private Integer determineNum;

    /**
     * 名称
     */
    private String name;

    /**
     * 简介
     */
    @Column(name = "brief_introduction")
    private String briefIntroduction;

    @Transient
    private String courseTypeName;

    public String getCourseTypeName() {
        return courseTypeName;
    }

    public void setCourseTypeName(String courseTypeName) {
        this.courseTypeName = courseTypeName;
    }

    /**
     * 获取记录ID
     *
     * @return id - 记录ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置记录ID
     *
     * @param id 记录ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取创建人
     *
     * @return created_by - 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 设置创建人
     *
     * @param createdBy 创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取更新时间
     *
     * @return updated_at - 更新时间
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedAt 更新时间
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * 获取修改人
     *
     * @return updated_by - 修改人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 设置修改人
     *
     * @param updatedBy 修改人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取是否删除(0false未删除 1true已删除)
     *
     * @return is_delete - 是否删除(0false未删除 1true已删除)
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否删除(0false未删除 1true已删除)
     *
     * @param isDelete 是否删除(0false未删除 1true已删除)
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取版本号
     *
     * @return version - 版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 设置版本号
     *
     * @param version 版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 获取业务状态
     *
     * @return status - 业务状态
     */
    public Long getStatus() {
        return status;
    }

    /**
     * 设置业务状态
     *
     * @param status 业务状态
     */
    public void setStatus(Long status) {
        this.status = status;
    }

    /**
     * 获取教师ID
     *
     * @return teacher_id - 教师ID
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 设置教师ID
     *
     * @param teacherId 教师ID
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取最大人数
     *
     * @return max_num - 最大人数
     */
    public Integer getMaxNum() {
        return maxNum;
    }

    /**
     * 设置最大人数
     *
     * @param maxNum 最大人数
     */
    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    /**
     * 获取已选人数
     *
     * @return selected_num - 已选人数
     */
    public Integer getSelectedNum() {
        return selectedNum;
    }

    /**
     * 设置已选人数
     *
     * @param selectedNum 已选人数
     */
    public void setSelectedNum(Integer selectedNum) {
        this.selectedNum = selectedNum;
    }

    /**
     * 获取确定人数
     *
     * @return determine_num - 确定人数
     */
    public Integer getDetermineNum() {
        return determineNum;
    }

    /**
     * 设置确定人数
     *
     * @param determineNum 确定人数
     */
    public void setDetermineNum(Integer determineNum) {
        this.determineNum = determineNum;
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取简介
     *
     * @return brief_introduction - 简介
     */
    public String getBriefIntroduction() {
        return briefIntroduction;
    }

    /**
     * 设置简介
     *
     * @param briefIntroduction 简介
     */
    public void setBriefIntroduction(String briefIntroduction) {
        this.briefIntroduction = briefIntroduction;
    }
}