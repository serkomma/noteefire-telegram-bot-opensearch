package com.serkomma.opensearch.services;

import com.serkomma.opensearch.entities.NotificationEntity;
import com.serkomma.opensearch.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository){
        this.notificationRepository = notificationRepository;
    }

    public List<NotificationEntity> findByNotificationContaining(String phrase, long chatId){
        return notificationRepository.findByNotificationContaining(phrase);
    }

    public List<NotificationEntity> search(String phrase, long chatId){
        return notificationRepository.searchNotificationEntitiesByNotificationAndChatidEquals(phrase,chatId);
    }
}
