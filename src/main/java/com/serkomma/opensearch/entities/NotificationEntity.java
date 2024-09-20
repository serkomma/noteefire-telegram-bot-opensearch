package com.serkomma.opensearch.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

@Getter
@Setter
@Document(indexName = "notification")
@Setting(settingPath = "/setting.json")
@Mapping(mappingPath = "/mapping.json")
public class NotificationEntity {
    @Id
    private long chatid;
    @Field( type = FieldType.Date, name = "datetime")
    private String datetime;
    @Field( type = FieldType.Text, name = "notification")
    private String notification;
}

