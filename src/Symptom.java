public class Symptom {
    private String sympName;
    private int length;

    public Symptom() {
    }

    public Symptom(String sympName) {
        this.sympName = sympName;
        this.length = 0;
    }

    public void setSympName(String sympName) {
        this.sympName = sympName;
    }

    public String getSympName() {
        return this.sympName;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getLength(){
        return this.length;
    }
}
