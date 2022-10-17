package com.api.locationwriter.client;

import com.api.locationwriter.model.Location;
import com.api.locationwriter.util.LocationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerClient
{

    private final LocationProperties locationProperties;

    @Autowired
    private KafkaTemplate<String, Location> kafkaTemplate;

    public void sendMessage(Location location) throws ExecutionException, InterruptedException {
        String topic = locationProperties.getKafka().getVehicleTopic();
        SendResult<String, Location> sendResult = kafkaTemplate.send(topic, location).get();
        RecordMetadata recordMetadata = sendResult.getRecordMetadata();
        log.info("topic = {}, partition = {}, offset = {}, entityEvent = {}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), location);

    }
}
