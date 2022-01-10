package com.springcloud.stream.receiver;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.ServiceActivator;

@EnableBinding(value = {Sink.class})
public class SinkReceiver2 {

    private static Logger Log = LoggerFactory.getLogger(SinkReceiver.class);

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void receive(Object payload) {
        Log.info("SinkReceiver2:" + payload);
    }
}
