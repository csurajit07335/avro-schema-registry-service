package io.surajit.avro;

import io.surajit.avro.model.Payment;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class PaymentProducer {
    public static final String TOPIC = "payments-avro";
    private final KafkaTemplate<String, Payment> template;
    public PaymentProducer(KafkaTemplate<String, Payment> template) { this.template = template; }

    public void send(Payment payment) {
        template.send(TOPIC, payment.getPaymentId().toString(), payment);
    }
}
