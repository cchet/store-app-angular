package at.ihet.store.electronic.service.order.inbound.rest;

import at.ihet.store.electronic.service.order.application.command.CreateOrderCommand;
import at.ihet.store.electronic.service.order.application.command.CreateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/order")
public class OrderApi {

    private final CreateOrderCommand createOrderCommand;

    private final OrderViewMapper orderViewMapper;

    @Autowired
    public OrderApi(CreateOrderCommand createOrderCommand, OrderViewMapper orderViewMapper) {
        this.createOrderCommand = createOrderCommand;
        this.orderViewMapper = orderViewMapper;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    UUID create(@RequestBody final List<OrderItemView> orderItems) {
        var items = orderItems.stream().map(orderItem -> new CreateOrderRequest.Item(orderItem.productId(), orderItem.count())).collect(Collectors.toList());
        var request = CreateOrderRequest.of(items);
        return createOrderCommand.create(request);
    }
}
