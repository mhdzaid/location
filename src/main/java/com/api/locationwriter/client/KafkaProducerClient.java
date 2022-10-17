package com.api.locationwriter.client;

import com.api.locationwriter.model.Location;
import com.api.locationwriter.util.LocationProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.RecordMetadata;
import io.debezium.data.Envelope.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ExecutionException;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaProducerClient
{

    private final LocationProperties locationProperties;

    @Autowired
    private KafkaTemplate<String, Location> kafkaTemplate;

    @Autowired
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Sends location information to location-read microservice
     * @param location
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public void sendMessage(Location location)
    {
        try {
            String topic = locationProperties.getKafka().getLocationTopic();
            SendResult<String, Location> sendResult = kafkaTemplate.send(topic, location).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            log.info("topic = {}, partition = {}, offset = {}, entityEvent = {}", recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), location);

        }catch (Exception e) {
            log.error("Failed to send location Data :{} with error :{}", location, e.toString());
        }

    }

    /**
     * Receives Debezium event and sends to kafka topic
     * @param customerData
     * @param operation
     */
    public void replicateData(Map<String, Object> customerData, Operation operation)
    {
        final Location location = mapper.convertValue(customerData, Location.class);
        if (Operation.CREATE != operation)
            sendMessage(location);
    }
}
