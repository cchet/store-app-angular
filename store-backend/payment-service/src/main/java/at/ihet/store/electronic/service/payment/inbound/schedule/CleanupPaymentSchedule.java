package at.ihet.store.electronic.service.payment.inbound.schedule;

import at.ihet.store.electronic.service.payment.application.command.AbortOverduePaymentsCommand;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
class CleanupPaymentSchedule {

    private final AbortOverduePaymentsCommand abortOverduePaymentsCommand;
    private final Logger log;

    @Autowired
    public CleanupPaymentSchedule(AbortOverduePaymentsCommand abortOverduePaymentsCommand, Logger log) {
        this.abortOverduePaymentsCommand = abortOverduePaymentsCommand;
        this.log = log;
    }

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    void scheduleCleanup() {
        abortOverduePaymentsCommand.abort();
    }
}
