package vehicles;

public class Main {

    public static void main(String[] args) {
        // Boxing
        Integer integerObject = Integer.valueOf(100);
        Double doubleObject = Double.valueOf(90.9);

        System.out.println(integerObject);
        System.out.println(doubleObject);

        doubleObject = Double.valueOf("108.901");
        System.out.println(doubleObject);
        // Unboxing
        int i = integerObject.intValue();

        System.out.println(i);

        // Autoboxing
        integerObject = 200;
        System.out.println(integerObject);

        // Auto-unboxing
        i = integerObject;
        System.out.println(i);

        // Nested Classes
        MotorVehicleNested.InternalCombustionEngine internalCombustionEngine =
                new MotorVehicleNested.InternalCombustionEngine(3000, FuelType.DIESEL);

        MotorVehicleNested.InternalCombustionEngine internalCombustionEngine2 =
                new MotorVehicleNested.InternalCombustionEngine(4000, FuelType.GASOLINE);

        MotorVehicleNested motorVehicleNested =
                new MotorVehicleNested("BMW", 12000, internalCombustionEngine);
        System.out.println(motorVehicleNested);

        // Nested Classes
        MotorVehicleInner motorVehicleInner =
                new MotorVehicleInner("Pegeout", 10000, 2000, FuelType.GASOLINE);
        System.out.println(motorVehicleInner);
    }
}
