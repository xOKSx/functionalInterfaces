package ru.tunkoff.fintech.qa;

@FunctionalInterface
public interface ArrayElementMaker {
    int process(int index, int modifier);
}
