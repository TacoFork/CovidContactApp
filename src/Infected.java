import java.util.ArrayList;

public class Infected extends Person{
    private String city, state;
    Symptom fever, cough, shortBreath, tired, aches, chills, soreThroat, lossSmell, lossTaste, headache, diarrhea, vomit;
    ArrayList<Symptom> personSymptom = new ArrayList<>();   //holds the persons symptoms
    ArrayList<Person> contactList = new ArrayList<>();      //holds the contacted people
    ArrayList<Symptom> symptomList = new ArrayList<>();     //holds the predefined list of symptoms

    public Infected(){
        fever = new Symptom("Fever");
        cough = new Symptom("Cough");
        shortBreath = new Symptom("Shortness of breath or difficulty breathing");
        tired = new Symptom("Tiredness");
        aches = new Symptom("Aches");
        chills = new Symptom("Chills");
        soreThroat = new Symptom("Sore throat");
        lossSmell = new Symptom("Loss of smell");
        lossTaste = new Symptom("Loss of taste");
        headache = new Symptom("Headache");
        diarrhea = new Symptom("Diarrhea");
        vomit = new Symptom("Severe vomiting");

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
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
        return this.city;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }

    public void addSymptom(Symptom symptom){
        personSymptom.add(symptom);
    }

    public ArrayList<Symptom> getSymptoms(){
        return this.personSymptom;
    }

    public void addContacted(Person person){
        contactList.add(person);
    }

    public ArrayList<Person> getContactList(){
        return this.contactList;
    }

    public ArrayList<Symptom> getSymptomList() {
        return this.symptomList;
    }

    //returns string for printing the report
    public String report(){
        String symptoms = "";
        String contacts = "";
        for(int index = 0; index < this.personSymptom.size(); index++){
            symptoms += String.format("          had %s for %d days\n", this.personSymptom.get(index).getSympName(),
                    this.personSymptom.get(index).getLength());
        }
        for(int index = 0; index <this.contactList.size(); index++){
            contacts += String.format("Name: %s \nPhone: %s \nEmail: %s \n\n", this.contactList.get(index).getName(),
                    this.contactList.get(index).getPhone(), this.contactList.get(index).getEmail());
        }

        return String.format("***** Contact Tracing Report ***** \n" +
                "Name: %s \nPhone: %s \nEmail: %s \nCity: %s State: %s\n\n" +
                "**        Symptoms: \n%s\n\n" +
                "**        Contacts: \n%s", this.getName(), this.getPhone(), this.getEmail(), this.getCity(), this.getState(),
                symptoms, contacts);
    }
}
