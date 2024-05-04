package hw_3;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class SemaphoreSet<E> {
    private final Set<E> set = new HashSet<>();
    private final Semaphore semaphore = new Semaphore(1);

    public void add(E element) throws InterruptedException {
        semaphore.acquire();
        try {
            set.add(element);
        } finally {
            semaphore.release();
        }
    }

    public boolean contains(E element) throws InterruptedException {
        semaphore.acquire();
        try {
            return set.contains(element);
        } finally {
            semaphore.release();
        }
    }

    public void remove(E element) throws InterruptedException {
        semaphore.acquire();
        try {
            set.remove(element);
        } finally {
            semaphore.release();
        }
    }

    public int size() throws InterruptedException {
        semaphore.acquire();
        try {
            return set.size();
        } finally {
            semaphore.release();
        }
    }
}
