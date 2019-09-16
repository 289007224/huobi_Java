package com.huobi.client.examples;

import lombok.extern.slf4j.Slf4j;

import com.huobi.client.SubscriptionClient;
import com.huobi.client.examples.constants.Constants;

@Slf4j
public class SubscribeOrderUpdate {

  public static void main(String[] args) {

    String symbol = "htusdt";
    SubscriptionClient client = SubscriptionClient.create(Constants.API_KEY,Constants.SECRET_KEY);
    /**
     * subscribe order updateEvent ,old interface
     */
    client.subscribeOrderUpdateEvent(symbol,(event ->{
      log.info(event.getData().toString());
    }));

    /**
     * subscribe order updateEvent ,new interface (recommend)
     */
    client.subscribeOrderUpdateNewEvent(symbol,(event ->{
      log.info(event.getData().toString());
    }));


  }

}
