package abstraction.assignment_problems;

public abstract class GardenTool {

    public GardenTool() {
    }

    public abstract String use();

    protected String baseUse() {
        return "Using the tool in the garden";
    }
}