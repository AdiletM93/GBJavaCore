package HomeWork.obstacles;

import HomeWork.Participant;

public class Pool extends Obstacle{
    private int distance;

    public Pool(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participant participant) {
        participant.swim(distance);
    }
}
