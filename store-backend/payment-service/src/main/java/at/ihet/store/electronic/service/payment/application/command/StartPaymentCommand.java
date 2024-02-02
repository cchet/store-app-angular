package at.ihet.store.electronic.service.payment.application.command;

import java.util.UUID;

public interface StartPaymentCommand {

    UUID start(StartPaymentRequest request);
}
