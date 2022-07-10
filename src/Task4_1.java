public class Task4_1 {
    public static void main(String[] args){
        People p1 = new People("Участник 1", 10);
        People p2 = new People("Участник 2", 15);
        People p3 = new People("Участник 3", 10);
        People p4 = new People("Участник 4", 10);

        People p5 = new People("Участник 5", 50);
        People p6 = new People("Участник 6", 50);
        People p7 = new People("Участник 7", 50);
        People p8 = new People("Участник 8", 10);
       
        Team teamA = new Team("Команда А", new People [] {p1, p2, p3, p4});
        Team teamB = new Team("Команда Б", new People [] {p5, p6, p7, p8});

        Running obstacle1 = new Running();
        Swimming obstacle2 = new Swimming();

        ObstacleCourse obstacleCourse = new ObstacleCourse(new Obstacle[] {obstacle1, obstacle2});

        System.out.println("Составы команд:");
        teamA.displayInfoAll();
        teamB.displayInfoAll();

        obstacleCourse.pass(teamA, teamB);

        System.out.println("Прошли полосу препятствий:");
        teamA.displayInfoPassed();
        teamB.displayInfoPassed();

        if (teamA.passedParticipantsCount == teamB.passedParticipantsCount) {
            System.out.println("Ничья");
            return;
        }
        
        if (teamA.passedParticipantsCount > teamB.passedParticipantsCount) {
            System.out.printf("Победила команда: %s", teamA.getName());

            return;
        }
        
        if (teamA.passedParticipantsCount < teamB.passedParticipantsCount) {
            System.out.printf("Победила команда: %s", teamB.getName());

            return;
        }
    }
}
    