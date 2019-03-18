public class Doctor {
    boolean worksAtHospital;

    public Doctor(boolean worksAtHospital){
        this.worksAtHospital = worksAtHospital;
    }

    void treatPatient() {
        System.out.println("doctor treat patient");
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "worksAtHospital=" + worksAtHospital +
                '}';
    }
}