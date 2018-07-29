package carWorkshop;

import java.time.LocalDate;

public class Order {

    private static long orderIDCounter = 0;
    private Long orderID;
    private LocalDate placedDate;
    private LocalDate finishedData;
    private enum Staus{ Done, Finished, InProcess }
    private Car car;
    private Mechanic mechanic;

    public Order(LocalDate placedData) {
        super();
        this.placedDate = placedData;
        orderID = orderIDCounter;
        orderIDCounter++;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setMechanic(Mechanic mechanic){
        if(this.mechanic != null && this.mechanic != mechanic){
            this.mechanic.removeOrder(this);
        }
        this.mechanic = mechanic;
        mechanic.addOrder(this);
    }

    public void removeMechanic(){
        if(mechanic != null){
            mechanic.removeOrder(this);
            mechanic = null;
        }
    }

    public void setCar(Car targetCar) {
        if(targetCar == null){
            removeCar();
        }else if(car != null){
            car.removeOrder(this);
            targetCar.addOrder(this);
            car = targetCar;
        }else{
            targetCar.addOrder(this);
            car = targetCar;
        }
    }

    public void removeCar(){
        if(car != null){
            car.removeOrder(this);
            car = null;
        }
    }

    public Car getCar(){
        return car;
    }

    public LocalDate getFinishedData() {
        return finishedData;
    }

    public void setFinishedData(LocalDate finishedData) {
        this.finishedData = finishedData;
    }
}
