package rental.assignment_problems;

import java.util.HashSet;
import java.util.Set;

public class NoticeDemo {

    public static void main(String[] args) {

        // Create students
        Student asha = new Student("S101", "Asha", "CSE");
        Student ravi = new Student("S102", "Ravi", "ECE");

        // Add preferred notification channels
        asha.addPreferredChannel(new EmailChannel());
        asha.addPreferredChannel(new AppChannel());

        ravi.addPreferredChannel(new SmsChannel());

        // Create notice board
        NoticeBoard noticeBoard = new NoticeBoard();

        noticeBoard.addStudent(asha);
        noticeBoard.addStudent(ravi);

        // Notice 1 - CSE only
        Set<String> cse = new HashSet<>();
        cse.add("CSE");

        Notice notice1 = new Notice(
                "Lab Closed Tomorrow",
                cse
        );

        noticeBoard.postNotice(notice1);

        System.out.println();

        // Notice 2 - CSE + ECE
        Set<String> cseEce = new HashSet<>();
        cseEce.add("CSE");
        cseEce.add("ECE");

        Notice notice2 = new Notice(
                "Fee Deadline Extended",
                cseEce
        );

        noticeBoard.postNotice(notice2);

        System.out.println();

        // Test adding a new channel without changing NoticeBoard
        asha.addPreferredChannel(new WhatsAppChannel());

        Notice notice3 = new Notice(
                "Sports Day",
                cse
        );

        noticeBoard.postNotice(notice3);

        System.out.println();

        // Test notice without a target department
        try {
            new Notice(
                    "General Announcement",
                    new HashSet<>()
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Cannot post notice: " + e.getMessage());
        }
    }
}
