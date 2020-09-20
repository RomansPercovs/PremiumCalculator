package premiumCalculatorTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import premiumCalculator.*;
import premiumCalculator.model.Policy;
import premiumCalculator.model.PolicyObject;
import premiumCalculator.model.PolicySubObject;
import premiumCalculator.model.RiskType;
import premiumCalculator.service.PremiumCalculatorImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PremiumCalculatorImpl.class)
public class PremiumCalculatorTest {

    @Autowired
    private PremiumCalculator premiumCalculator;

    @Test
    public void testOne() {
        Policy policy = createPolicy(RiskType.FIRE, RiskType.THIEFT, 100, 8);
        assertEquals(2.28, premiumCalculator.calculate(policy), 0.01);
    }

    @Test
    public void testTwo() {
        Policy policy = createPolicy(RiskType.FIRE, RiskType.THIEFT, 500, 102.51);
        assertEquals(17.13, premiumCalculator.calculate(policy), 0.01);
    }

    // Auxiliary methods

    private Policy createPolicy(RiskType firstSubObType, RiskType secondSubObType, double firstSubObCost, double secondSubObCost) {
        Policy policy = new Policy();
        List<PolicySubObject> policySubObjects = new ArrayList<PolicySubObject>();
        policySubObjects.add(createPolicySubObject(firstSubObType, firstSubObCost));
        policySubObjects.add(createPolicySubObject(secondSubObType, secondSubObCost));
        PolicyObject policyObject = new PolicyObject();
        policyObject.setSubObjects(policySubObjects);
        policy.setObjects(Collections.singletonList(policyObject));
        return policy;
    }

    private PolicySubObject createPolicySubObject(RiskType riskType, double cost) {
        PolicySubObject policySubObject = new PolicySubObject();
        policySubObject.setType(riskType);
        policySubObject.setCost(cost);
        return policySubObject;
    }
}
