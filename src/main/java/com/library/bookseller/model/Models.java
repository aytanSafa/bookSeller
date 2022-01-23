package com.library.bookseller.model;


public class Models <T> {

    private T obj;

    public Models(T obj) {
        this.obj = obj;
    }

    public T getObj(){
        return this.obj;
    }

}
