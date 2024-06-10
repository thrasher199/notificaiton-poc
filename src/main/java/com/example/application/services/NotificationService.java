package com.example.application.services;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import dev.hilla.BrowserCallable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class NotificationService {

    private final Sinks.Many<String> notificationSinks;

    public NotificationService() {
        this.notificationSinks = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publishNotification(String message) {
        notificationSinks.tryEmitNext(message);
    }

    public Sinks.Many<String> getNotificationPublisher() {
        return notificationSinks;
    }


}
