package com.library.bookseller.model;

public class Models <T> {

    T obj;
    Models(T obj) {
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }

}
