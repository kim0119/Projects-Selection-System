package com.company.project.model;

import com.company.project.common.PageParam;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_project")
public class Project extends PageParam {
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
     * 业务状态是否默认(1是)
     */
    private Integer status;

    /**
     * 指导老师
     */
    @Column(name = "teacher_id")
    private Long teacherId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 项目技术
     */
    private String technology;

    /**
     * 项目简介
     */
    private String introduction;

    /**
     * 已选人数
     */
    @Column(name = "front_number")
    private String frontNumber;

    /**
     * 最大人数
     */
    @Column(name = "max_number")
    private String maxNumber;

    /**
     * 确定人数
     */
    @Column(name = "determine_number")
    private String determineNumber;

    @Transient
    private String teacherName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
     * 获取业务状态是否默认(1是)
     *
     * @return status - 业务状态是否默认(1是)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置业务状态是否默认(1是)
     *
     * @param status 业务状态是否默认(1是)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取指导老师
     *
     * @return teacher_id - 指导老师
     */
    public Long getTeacherId() {
        return teacherId;
    }

    /**
     * 设置指导老师
     *
     * @param teacherId 指导老师
     */
    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    /**
     * 获取项目名称
     *
     * @return name - 项目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置项目名称
     *
     * @param name 项目名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取项目技术
     *
     * @return technology - 项目技术
     */
    public String getTechnology() {
        return technology;
    }

    /**
     * 设置项目技术
     *
     * @param technology 项目技术
     */
    public void setTechnology(String technology) {
        this.technology = technology;
    }

    /**
     * 获取项目简介
     *
     * @return introduction - 项目简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置项目简介
     *
     * @param introduction 项目简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取已选人数
     *
     * @return front_number - 已选人数
     */
    public String getFrontNumber() {
        return frontNumber;
    }

    /**
     * 设置已选人数
     *
     * @param frontNumber 已选人数
     */
    public void setFrontNumber(String frontNumber) {
        this.frontNumber = frontNumber;
    }

    /**
     * 获取最大人数
     *
     * @return max_number - 最大人数
     */
    public String getMaxNumber() {
        return maxNumber;
    }

    /**
     * 设置最大人数
     *
     * @param maxNumber 最大人数
     */
    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    /**
     * 获取确定人数
     *
     * @return determine_number - 确定人数
     */
    public String getDetermineNumber() {
        return determineNumber;
    }

    /**
     * 设置确定人数
     *
     * @param determineNumber 确定人数
     */
    public void setDetermineNumber(String determineNumber) {
        this.determineNumber = determineNumber;
    }
}