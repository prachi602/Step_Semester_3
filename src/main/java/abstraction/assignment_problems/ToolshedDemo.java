package abstraction.assignment_problems;

public class ToolshedDemo {

    public static void main(String[] args) {

        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}