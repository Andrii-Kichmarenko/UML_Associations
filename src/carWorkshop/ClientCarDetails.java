package carWorkshop;

import java.time.LocalDate;

public class ClientCarDetails{

    private Client carOwner;
    private Car car;
    private LocalDate purchaseDate;
    private LocalDate sellDate;

    public ClientCarDetails(Client carOwner, Car car, LocalDate purchaseDate) {
        super();
        this.carOwner = carOwner;
        this.car = car;
        this.purchaseDate = purchaseDate;
    }

    public void setSellDate(LocalDate sellDate) {
        this.sellDate = sellDate;
    }

    public LocalDate getSellDate() {
        return sellDate;
    }

    public Car getCar() {
        return car;
    }

    public Client getOwner() {
        return carOwner;
    }

    @Override
    public String toString() {
        return "Car(" + car + ") -- Member(" + carOwner + ") " + purchaseDate + " " + sellDate  ;
    }
}

