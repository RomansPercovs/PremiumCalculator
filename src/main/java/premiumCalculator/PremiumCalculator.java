package premiumCalculator;

import premiumCalculator.model.Policy;

/**
 * @return summed premiums for particular risk types.
 */
public interface PremiumCalculator {
    double calculate(Policy policy);
}
