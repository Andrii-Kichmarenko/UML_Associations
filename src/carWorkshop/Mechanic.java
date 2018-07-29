package carWorkshop;


import java.time.LocalDate;
import java.util.ArrayList;

public class Mechanic extends Employee {

    private ArrayList<Order> assignedOrders;
    private double rate = getMinRate();

    public Mechanic(String name, String secondName, LocalDate hireDate, LocalDate birthDate) {
        super(name, secondName, hireDate, birthDate);
        assignedOrders = new ArrayList<>();
    }

    public ArrayList<Order> getAssignedOrders() {
        return assignedOrders;
    }

    public void addOrder(Order order) {
        if(!assignedOrders.contains(order)) {
            assignedOrders.add(order);
            order.setMechanic(this);
        }
    }

    public void removeOrder(Order order) {
        if (assignedOrders.contains(order)) {
            assignedOrders.remove(order);
            order.removeMechanic();
        }
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        if(rate < getMinRate()){
            throw new Error("New rate is less than minimum");
        }else{
            this.rate = rate;
        }
    }

}
