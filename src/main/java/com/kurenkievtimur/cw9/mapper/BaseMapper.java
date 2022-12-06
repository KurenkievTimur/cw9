package com.kurenkievtimur.cw9.mapper;

public interface BaseMapper<T, E> {
    T convertEntityToDto(E e);
}
