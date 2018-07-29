import busTour.ClientTourDetails;
import busTour.Member;
import busTour.Tour;
import carWorkshop.Car;
import carWorkshop.Client;
import carWorkshop.Mechanic;
import carWorkshop.Order;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws Exception {

        //Association with attribute
        Car car1 = new Car("1111","Mercedes", "A", 1.6 );
        Car car2 = new Car("2222","Renault", "Laguna", 1.9 );
        Car car3 = new Car("3333","Opel","Astra", 2.2 );
        Mechanic mechanic1 = new Mechanic("Oleksandr", "Kowalski", LocalDate.of(2016,10,12), LocalDate.of(1990, 1,1));
        Order order1 = new Order(LocalDate.now());
        Order order2 = new Order(LocalDate.now());

        // Binary association one to many
        mechanic1.addOrder(order1);
        mechanic1.removeOrder(order1);
        order2.setMechanic(mechanic1);

        // Association with attribute
        Member tourMember = new Member("Jan", "Domanski", LocalDate.of(1994,2,1), LocalDate.now());
        Tour tour = new Tour(LocalDate.of(2018, 10, 30));
        ClientTourDetails newClientTourDetails = new ClientTourDetails(tourMember, tour);
        tourMember.setMoney(150, tour);
        tourMember.showTours();

        // Qualified association
        order1.setCar(car2);
        order1.setCar(null);
        car2.addOrder(order1);
        car2.addOrder(order1);
        car2.removeOrder(order1);

        // Composition
        car3.addInsurance(LocalDate.now(), LocalDate.now().plusYears(1));
        car3.removeInsurance(car1.getInsurances().get(car1.getInsurances().size() -1));

    }
}
