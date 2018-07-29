package carWorkshop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Car {

    private String VIN;
    private String brand;
    private String model;
    private double engineSpacity;
    private ArrayList<ClientCarDetails> clientCarDetails;
    private ArrayList<Insurance> insurances;
    private HashMap<Long, Order> orderQualifiers;

    public Car(String VIN, String brand, String model, double engineSpacity) {
        super();
        this.VIN = VIN;
        this.brand = brand;
        this.model = model;
        this.engineSpacity = engineSpacity;
        clientCarDetails = new ArrayList<>();
        insurances = new ArrayList<>();
        orderQualifiers = new HashMap<>();
    }

    public boolean setOwner(Client owner, LocalDate purchaseDate){
        for (ClientCarDetails details : clientCarDetails){
            if(details.getSellDate() != null){
                System.out.println("Car can belong only one person. It belong to the " + details.getOwner() + " at the moment.");
                return false;
            }
        }
        ClientCarDetails newClientCarDetails = new ClientCarDetails(owner, this, purchaseDate);
        clientCarDetails.add(newClientCarDetails);
        owner.addClientCarDetails(newClientCarDetails);
        return true;
    }
    public Client getOwner(){
        for(ClientCarDetails details : clientCarDetails){
            if(details.getSellDate() == null){
                return details.getOwner();
            }
        }
        System.out.println("The car(" + this + ") don't belong to anybody.");
        return null;
    }

    public boolean sellCar(LocalDate sellDate){
        for (ClientCarDetails details : clientCarDetails) {
            if (details.getSellDate() == null) {
                details.setSellDate(sellDate);
                return true;
            }
        }
        System.out.println("Trying to sell the car(" + this + ") that don't belong to anybody.");
        return false;
    }

    public void addClientCarDetails(ClientCarDetails newClientCarDetails){
        clientCarDetails.add(newClientCarDetails);
    }

    public void addOrder(Order order) {
        if(!orderQualifiers.containsKey(order.getOrderID())) {
            orderQualifiers.put(order.getOrderID(), order);
            order.setCar(this);
        }
    }

    public void removeOrder(Order order) {
        if(orderQualifiers.containsKey(order.getOrderID())) {
            orderQualifiers.remove(order.getOrderID(), order);
            order.setCar(null);
        }
    }

    public Order findOrder(Order order) throws Exception {
        if(!orderQualifiers.containsKey(order.getOrderID())) {
            throw new Exception("Did not found order with id: " + order.getOrderID());
        }
        return orderQualifiers.get(order.getOrderID());
    }

    public String getVIN() {
        return VIN;
    }

    @Override
    public String toString() {
        return brand + " " + model + " " + engineSpacity + " " + VIN;
    }

    public void addInsurance(LocalDate fromDate, LocalDate toDate) {
        Insurance newInsurance = new Insurance(fromDate, toDate);
        insurances.add(newInsurance);
    }


    public boolean removeInsurance(Insurance targetInsurance){
        if(insurances.contains(targetInsurance)){
            insurances.remove(targetInsurance);
            return true;
        }
        return false;
    }

    public ArrayList<Insurance> getInsurances() {
        return insurances;
    }

    public class Insurance {
        private LocalDate fromDate;
        private LocalDate toDate;

        public Insurance(LocalDate fromDate, LocalDate toDate) {
            this.fromDate = fromDate;
            this.toDate = toDate;
        }
    }
}
