package rental.class_problems;

import java.time.LocalDate;

public class LeaveRequestDemo {

    public static void main(String[] args) {

        FullTimeEmployee john =
                new FullTimeEmployee("E101", "John");

        PartTimeEmployee jane =
                new PartTimeEmployee("E102", "Jane");

        LeaveReviewer reviewer =
                new LeaveReviewer("HR Manager");

        // John's leave request
        LeaveRequest johnRequest =
                new LeaveRequest(
                        john,
                        LocalDate.of(2026, 10, 5),
                        LocalDate.of(2026, 10, 10)
                );

        System.out.println(
                "John's initial status: "
                        + johnRequest.getStatus()
        );

        boolean johnApproved =
                reviewer.approveRequest(johnRequest);

        System.out.println(
                "John's leave approved: "
                        + johnApproved
        );

        System.out.println(
                "John's final status: "
                        + johnRequest.getStatus()
        );

        // Jane's leave request
        LeaveRequest janeRequest =
                new LeaveRequest(
                        jane,
                        LocalDate.of(2026, 10, 5),
                        LocalDate.of(2026, 10, 20)
                );

        boolean janeRejected =
                reviewer.rejectRequest(janeRequest);

        System.out.println(
                "Jane's leave rejected: "
                        + janeRejected
        );

        System.out.println(
                "Jane's final status: "
                        + janeRequest.getStatus()
        );

        // Try to change John's approved request back to Pending
        boolean changedBack =
                johnRequest.getStatus()
                        == LeaveRequest.Status.PENDING;

        System.out.println(
                "John's status changed back to Pending: "
                        + changedBack
        );

        // Contractor's leave request
        ContractorEmployee contractor =
                new ContractorEmployee("E103", "Mike");

        LeaveRequest contractorRequest =
                new LeaveRequest(
                        contractor,
                        LocalDate.of(2026, 10, 5),
                        LocalDate.of(2026, 10, 11)
                );

        System.out.println(
                "Contractor leave approved: "
                        + reviewer.approveRequest(contractorRequest)
        );

        System.out.println(
                "Contractor status: "
                        + contractorRequest.getStatus()
        );
    }
}