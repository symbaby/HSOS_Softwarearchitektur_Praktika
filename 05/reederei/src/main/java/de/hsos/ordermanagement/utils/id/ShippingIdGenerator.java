package de.hsos.ordermanagement.utils.id;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@IdGenerationQualifier(type = IdGenerationType.SHIPPING)
public class ShippingIdGenerator implements IdGeneration {
    private final AtomicInteger idCounter;

    public ShippingIdGenerator() {
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