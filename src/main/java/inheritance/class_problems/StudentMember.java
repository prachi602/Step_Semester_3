package inheritance.class_problems;

public class StudentMember extends LibraryMember {

    private String course;

    public StudentMember(
            String memberId,
            int borrowLimit,
            String course) {

        super(memberId, borrowLimit);
        this.course = course;
    }
    @Override
    public void displayInfo() {
        System.out.println(
                "Student Member | Course: "
                        + course
                        + " | Books Borrowed: "
                        + booksBorrowed
        );
    }
    @Override
    protected void chargeFine(int amount) {

        super.chargeFine(amount / 2);
    }

    public String getCourse() {
        return course;
    }
    public static void main(String[] args) {

        StudentMember s =
                new StudentMember("STU5", 3, "CSE");

        s.chargeFine(100);

        System.out.println(
                "Total Fine: " + s.getTotalFine()
        );

        int[] history = s.getFineHistory();

        history[0] = 999;

        System.out.println(
                "Recorded Fine: "
                        + s.getFineHistory()[0]
        );
    }
}
