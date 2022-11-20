package HomeWork;

public class Team {
    String teamName;
    Participant[] teamMembers;

    public Team(String teamName, Participant[] teamMembers){
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public Participant[] getTeamMembers() {
        return teamMembers;
    }

    public void showResults(){
        for (Participant c: teamMembers){
            c.showResult();
        }
    }

    public void showFinishedMembers(){
        for (Participant c: teamMembers){
            if(c.isOnDistance())
                c.showResult();
        }
    }
}
