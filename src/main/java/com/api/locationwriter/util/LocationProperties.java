package com.api.locationwriter.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "location", ignoreUnknownFields = false)
public class LocationProperties {

    private final Kafka kafka = new Kafka();
    private final DataSource DataSource = new DataSource();
    private final Async async = new Async();

    @Getter
    @Setter
    public static class Async {
        public Integer corePoolSize;
        public Integer maxPoolSize;
        public Integer queueCapacity;
    }
    @Getter
    @Setter
    public static class DataSource {
        public String host;
        public String port;
        public String database;
        public String username;
        public String password;
    }
    @Getter
    @Setter
    public static class Kafka {
        private final Consumer consumer = new Consumer();
        public String bootstrapServer;
        public String locationTopic;

        @Getter
        @Setter
        public static class Consumer {
            public String groupId;
        }
    }
}
