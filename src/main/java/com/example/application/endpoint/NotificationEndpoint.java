package com.example.application.endpoint;


import com.example.application.services.NotificationService;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.Endpoint;
import reactor.core.publisher.Flux;

@Endpoint
@AnonymousAllowed
public class NotificationEndpoint {

    private final NotificationService notificationService;

    public NotificationEndpoint(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public Flux<String> getNotification(){
        return notificationService.getNotificationPublisher().asFlux();
    }
}
