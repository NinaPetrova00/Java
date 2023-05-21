package vehicles;

public class MotorVehicleInner {
    private String brand;
    private double price;
    private InternalCombustionEngineInner internalCombustionEngineInner;

    public MotorVehicleInner(String brand, double price, double power, FuelType fuelType) {
        this.brand = brand;
        this.price = price;
        this.internalCombustionEngineInner = new InternalCombustionEngineInner(power, fuelType);
    }

    public class InternalCombustionEngineInner {
        public InternalCombustionEngineInner(double power, FuelType fuelType) {
            this.power = power;
            this.fuelType = fuelType;
        }

        private double power;
        private FuelType fuelType;

        @Override
        public String toString() {
            return "InternalCombustionEngineInner{" +
                    "power=" + power +
                    ", fuelType=" + fuelType +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "MotorVehicleInner{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", internalCombustionEngineInner=" + internalCombustionEngineInner +
                '}';
    }
}
