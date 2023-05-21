package vehicles;

public class MotorVehicleNested {
    private String brand;
    private double price;
    private InternalCombustionEngine internalCombustionEngine;

    public MotorVehicleNested(String brand, double price, InternalCombustionEngine internalCombustionEngine) {
        this.brand = brand;
        this.price = price;
        this.internalCombustionEngine = internalCombustionEngine;
    }

    public static class InternalCombustionEngine{
        public InternalCombustionEngine(double power, FuelType fuelType) {
            this.power = power;
            this.fuelType = fuelType;
        }

        private double power;
        private FuelType fuelType;

        @Override
        public String toString() {
            return "InternalCombustionEngine{" +
                    "power=" + power +
                    ", fuelType=" + fuelType +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MotorVehicleNested{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", internalCombustionEngine=" + internalCombustionEngine +
                '}';
    }
}
