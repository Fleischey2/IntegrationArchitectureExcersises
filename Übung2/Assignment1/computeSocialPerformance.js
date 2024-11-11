const bonusRates = {
    0.75: 0.40,
    1: 1,
    1.25: 2
};

function calculateBonusSocialPerfomance(performanceLevel, baseBonus) {
    console.log(performanceLevel)
    const bonusRate = bonusRates[performanceLevel];
    console.log(bonusRate)
    const bonus = baseBonus * bonusRate;
    return bonus;
}

const baseBonus = 50;
const targetValue = 4;
const actualValue = 5;
const salesmanPerformance = actualValue/targetValue;

try {
    const bonus = calculateBonusSocialPerfomance(salesmanPerformance, baseBonus);
    console.log(`The computed bonus is: ${bonus}`);
} catch (error) {
    console.error(error.message);
}
