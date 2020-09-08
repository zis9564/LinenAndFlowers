package com.geleigeit.LinenAndFlowers.repository;

public interface StatusResolvable {

    public void toInProgress();

    public void toInDelivery();

    public void toDelivered();
}
