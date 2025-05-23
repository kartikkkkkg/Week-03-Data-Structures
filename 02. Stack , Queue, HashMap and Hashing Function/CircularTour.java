import java.util.LinkedList;
import java.util.Queue;

public class CircularTour {
    static class PetrolPump {
        int petrol;
        int distance;

        PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    public static int findTour(PetrolPump[] pumps) {
        int start = 0;
        int end = 1;
        int currentPetrol = pumps[start].petrol - pumps[start].distance;
        while (end != start || currentPetrol < 0) {
            while (currentPetrol < 0 && start != end) {
                currentPetrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % pumps.length;
                if (start == 0) return -1;
            }
            currentPetrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % pumps.length;
        }
        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
                new PetrolPump(4, 6),
                new PetrolPump(6, 5),
                new PetrolPump(7, 3),
                new PetrolPump(4, 5)
        };
        int start = findTour(pumps);
        System.out.println("The starting petrol pump is: " + start);
    }
}