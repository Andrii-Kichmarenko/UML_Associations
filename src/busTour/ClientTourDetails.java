package busTour;

public class ClientTourDetails {

    private Member member;
    private Tour tour;
    private double moneySpent;
    private boolean present = false;

    public ClientTourDetails(Member member, Tour tour) {
        this.member = member;
        this.tour = tour;
        this.moneySpent = 0.0;
        member.addClientTourDetails(this);
        tour.addClientTourDetails(this);
    }

    public Member getMember() {
        return member;
    }

    public Tour getTour() {
        return tour;
    }

    public void setMoney(double money) {
        this.moneySpent = money;
    }

    public double getMoneySpent() {
        return moneySpent;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }
}