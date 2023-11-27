package dev.mikita.notificationservice.controller;

import com.google.firebase.auth.FirebaseToken;
import dev.mikita.notificationservice.annotation.FirebaseAuthorization;
import dev.mikita.notificationservice.entity.ChangeIssueStatusNotification;
import dev.mikita.notificationservice.service.NotificationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * The type Notification controller.
 */
@RestController
@RequestMapping(path = "/api/v1/notifications")
public class NotificationController {
    private final NotificationService notificationService;

    /**
     * Instantiates a new Notification controller.
     *
     * @param notificationService the notification service
     */
    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * Gets notification.
     *
     * @param id the id
     * @return the notification
     */
    @GetMapping(path = "/{id}")
    @FirebaseAuthorization
    public ChangeIssueStatusNotification getNotification(@PathVariable("id")Long id) {
        return notificationService.findNotification(id);
    }

    /**
     * Gets resident notifications.
     *
     * @param request the request
     * @return the resident notifications
     */
    @GetMapping
    @FirebaseAuthorization
    public ResponseEntity<List<ChangeIssueStatusNotification>> getResidentNotifications(HttpServletRequest request) {
        // Firebase token
        FirebaseToken token = (FirebaseToken) request.getAttribute("firebaseToken");
        List<ChangeIssueStatusNotification> response = notificationService.findAllNotifications(token.getUid());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
