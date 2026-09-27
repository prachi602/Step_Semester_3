package rental.assignment_problems;

public class Membership {

    public enum Status {
        ACTIVE,
        FROZEN,
        EXPIRED
    }

    private Member member;
    private MembershipPlan plan;
    private Status status;

    public Membership(Member member, MembershipPlan plan) {

        if (member == null) {
            throw new IllegalArgumentException(
                    "Member cannot be null"
            );
        }

        if (plan == null) {
            throw new IllegalArgumentException(
                    "Membership plan cannot be null"
            );
        }

        this.member = member;
        this.plan = plan;
        this.status = Status.ACTIVE;
    }

    public Member getMember() {
        return member;
    }

    public MembershipPlan getPlan() {
        return plan;
    }

    public Status getStatus() {
        return status;
    }

    public double getFee() {
        return plan.calculateFee();
    }

    public boolean checkIn() {

        if (status != Status.ACTIVE) {
            return false;
        }

        return true;
    }

    public boolean freeze() {

        if (status != Status.ACTIVE) {
            return false;
        }

        status = Status.FROZEN;
        return true;
    }

    public boolean unfreeze() {

        if (status != Status.FROZEN) {
            return false;
        }

        status = Status.ACTIVE;
        return true;
    }

    public boolean expire() {

        if (status == Status.EXPIRED) {
            return false;
        }

        status = Status.EXPIRED;
        return true;
    }
}