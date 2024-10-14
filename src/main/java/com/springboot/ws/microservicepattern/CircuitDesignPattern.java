package com.springboot.ws.microservicepattern;

/**
 * It is cloud design pattern to deal with non-transient failures in microservice.
 * Non-Transient failure -> Permanent failure which can render the system unavailable or the recovery can take longer than few seconds.
 *  e.g - Timeouts, Db connection down, services slow response time.
 *  why circuit breaker needed - to avoid cascading failure while the system recovers.
 *  it is not needed in case of few services or scenarios where load is not heavy.
 *
 */


public class CircuitDesignPattern {
}
