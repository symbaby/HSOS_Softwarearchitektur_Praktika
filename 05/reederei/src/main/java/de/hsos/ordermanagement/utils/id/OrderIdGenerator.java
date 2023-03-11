package de.hsos.ordermanagement.utils.id;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@IdGenerationQualifier(type = IdGenerationType.ORDER)
public class OrderIdGenerator implements IdGeneration {
    private final AtomicInteger idCounter;

    public OrderIdGenerator() {
        this.idCounter = new AtomicInteger(0);
    }

    @Override
    public Integer generateId() {
        return this.idCounter.incrementAndGet();
    }

    public AtomicInteger getIdCounter() {
        return this.idCounter;
    }


}
