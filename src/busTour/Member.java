package busTour;

import carWorkshop.Person;
import java.time.LocalDate;
import java.util.ArrayList;

public class Member extends Person{

    private LocalDate registrationDate;
    private String emailAdress;
    private ArrayList<ClientTourDetails> clientTourDetails;

    public Member(String name, String secondName, LocalDate birthDate, LocalDate registrationDate) {
        super(name, secondName, birthDate);
        this.registrationDate = registrationDate;
        clientTourDetails = new ArrayList<>();
    }

    public void addClientTourDetails(ClientTourDetails newClientTourDetails) {
        clientTourDetails.add(newClientTourDetails);
    }

    public boolean setMoney(double money, Tour tour) throws Exception {
        for (ClientTourDetails details : clientTourDetails) {
            if (details.getTour() == tour) {
                details.setMoney(money);
                return true;
            }
        }
        throw new Exception("Member hasn't been assigned to this tour.");
    }

    public void showTours(){
        for(ClientTourDetails details : clientTourDetails){
            System.out.println("Date: " + details.getTour().getDate() + ".Money: " + details.getMoneySpent());
        }
    }
}