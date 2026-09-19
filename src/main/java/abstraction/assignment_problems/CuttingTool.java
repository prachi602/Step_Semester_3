package abstraction.assignment_problems;

public class CuttingTool extends GardenTool {

    public CuttingTool() {
        super();
    }

    @Override
    public String use() {
        return baseUse() + ", blade sharpened first";
    }
}