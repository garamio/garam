package io.garam.core.http;

public interface HttpMessage {

    /**
     * @param name field name
     * @return field value
     */
    String getHeader(String name);
}
