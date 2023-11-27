package dev.mikita.notificationservice.dto;

import dev.mikita.notificationservice.entity.IssueStatus;
import lombok.Data;

/**
 * The type Change issue status notification dto.
 */
@Data
public class ChangeIssueStatusNotificationDto {
    private Long issueId;
    private String userId;
    private IssueStatus status;

    /**
     * Instantiates a new Change issue status notification dto.
     */
    public ChangeIssueStatusNotificationDto() {}
}
