public class ObstacleCourse {
    public Obstacle[] obstacles;

    public ObstacleCourse(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void pass(Team teamA, Team teamB){
        teamA.passObstacleCourse(this);
        teamB.passObstacleCourse(this);
    }
}
