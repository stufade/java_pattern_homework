package hw_3;

public class Main {
    public static void main(String[] args) {
        final SynchronizedMap<Integer, String> synchronizedMap = new SynchronizedMap<>();
        final SemaphoreSet<String> semaphoreSet = new SemaphoreSet<>();

        // Запуск тестов для SynchronizedMap
        Thread thread1 = new Thread(() -> {
            synchronizedMap.put(1, "one");
            System.out.println("Added to SynchronizedMap: 1 -> one");
        });

        Thread thread2 = new Thread(() -> {
            synchronizedMap.put(2, "two");
            System.out.println("Added to SynchronizedMap: 2 -> two");
        });

        Thread thread3 = new Thread(() -> {
            String value = synchronizedMap.get(1);
            System.out.println("Retrieved from SynchronizedMap: 1 -> " + value);
        });

        // Запуск тестов для SemaphoreSet
        Thread thread4 = new Thread(() -> {
            try {
                semaphoreSet.add("Apple");
                System.out.println("Added to SemaphoreSet: Apple");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        Thread thread5 = new Thread(() -> {
            try {
                semaphoreSet.add("Orange");
                System.out.println("Added to SemaphoreSet: Orange");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        Thread thread6 = new Thread(() -> {
            try {
                boolean contains = semaphoreSet.contains("Apple");
                System.out.println("SemaphoreSet contains 'Apple': " + contains);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        // Запускаем потоки
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        // Ожидаем их завершения
        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
            thread5.join();
            thread6.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Вывод данных о размерах коллекций
        try {
            System.out.println("SynchronizedMap size: " + synchronizedMap.size());
            System.out.println("SemaphoreSet size: " + semaphoreSet.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
