package rental.class_problems;

public class LeaveReviewer {

    private String reviewerName;

    public LeaveReviewer(String reviewerName) {
        if (reviewerName == null || reviewerName.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Reviewer name cannot be blank"
            );
        }

        this.reviewerName = reviewerName;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public boolean approveRequest(LeaveRequest request) {
        if (request == null) {
            return false;
        }

        return request.approve();
    }

    public boolean rejectRequest(LeaveRequest request) {
        if (request == null) {
            return false;
        }

        return request.reject();
    }
}