public class People {
    private String name;
    private int strength;
    public boolean passed = false;

    public People(String name, int strength) {
        this.name = name;
        this.strength = strength;
    }

    public void displayInfo() {
        System.out.println(this.name);        
    }

    public boolean passObstacleCourse(ObstacleCourse obstacleCourse){ 
        int startStrength = this.strength;
        for (Obstacle obstacle : obstacleCourse.obstacles) {
            startStrength -= obstacle.requiresStrength;
        }

        this.passed = startStrength >= 0;

        return this.passed;
    }
}