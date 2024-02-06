package at.ihet.store.electronic.service.order;

import at.ihet.store.electronic.service.order.outbound.amqp.catalog.CatalogBookOutMessage;
import at.ihet.store.electronic.service.order.outbound.amqp.catalog.CatalogReserveMessage;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.DefaultJackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JavaTypeMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Map;

@Configuration
public class RabbitConfiguration {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, final MessageConverter jsonMessageConverter) {
        final var rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter);
        return rabbitTemplate;
    }

    @Bean
    MessageConverter produceJackson2MessageConverter(Jackson2JavaTypeMapper mapper) {
        var converter = new Jackson2JsonMessageConverter();
        converter.setJavaTypeMapper(mapper);
        return converter;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    Jackson2JavaTypeMapper produceDefaultJackson2JavaTypeMapper() {
        var mapper = new DefaultJackson2JavaTypeMapper();
        // Register types, so we mark serialized messages properly, and we are able to de-serialize messages properly
        mapper.setIdClassMapping(Map.of(
                "catalog_reserve_message", CatalogReserveMessage.class,
                "catalog_book_out_message", CatalogBookOutMessage.class
        ));
        return mapper;
    }
}
