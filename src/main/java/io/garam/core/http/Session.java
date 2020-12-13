package io.garam.core.http;

/**
 * Interface to be implemented by objects that manages session.
 *
 * @author hyeyoom
 */
public interface Session {

    /**
     * @param name the name to which the object is bound.
     * @param value the object to be bound.
     */
    void setAttribute(String name, Object value);

    /**
     * @param name the name to which the object is bound.
     * @return the object that is bound by the given name.
     */
    Object getAttribute(String name);

    /**
     * @param name the name of bound object
     */
    void removeAttribute(String name);

    /**
     * Invalidates this session.
     */
    void invalidate();


}
