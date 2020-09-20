<b> Implementation description </b>

When calculate method is called, premium calculator expect to receive Policy.
Premium calculated by formula : <b> PREMIUM = PREMIUM_FIRE + PREMIUM_THEFT </b>

To calculate premium for particular risk type, policy objects, collected from policy,
is iterated to filter policy sub-objects by risk type and sum up their costs.

Calculator return summed premiums for particular risk types.