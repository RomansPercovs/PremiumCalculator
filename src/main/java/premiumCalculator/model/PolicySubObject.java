package premiumCalculator.model;

public class PolicySubObject {
    private String name;
    private double cost;
    private RiskType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public RiskType getType() {
        return type;
    }

    public void setType(RiskType type) {
        this.type = type;
    }
}
