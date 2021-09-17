package com.raspberryip.swissknife.hackin.layout.pojo;

import java.util.function.Consumer;

public interface Progressive<T> {
    void evolve();

    Boolean isMax();
    void onMax(Consumer<T> consumer);
    Boolean isDisposable();
}
