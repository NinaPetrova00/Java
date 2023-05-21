import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Vehicle first = new Vehicle(BigDecimal.valueOf(15.6), true);
        Vehicle second = new Vehicle(BigDecimal.valueOf(16), false);
        Vehicle third = new Vehicle(BigDecimal.valueOf(30.4), true);
        Vehicle fourth = new Vehicle(BigDecimal.valueOf(115), false);
        Vehicle fifth= new Vehicle(BigDecimal.valueOf(2.5), true);

        Checkpoint kapitanAndreevo = new Checkpoint("kapitanAndreevo");

        System.out.println(kapitanAndreevo);
        kapitanAndreevo.addVehicleToQue(first);
        kapitanAndreevo.addVehicleToQue(second);
        kapitanAndreevo.addVehicleToQue(third);
        kapitanAndreevo.addVehicleToQue(fourth);
        kapitanAndreevo.addVehicleToQue(fifth);

        System.out.println(kapitanAndreevo);
        kapitanAndreevo.goTroughtVehiclesInQue();

        System.out.println(kapitanAndreevo);
    }
}