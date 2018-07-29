package carWorkshop;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client extends Person {

    private LocalDate registrationDate;
    private String emailAdress;

    private ArrayList<ClientCarDetails> clientCarDetails;

    public Client(String name, String secondName, LocalDate birthDate, LocalDate registrationDate) {
        super(name, secondName, birthDate);
        this.registrationDate = registrationDate;
        clientCarDetails = new ArrayList<>();
    }

    public boolean addCar(Car car, LocalDate purchaseDate){
        for (ClientCarDetails details : clientCarDetails){
            if(details.getCar().getVIN().equals(car.getVIN()) && details.getSellDate() == null){
                System.out.println("Member has (" + car + ") at the moment.");
                return false;
            }
        }
        ClientCarDetails newClientCarDetails = new ClientCarDetails(this, car, purchaseDate);
        clientCarDetails.add(newClientCarDetails);
        car.addClientCarDetails(newClientCarDetails);
        return true;
    }

    public void addClientCarDetails(ClientCarDetails newClientCarDetails){
        clientCarDetails.add(newClientCarDetails);
    }

    public boolean sellCar(Car car, LocalDate sellDate){
        for (ClientCarDetails details : clientCarDetails) {
            if (details.getCar().getVIN().equals(car.getVIN()) && details.getSellDate() == null) {
                details.setSellDate(sellDate);
                return true;
            }
        }
        System.out.println("Trying to sell the car(" + car + ") that don't belong to the client(" + this + ").");
        return false;
    }

    @Override
    public String toString() {
        return super.getName() + " " + super.getSecondName() + " " + super.getBirthDate();
    }
}
