package ru.tunkoff.fintech.qa;

@FunctionalInterface
public interface ArrayElementMaker<T> {
    T process(T index, T modifier);
}
