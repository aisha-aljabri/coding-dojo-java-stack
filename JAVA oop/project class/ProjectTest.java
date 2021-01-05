public class ProjectTest {
    public static void main(String[] args) {

        Project p1 = new Project();
        p1.setName("Project 1");
        p1.setDescription("project 1 description");
        System.out.println("name: "+p1.getName()+", Description: "+ p1.getDescription());

        Project p2 = new Project("Project 2");
        p2.setDescription("project 2 description");
        System.out.println("name: "+p2.getName()+", Description: "+p2.getDescription());

        Project p3 = new Project("Project 3", "project 3 description");
        System.out.println(p3.elevatorPitch());
    }
}