package dev.mikita.notificationservice.service;

import dev.mikita.notificationservice.entity.ChangeIssueStatusNotification;
import dev.mikita.notificationservice.entity.IssueStatus;
import dev.mikita.notificationservice.exception.NotFoundException;
import dev.mikita.notificationservice.repository.ChangeIssueStatusNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * The type Notification service.
 */
@Service
public class NotificationService {
    private final ChangeIssueStatusNotificationRepository changeIssueStatusNotificationRepository;

    /**
     * Instantiates a new Notification service.
     *
     * @param changeIssueStatusNotificationRepository the change issue status notification repository
     */
    @Autowired
    public NotificationService(ChangeIssueStatusNotificationRepository changeIssueStatusNotificationRepository) {
        this.changeIssueStatusNotificationRepository = changeIssueStatusNotificationRepository;
    }

    /**
     * Find all notifications list.
     *
     * @param userId the user id
     * @return the list
     */
    @Transactional(readOnly = true)
    public List<ChangeIssueStatusNotification> findAllNotifications(String userId) {
        return changeIssueStatusNotificationRepository.findAllByUserId(userId);
    }

    /**
     * Find notification change issue status notification.
     *
     * @param id the id
     * @return the change issue status notification
     */
    @Transactional(readOnly = true)
    public ChangeIssueStatusNotification findNotification(Long id) {
        return changeIssueStatusNotificationRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Notification is not found."));
    }

    /**
     * Create notification.
     *
     * @param issueId     the issue id
     * @param userId      the user id
     * @param issueStatus the issue status
     */
    @Transactional
    public void createNotification(Long issueId, String userId, IssueStatus issueStatus) {
        ChangeIssueStatusNotification changeIssueStatusNotification = new ChangeIssueStatusNotification();
        changeIssueStatusNotification.setIssueId(issueId);
        changeIssueStatusNotification.setUserId(userId);
        changeIssueStatusNotification.setIssueStatus(issueStatus);

        changeIssueStatusNotificationRepository.save(changeIssueStatusNotification);
    }
}
