package HomeWork.obstacles;

import HomeWork.Participant;

public class Cross extends Obstacle{
    private int distance;

    public Cross(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Participant participant) {
        participant.run(distance);
    }
}
