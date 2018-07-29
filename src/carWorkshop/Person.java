package carWorkshop;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    private String name;
    private String secondName;
    private LocalDate birthDate;

    public Person(String name, String secondNane, LocalDate birthDate) {
        if (name == null || secondNane == null || birthDate == null) {
            throw new IllegalArgumentException("System required full name and birth date of person.");
        } else {
            this.name = name;
            this.secondName = secondNane;
            this.birthDate = birthDate;
        }
    }

    public int getAge() {
        return Period.between(birthDate,LocalDate.now()).getYears();
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        String str = new String("***********************************\n" +
                "Full name: " + name + " " + secondName + "\n" +
                "Birth date: " + birthDate + "\n" +
                "Age: " + getAge() + "\n");
        return str;
    }
}
