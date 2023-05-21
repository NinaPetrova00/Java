import java.math.BigDecimal;
import java.util.Comparator;

/**
 * Created By: Simeon Popov
 * Date: 18.10.2022 г.
 * Time: 1:40
 * Project Name: Homework -2
 */

public class Vehicle {
    private final BigDecimal weight;
    private final boolean isEmergencyVehicle;

    public Vehicle(BigDecimal weight, boolean isEmergencyVehicle) {
        this.weight = weight;
        this.isEmergencyVehicle = isEmergencyVehicle;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public boolean isEmergencyVehicle() {
        return isEmergencyVehicle;
    }

    public static Comparator<Vehicle> byWeight = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.weight.compareTo(o2.weight);
        }
    };

    public static Comparator<Vehicle> byEmergency = new Comparator<Vehicle>() {
        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return Boolean.compare(o1.isEmergencyVehicle,o2.isEmergencyVehicle);
        }
    };

    @Override
    public String toString() {
        return "Vehicle{" +
                "weight=" + weight +
                ", isEmergencyVehicle=" + isEmergencyVehicle +
                '}';
    }
}
