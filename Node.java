public class Node {
    protected Node next;
    protected Patient patient;

    public Node(Patient patient) {
        this.patient = patient;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void printNode() {
        //TODO: Implement this method
        String ans="Patient name: " +this.patient.getName()+"\n";
        ans+="Patient ID: " +this.patient.getId()+"\n";
        ans+="Patient triage level: "+this.patient.getTriageLevel()+"\n";
        ans+="Patient phone number: "+this.patient.getPhoneNumber()+"\n";
        ans+="Patient address: "+this.patient.getLocation()+"\n";
        System.out.println(ans);
    }
}
