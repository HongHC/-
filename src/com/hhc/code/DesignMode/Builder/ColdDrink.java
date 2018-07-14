package com.hhc.code.DesignMode.Builder;

public abstract class ColdDrink implements Item {
    @Override
    public Packing Packing(){
        return new Bottle();
    }
    @Override
    public abstract float Price();
}
