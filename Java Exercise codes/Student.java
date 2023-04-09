public class Student {
    private String name;
    int age;

    public Student(String n) {
        this.name = n;
        age = 0;
    }

    public static boolean isEqual(Student s1, Student s2) {
        return s1 == s2;
    }

    public static void main(String[] args) {
        Student s1 = new Student("Abhijit");
        Student s2 = new Student("Abhi");
        Student s3 = s1;
        System.out.println(isEqual(s2, s1));
        System.out.println(isEqual(s1, s3));
    }

}