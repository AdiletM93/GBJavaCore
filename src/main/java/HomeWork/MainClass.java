package HomeWork;

import HomeWork.obstacles.Course;
import HomeWork.obstacles.Cross;
import HomeWork.obstacles.Obstacle;
import HomeWork.obstacles.Pool;

public class MainClass {
     public static void main(String[] args){
          Participant[] participants = {new Cat("Гарфилд"), new Dog("Хатико"), new Wolf("Коксерек"), new Turtle("Лео")};
          Obstacle[] obstacles = {new Cross(500), new Pool(30)};

          Team team = new Team("Avengers", participants);

          System.out.println("Создание команды");
          System.out.println(team.getTeamName());

          System.out.println("Участники");
          team.showResults();

          Course course = new Course(obstacles);

          System.out.println("Команда на старт");
          course.doIt(team);

          System.out.println("Результаты команды");
          team.showResults();

          System.out.println("Участники финишировали");
          team.showFinishedMembers();
     }
}
