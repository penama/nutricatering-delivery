package com.service.catering.infraestructure.servicebus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubConsumerAsyncClient;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;
import com.service.catering.application.service.BaseService;
import com.service.catering.application.service.events.ConsumerEventSubscribersService;

import jakarta.annotation.PostConstruct;

@Service
public class SubscriberEventHubService extends BaseService {

  @Autowired private ConsumerEventSubscribersService consumerEventSubscribersService;
  private final EventHubConsumerAsyncClient consumer;

  @Value("${azure.eventhub.connection-string}")
  private String connectionString;

  @Value("${azure.eventhub.hub-name}")
  private String queueName;

  public SubscriberEventHubService(
      @Value("${azure.eventhub.connection-string}") String connectionString,
      @Value("${azure.eventhub.hub-name}") String eventHubName) {
    this.consumer =
        new EventHubClientBuilder()
            .connectionString(connectionString, eventHubName)
            .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
            .buildAsyncConsumerClient();
  }

  @PostConstruct
  public void startListening() {
    consumer
        .getPartitionIds()
        .subscribe(
            partitionId -> {
              consumer
                  .receiveFromPartition(partitionId, EventPosition.latest())
                  .subscribe(this::handleEvent);
            });
    log.info(this.getClass(), "consumer > azure.eventhub.connection > ok");
  }

  private void handleEvent(PartitionEvent event) {
    String body = event.getData().getBodyAsString();
    log.info(
        this.getClass(),
        "Evento recibido, partición: "
            + event.getPartitionContext().getPartitionId()
            + ", body: "
            + body);
    try {
      consumerEventSubscribersService.procesarMensaje(body);
    } catch (Exception e) {
      log.error(this.getClass(), e.getMessage(), e);
    }
  }
}
