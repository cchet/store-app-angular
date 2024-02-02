package at.ihet.store.electronic.service.payment.shared;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationConfiguration {

    @Value("${payment.queue.order}")
    public String queueNameOrder;

    @Value("${payment.queue.payment}")
    public String queueNamePayment;

    @Value("${payment.queue.catalog}")
    public String queueNameCatalog;

    @Value("${payment.max-pending-payment-seconds}")
    public Integer maxPendingPaymentSeconds;
}
