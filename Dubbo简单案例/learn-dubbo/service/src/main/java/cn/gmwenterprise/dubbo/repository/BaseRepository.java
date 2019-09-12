package cn.gmwenterprise.dubbo.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public abstract class BaseRepository<Domain> {

    private static final AtomicLong COUNTER = new AtomicLong();

    protected final Map<Long, Domain> repository;

    public BaseRepository() {
        repository = new ConcurrentHashMap<>();
    }

    protected Long increment() {
        return COUNTER.incrementAndGet();
    }

    public abstract void add(Domain domain);

    public abstract List<Domain> queryAll();
}
