public class FamilyDoctor extends Doctor {
    boolean makesHouseCalls = true;

    public FamilyDoctor(boolean worksAtHospital) {
        super(worksAtHospital);
    }

    void giveAdvice() {
        System.out.println("giveAdvice");
    }

    @Override
    public String toString() {
        return "FamilyDoctor{" +
                "makesHouseCalls=" + makesHouseCalls +
                '}';
    }
}