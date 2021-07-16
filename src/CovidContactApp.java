import java.util.ArrayList;
import java.util.Scanner;

public class CovidContactApp {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Symptom> symptomList = new ArrayList<>();
        char infectedPerson = 'y';
        Infected infected;

        //instantiating symptoms
        Symptom fever = new Symptom("Fever");
        Symptom cough = new Symptom("Cough");
        Symptom shortBreath = new Symptom("Shortness of breath or difficulty breathing");
        Symptom tired = new Symptom("Tiredness");
        Symptom aches = new Symptom("Aches");
        Symptom chills = new Symptom("Chills");
        Symptom soreThroat = new Symptom("Sore throat");
        Symptom lossSmell = new Symptom("Loss of smell");
        Symptom lossTaste = new Symptom("Loss of taste");
        Symptom headache = new Symptom("Headache");
        Symptom diarrhea = new Symptom("Diarrhea");
        Symptom vomit = new Symptom("Severe vomiting");

        //Adding symptoms to list for easier output for asking if patient has said symptom.
        symptomList.add(fever);
        symptomList.add(cough);
        symptomList.add(shortBreath);
        symptomList.add(tired);
        symptomList.add(aches);
        symptomList.add(chills);
        symptomList.add(soreThroat);
        symptomList.add(lossSmell);
        symptomList.add(lossTaste);
        symptomList.add(headache);
        symptomList.add(diarrhea);
        symptomList.add(vomit);

        System.out.println("Contact Tracing Program");
        while(infectedPerson == 'y'){
            //gets infected patients information
            infected = new Infected();
            System.out.println("Enter a newly infected person's information");
            System.out.println("What is the patient's name?");
            infected.setName(keyboard.nextLine());
            System.out.println("What is the patient's phone number?");
            infected.setPhone(keyboard.nextLine());
            System.out.println("What is the patient's email?");
            infected.setEmail(keyboard.nextLine());
            System.out.println("What city does the patient live in?");
            infected.setCity(keyboard.nextLine());
            System.out.println("What state does the patient live in?");
            infected.setState(keyboard.nextLine());

            //prints out asking if patient has any symptoms which are taken from a predefined list of symptoms in infected class
            //if patient has symptom, symptom length is set and the object is stored into a list to track patients symptoms
            for(int index = 0; index < symptomList.size(); index++){
                System.out.printf("Does %s have any symptom of %s? (y/n)\n", infected.getName(),
                        symptomList.get(index).getSympName()); //gets predefined symptom list filled with symptom objects, gets index of said list, gets name attribute of objects in index
                char sign = keyboard.next().charAt(0);
                if(sign == 'y'){
                    infected.addSymptom(symptomList.get(index));
                    System.out.printf("How long has %s had this symptom for?\n", infected.getName());
                    symptomList.get(index).setLength(keyboard.nextInt());
                }
            }

            //Gets people who have been in contact with patient by creating a person object and stores that object into contact list
            System.out.printf("Has %s run into anyone? (y/n)\n", infected.getName());
            char contacted = keyboard.next().charAt(0);
            while(contacted =='y') {
                Person person = new Person();
                System.out.println("What is his/her name?");
                keyboard.nextLine();
                person.setName(keyboard.nextLine());
                System.out.println("What is his/her phone number?");
                person.setPhone(keyboard.nextLine());
                System.out.println("What is his/her email?");
                person.setEmail(keyboard.nextLine());
                infected.addContacted(person);
                System.out.printf("Has %s met anyone else?\n", infected.getName());
                contacted = keyboard.next().charAt(0);
            }
            System.out.println("\n" + infected.report());

            System.out.println("Would you like to enter another patient?");
            infectedPerson = keyboard.next().charAt(0);
            keyboard.nextLine();
        }
    }
}
