package com.springcloud.stream.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger Log = LoggerFactory.getLogger(SinkReceiver.class);

    /**
     * @param payload 有效载荷,一般指对于接收者有用的数据
     */
    @StreamListener(Sink.INPUT)
    private void receive(Object payload) {
        Log.info("SinkReceiver:"+ payload);
    }
}
