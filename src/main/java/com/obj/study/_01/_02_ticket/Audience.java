package com.obj.study._01._02_ticket;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Long buy(Ticket ticket) {
        return bag.hold(ticket);
    }
//    public Bag getBag() {
//        return bag;
//    }

}
