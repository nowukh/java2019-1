public class Surgeon extends Doctor {

    public Surgeon(boolean worksAtHospital) {
        super(worksAtHospital);
    }

    void treatPatient() {
        System.out.println("surgeon treet patient");
    }

    void makeIncision () {
        System.out.println("makeIncision");
    }

    @Override
    public String toString() {
        return "Surgeon{" +
                "worksAtHospital=" + worksAtHospital +
                '}';
    }
}