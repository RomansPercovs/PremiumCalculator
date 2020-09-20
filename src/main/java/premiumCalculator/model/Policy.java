package premiumCalculator.model;

import java.util.List;

public class Policy {
    private String number;
    private PolicyStatus status;
    private List<PolicyObject> objects;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PolicyStatus getStatus() {
        return status;
    }

    public void setStatus(PolicyStatus status) {
        this.status = status;
    }

    public List<PolicyObject> getObjects() {
        return objects;
    }

    public void setObjects(List<PolicyObject> objects) {
        this.objects = objects;
    }

}
