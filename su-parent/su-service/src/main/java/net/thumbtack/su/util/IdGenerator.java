package net.thumbtack.su.util;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private final static Random RANDOM = new Random();
    private final static AtomicLong UNIQUE_LONG_ID = new AtomicLong(System.currentTimeMillis());

    public static long getUID(){
        final long id = UNIQUE_LONG_ID.incrementAndGet();
        return Math.abs(RANDOM.nextLong()) + id;
    }
}
