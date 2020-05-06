package com.sinry.missyou.core.kafka.logger;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import lombok.Data;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

@Data
public class KafkaAppender extends AppenderBase<ILoggingEvent> {
    private static Logger logger = LoggerFactory.getLogger(KafkaAppender.class);

    private String bootstrapServers;

    /**
     * 生产者
     */
    private Producer<String, String> producer;

    @Override
    public void start() {
        super.start();
        if (producer == null) {
            Properties props = new Properties();
            props.put("bootstrap.servers", bootstrapServers);
            //判断是否成功，我们指定了“all”将会阻塞消息
//            props.put("acks", "all");
//            props.put("retries", 0);
//            props.put("batch.size", 0);
            //延迟1s，1s内数据会缓存进行发送
//            props.put("linger.ms", 1);
//            props.put("buffer.memory", 33554432);
            props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
            producer = new KafkaProducer<>(props);
        }
    }

    @Override
    protected void append(ILoggingEvent iLoggingEvent) {
        String msg = iLoggingEvent.getFormattedMessage();
        logger.debug("向kafka推送日志开始:" + msg);
        ProducerRecord<String, String> record = new ProducerRecord<>(
                "kafka-springboot-log-1", msg
        );
        producer.send(record);
    }
}
