package at.ihet.store.electronic.service.order.shared;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationConfiguration {

    @Value("${order.queue.order}")
    public String queueNameOrder;

    @Value("${order.queue.payment}")
    public String queueNamePayment;

    @Value("${order.queue.catalog}")
    public String queueNameCatalog;
}
