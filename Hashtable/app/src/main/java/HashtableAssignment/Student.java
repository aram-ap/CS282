package HashtableAssignment;


/**
 *
 * @author juneja_u
 */
public class Student {
    String name;
    int id;

    public Student(){
        name = "";
        id = 1;
    }
    public Student(String name, int id){
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", id=" + id + '}';
    }


}

