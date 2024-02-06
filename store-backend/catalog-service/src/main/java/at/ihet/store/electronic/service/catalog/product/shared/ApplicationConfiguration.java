package at.ihet.store.electronic.service.catalog.product.shared;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class ApplicationConfiguration {

    @Value("${catalog.queue.order}")
    public String queueNameOrder;

    @Value("${catalog.queue.catalog}")
    public String queueNameCatalog;
}
