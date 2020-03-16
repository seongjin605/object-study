package com.obj.study._01._01_ticket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TicketTest {

    public static final int CASH = 15000;
    public static final int INIT_OFFICE_AMOUNT = 500000;
    public static final int TICKET_FEE = 5000;

    private TicketSeller ticketSeller;
    private TicketOffice ticketOffice;
    private Theater theater;

    @Before
    public void setUp() {
        this.ticketOffice = new TicketOffice(500000L,
                new Ticket(TICKET_FEE), new Ticket(TICKET_FEE), new Ticket(TICKET_FEE), new Ticket(TICKET_FEE));
        this.ticketSeller = new TicketSeller(this.ticketOffice);
        this.theater = new Theater(this.ticketSeller);
    }

    @Test
    public void 초대장이있는_관객_입장() {
        Bag bagWithInvitation = new Bag(new Invitation(), CASH);
        Audience audienceWithInvitation = new Audience(bagWithInvitation);
        this.theater.enter(audienceWithInvitation);
        Assert.assertEquals(INIT_OFFICE_AMOUNT, this.ticketOffice.getAmount()); // 초대장으로 티켓을 교환한 것으로, 매표소의 잔고는 변화가 없어야
    }

    @Test
    public void 초대장이없는_관객_입장() {
        Bag bagWithoutInvitation = new Bag(CASH);
        Audience audienceWithoutInvitation = new Audience(bagWithoutInvitation);
        this.theater.enter(audienceWithoutInvitation);
        Assert.assertTrue(this.ticketOffice.getAmount() > INIT_OFFICE_AMOUNT); // 관객이 티켓을 직접 구매했으니, 매표소의 잔고는 올라갔을 것
    }
}
