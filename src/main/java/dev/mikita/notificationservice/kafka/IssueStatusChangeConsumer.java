package dev.mikita.notificationservice.kafka;

import dev.mikita.notificationservice.dto.ChangeIssueStatusNotificationDto;
import dev.mikita.notificationservice.service.NotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * The type Issue status change consumer.
 */
@Component
public class IssueStatusChangeConsumer {
    private final NotificationService notificationService;

    /**
     * Instantiates a new Issue status change consumer.
     *
     * @param notificationService the notification service
     */
    public IssueStatusChangeConsumer(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Consume status change message.
     *
     * @param message the message
     */
    @KafkaListener(topics = "notifications", groupId = "notifications-group")
    public void consumeStatusChangeMessage(ChangeIssueStatusNotificationDto message) {
        notificationService.createNotification(message.getIssueId(), message.getUserId(), message.getStatus());
    }
}
