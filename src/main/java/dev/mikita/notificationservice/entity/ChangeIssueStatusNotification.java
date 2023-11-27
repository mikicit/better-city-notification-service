package dev.mikita.notificationservice.entity;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * The type Change issue status notification.
 */
@Entity
@Table(name = "bc_notification")
public class ChangeIssueStatusNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "issue_id", nullable = false)
    private Long issueId;

    @Column(name = "user_id", nullable = false, length = 128)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private IssueStatus issueStatus;

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        Objects.requireNonNull(id);
        this.id = id;
    }

    /**
     * Gets issue id.
     *
     * @return the issue id
     */
    public Long getIssueId() {
        return issueId;
    }

    /**
     * Sets issue id.
     *
     * @param issueId the issue id
     */
    public void setIssueId(Long issueId) {
        Objects.requireNonNull(issueId);
        this.issueId = issueId;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(String userId) {
        Objects.requireNonNull(userId);
        this.userId = userId;
    }

    /**
     * Gets issue status.
     *
     * @return the issue status
     */
    public IssueStatus getIssueStatus() {
        return issueStatus;
    }

    /**
     * Sets issue status.
     *
     * @param issueStatus the issue status
     */
    public void setIssueStatus(IssueStatus issueStatus) {
        Objects.requireNonNull(issueStatus);
        this.issueStatus = issueStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChangeIssueStatusNotification that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(issueId, that.issueId) && Objects.equals(userId, that.userId) && issueStatus == that.issueStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, issueId, userId, issueStatus);
    }
}
