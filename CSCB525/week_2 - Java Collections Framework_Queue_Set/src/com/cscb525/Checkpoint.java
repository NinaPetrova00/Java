import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created By: Simeon Popov
 * Date: 18.10.2022 г.
 * Time: 1:41
 * Project Name: Homework -2
 */

public class Checkpoint {
    private final String nameOfCheckPoint;
    private Queue<Vehicle> vehicleQueue;

    public Checkpoint(String nameOfCheckPoint) {
        this.nameOfCheckPoint = nameOfCheckPoint;
        vehicleQueue = new PriorityQueue<>(Vehicle.byEmergency.thenComparing(Vehicle.byWeight.reversed()).reversed());
    }

    public boolean addVehicleToQue(Vehicle rhs){
        return vehicleQueue.offer(rhs);
    }

    public void goTroughtVehiclesInQue(){
        while (!vehicleQueue.isEmpty()){
            System.out.println("Premina: "+vehicleQueue.poll());
        }
    }

    @Override
    public String toString() {
        return "Checkpoint{" +
                "nameOfCheckPoint='" + nameOfCheckPoint + '\'' +
                ", vehicleQueue=" + vehicleQueue +
                '}';
    }
}
