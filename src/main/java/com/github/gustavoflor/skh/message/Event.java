package com.github.gustavoflor.skh.message;

public record Event(String name, Long delay) {

    private static final Long THIRTY_SECONDS = 30000L;

    @Override
    public String toString() {
        return String.format("Event{name='%s',delay='%s'}", name, delay());
    }

    @Override
    public Long delay() {
        return this.delay > THIRTY_SECONDS ? THIRTY_SECONDS : this.delay;
    }

    public void sleep() {
        try {
            Thread.sleep(delay());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
