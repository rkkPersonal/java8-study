package org.func;

/**
 * @author Steven
 */
@FunctionalInterface
public interface Converter<F, T> {

    T convert(F from);

}
