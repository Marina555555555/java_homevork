public class Team {
    private String name;
    private People[] participants;
    public int passedParticipantsCount = 0;

    public Team(String name, People[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public String getName() {
        return this.name;
    }

    public void displayInfoAll() {
        System.out.println(this.name);
        for (People participant : this.participants) {
                participant.displayInfo();                
        }
    }
    
    public void displayInfoPassed() {
        System.out.println(this.name);
        if (this.passedParticipantsCount > 0) {
            for (People participant : this.participants) {
                if (participant.passed) {
                    participant.displayInfo();                
                }
            }
        } else {
            System.out.println("Никто не прошел полосу препятствий");
        }
    }


    public void passObstacleCourse(ObstacleCourse obstacleCourse) {
        for (People participant : this.participants) {
            if (participant.passObstacleCourse(obstacleCourse)) {
                this.passedParticipantsCount += 1;
            }
        }
    }
}

