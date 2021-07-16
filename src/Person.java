import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Person {
    private String name, email, phone;

    public Person(){
    }

    public Person(String name, String email, String phone){
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    private boolean isEmailValid(String email){
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;
        //Make the comparison case-insensitive.
        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    public void setEmail(String email){
        if(this.isEmailValid(email)) {
            this.email = email;
        }
        else{
            this.email = "Unknown";
        }
    }

    public String getEmail(){
        return this.email;
    }

    private boolean isPhoneNumberValid(String phoneNumber){
        boolean isValid = false;

        String expression = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        CharSequence inputStr = phoneNumber;
        Pattern pattern = Pattern.compile(expression);
        Matcher matcher = pattern.matcher(inputStr);
        if(matcher.matches()){
            isValid = true;
        }
        return isValid;
    }

    public void setPhone(String phone){
        if(isPhoneNumberValid(phone)) {
            this.phone = phone;
        }
        else{
            this.phone = "Unknown";
        }
    }

    public String getPhone(){
        return this.phone;
    }
}
