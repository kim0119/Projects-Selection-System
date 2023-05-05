package com.company.project.model;

import com.company.project.common.PageParam;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_student_course")
public class StudentCourse extends PageParam {
    /**
     * 自增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建人
     */
    @Column(name = "created_by")
    private String createdBy;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 修改人
     */
    @Column(name = "updated_by")
    private String updatedBy;

    /**
     * 更新时间
     */
    @Column(name = "updated_at")
    private Date updatedAt;

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
     * 业务状态(0待审核;1审核通过;2审批不通过)
     */
    private Integer status;

    /**
     * 课程ID
     */
    @Column(name = "course_id")
    private Long courseId;

    /**
     * 成绩
     */
    private Long grade;

    /**
     * 教师ID
     */
    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "project_id")
    private Long projectId;

    @Column(name = "overdue_time")
    private Date overdueTime;

    @Transient
    private String courseName;

    @Transient
    private String teacherName;

    @Transient
    private String studentName;

    @Transient
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 获取自增id
     *
     * @return id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取业务状态(0待审核;1审核通过;2审批不通过)
     *
     * @return status - 业务状态(0待审核;1审核通过;2审批不通过)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置业务状态(0待审核;1审核通过;2审批不通过)
     *
     * @param status 业务状态(0待审核;1审核通过;2审批不通过)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取课程ID
     *
     * @return course_id - 课程ID
     */
    public Long getCourseId() {
        return courseId;
    }

    /**
     * 设置课程ID
     *
     * @param courseId 课程ID
     */
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    /**
     * 获取成绩
     *
     * @return grade - 成绩
     */
    public Long getGrade() {
        return grade;
    }

    /**
     * 设置成绩
     *
     * @param grade 成绩
     */
    public void setGrade(Long grade) {
        this.grade = grade;
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
}