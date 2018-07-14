package com.hhc.code.DesignMode.Builder;

public abstract class Burger implements Item{
    @Override
    public Packing Packing(){
        return new Wrapper();
    }
    @Override
    public abstract float Price();
}
