package xany.model.JavaConfiguredModels;

public class SoccerCoach implements Coach {
    private Team team;

    public SoccerCoach(Team t) {
        this.team = t;
    }

    @Override
    public Team getTeam() {
        return team;
    }

    @Override
    public String toString() {
        return "SoccerCoach{" +
                "team=" + team +
                '}';
    }
}
