package de.hsos.shared.id;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@IdGenerationQualifier(type = IdGenerationType.CUSTOMER)
public class CustomerIdGenerator implements IdGeneration {
    private final AtomicInteger idCounter;

    public CustomerIdGenerator() {
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
