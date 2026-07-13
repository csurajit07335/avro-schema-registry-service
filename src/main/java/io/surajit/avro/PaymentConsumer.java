package io.surajit.avro;

import io.surajit.avro.model.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    private static final Logger log = LoggerFactory.getLogger(PaymentConsumer.class);

    @KafkaListener(topics = PaymentProducer.TOPIC, groupId = "payments")
    public void onPayment(Payment payment) {
        log.info("Consumed Avro payment {} amount {} {}",
            payment.getPaymentId(), payment.getAmount(), payment.getCurrency());
    }
}
