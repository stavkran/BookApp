package com.novelty.noveltybackend.Report;

import com.novelty.noveltybackend.NoveltyUser.NoveltyUser;
import jakarta.persistence.*;

import java.util.Calendar;
import java.util.Date;

@Entity
@Table
public class Report {
    @Id
    @SequenceGenerator(
            name = "report_sequence",
            sequenceName = "report_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "report_sequence"
    )
    private Long id;
    private String reason;

    private String comment;

    private Date createdTimestamp;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private NoveltyUser createdByUser;

    @ManyToOne
    @JoinColumn(name = "refers_to_user_id")
    private NoveltyUser refersToUser;


    public Report() {
    }

    public Report(NoveltyUser createdByUser, NoveltyUser refersToUser, String reason) {
        this.createdByUser = createdByUser;
        this.refersToUser = refersToUser;
        this.reason = reason;
        this.createdTimestamp = Calendar.getInstance().getTime();
    }

    public Report(NoveltyUser createdByUser, NoveltyUser refersToUser, String reason, String comment) {
        this.createdByUser = createdByUser;
        this.refersToUser = refersToUser;
        this.reason = reason;
        this.comment = comment;
        this.createdTimestamp = Calendar.getInstance().getTime();
    }

    public Report(Long id, NoveltyUser createdByUser, NoveltyUser refersToUser, String reason) {
        this.id = id;
        this.createdByUser = createdByUser;
        this.refersToUser = refersToUser;
        this.reason = reason;
        this.createdTimestamp = Calendar.getInstance().getTime();
    }

    public Report(Long id, NoveltyUser createdByUser, NoveltyUser refersToUser, String reason, String comment) {
        this.id = id;
        this.createdByUser = createdByUser;
        this.refersToUser = refersToUser;
        this.reason = reason;
        this.comment = comment;
        this.createdTimestamp = Calendar.getInstance().getTime();
    }
    public Long getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public NoveltyUser getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(NoveltyUser createdByUser) {
        this.createdByUser = createdByUser;
    }

    public NoveltyUser getRefersToUser() {
        return refersToUser;
    }

    public void setRefersToUser(NoveltyUser refersToUser) {
        this.refersToUser = refersToUser;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", reason='" + reason + '\'' +
                ", comment='" + comment + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", createdByUser=" + createdByUser +
                ", refersToUser=" + refersToUser +
                '}';
    }
}
