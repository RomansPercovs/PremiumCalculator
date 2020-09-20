package premiumCalculator.service;

import org.springframework.stereotype.Service;
import premiumCalculator.PremiumCalculator;
import premiumCalculator.model.Policy;
import premiumCalculator.model.PolicySubObject;
import premiumCalculator.model.RiskType;

@Service
public class PremiumCalculatorImpl implements PremiumCalculator {
    public double calculate(Policy policy) {
        double premiumFire = getPremium(policy, RiskType.FIRE);
        double premiumTheft = getPremium(policy, RiskType.THIEFT);
        return premiumFire + premiumTheft;
    }

    private double getPremium(Policy policy, RiskType type) {
        double sumInsured = getSumInsured(policy, type);
        double coefficient = getCoefficient(sumInsured, type);
        return sumInsured * coefficient;
    }

    private double getSumInsured(final Policy policy, RiskType type) {
        return policy.getObjects()
                .stream()
                .flatMap(policyObject -> policyObject.getSubObjects().stream())
                .filter(policySubObject -> policySubObject.getType() == type)
                .mapToDouble(PolicySubObject::getCost)
                .sum();
    }

    private double getCoefficient(double sumInsured, RiskType type) {
        switch (type) {
            case FIRE:
                return sumInsured > 100 ? 0.024 : 0.014;
            case THIEFT:
                return sumInsured >= 15 ? 0.05 : 0.11;
            default:
                return 1;
        }
    }


}
