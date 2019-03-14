public class Launcher {
    public static void main(String[] args) {
        // 인스턴스 생성
        Doctor doctor = new Doctor(true);
        FamilyDoctor familyDoctor = new FamilyDoctor(false);
        Surgeon surgeon = new Surgeon(true);

        //doctor test
        System.out.println(doctor);
        doctor.treatPatient();
        System.out.println();

        // family doctor test
        System.out.println(familyDoctor);
        familyDoctor.treatPatient();
        familyDoctor.giveAdvice();
        System.out.println();

        // surgeon test
        System.out.println(surgeon);
        surgeon.treatPatient();
        surgeon.makeIncision();
        System.out.println();

    }
}
