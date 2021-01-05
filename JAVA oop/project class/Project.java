public class Project{
    String name;
    String desc;

    public Project(){
    }

    public Project(String name){
        this.name = name;
    }

    public Project(String name, String desc){
        this.name=name;
        this.desc=desc;
    }

    public String elevatorPitch(){
        return "name: "+this.name+", Description: "+this.desc;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return this.desc;
    }

    public void setDescription(String desc){
        this.desc = desc;
    }
}
