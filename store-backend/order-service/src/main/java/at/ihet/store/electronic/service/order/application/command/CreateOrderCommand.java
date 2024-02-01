package at.ihet.store.electronic.service.order.application.command;

import jakarta.validation.Valid;

import java.util.UUID;

public interface CreateOrderCommand {

    UUID create(@Valid CreateOrderRequest request);
}
