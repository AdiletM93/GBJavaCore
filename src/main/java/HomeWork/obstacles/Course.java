package HomeWork.obstacles;

import HomeWork.Participant;
import HomeWork.Team;

public class Course {
    Obstacle[] obstacles;

    public Course(Obstacle[] obstacles){
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        Participant[] teamMembers = team.getTeamMembers();
        if(teamMembers.length > 0){
            for (Participant c: teamMembers){
                for (Obstacle o: obstacles){
                    o.doIt(c);
                    if (!c.isOnDistance())
                        break;
                }
            }
        } else {
            System.out.println("Нет участников!");
        }
    }
}
