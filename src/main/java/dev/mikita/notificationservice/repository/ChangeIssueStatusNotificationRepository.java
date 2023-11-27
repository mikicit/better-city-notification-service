package dev.mikita.notificationservice.repository;

import dev.mikita.notificationservice.entity.ChangeIssueStatusNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * The interface Change issue status notification repository.
 */
@Repository
public interface ChangeIssueStatusNotificationRepository extends JpaRepository<ChangeIssueStatusNotification, Long> {
    /**
     * Find all by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<ChangeIssueStatusNotification> findAllByUserId(String userId);
}
