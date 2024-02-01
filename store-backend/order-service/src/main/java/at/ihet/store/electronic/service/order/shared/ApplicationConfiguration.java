package at.ihet.store.electronic.service.order.shared;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationConfiguration {

    @Value("${order.queue.inbound}")
    public String queueNameInbound;
}
