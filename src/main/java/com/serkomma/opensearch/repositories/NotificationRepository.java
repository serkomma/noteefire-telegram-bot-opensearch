package com.serkomma.opensearch.repositories;

import com.serkomma.opensearch.entities.NotificationEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NotificationRepository extends ElasticsearchRepository<NotificationEntity, Long> {
    List<NotificationEntity> findByNotificationContaining(String phrase);
    List<NotificationEntity> searchNotificationEntitiesByNotificationAndChatidEquals(String phrase, long chatid);
}
