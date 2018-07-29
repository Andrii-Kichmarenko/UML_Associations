package busTour;

import java.time.LocalDate;
import java.util.ArrayList;

public class Tour {

    private LocalDate date;
    private ArrayList<ClientTourDetails> clientTourDetails;

    public Tour(LocalDate date) {
        this.date = date;
        clientTourDetails = new ArrayList<>();
    }

    public void addClientTourDetails(ClientTourDetails newClientTourDetails) {
        clientTourDetails.add(newClientTourDetails);
    }

    public LocalDate getDate() {
        return date;
    }

    public void showTours(){
        for(ClientTourDetails details : clientTourDetails){
            System.out.println("Date: " + details.getTour().getDate() + ".Money: " + details.getMoneySpent());
        }
    }
}