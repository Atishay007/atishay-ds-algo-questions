package com.threads;

public class Payment {

    private static int PAYMENT_MODES = 2;

    public void getPaymentMethods() {
        synchronized (this) {
            try {
                System.out.println("Inside synchronized block:: Object level lock");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void getPaymentMethods2() {
        try {
            System.out.println("Inside synchronized method block:: Object level lock");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void updatePaymentModes() {
        try {
            PAYMENT_MODES = PAYMENT_MODES + 1;
            System.out.println("Inside static synchronized method class level lock: updatePaymentModes");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void updatePaymentModes2() {
        try {
            System.out.println("Inside static synchronized method class level lock: updatePaymentModes2");
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
