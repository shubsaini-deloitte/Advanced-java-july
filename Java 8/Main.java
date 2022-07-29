import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

class Student {
    private int id;
    private String name;
    private String email;
    private String dob;
    private String branch;
    private List<Integer> marks;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getBranch() {
        return branch;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public Student(int id, String name, String email, String dob, String branch, List<Integer> marks) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.branch = branch;
        this.marks = marks;
    }
}

public class Main {

    static List<Student> students = new ArrayList<>();


    public static void studentsWithGmail() {
        System.out.println("========================Students with Gmail==============================");
        List<Student> studentsWithGmail = students.stream().filter(student -> student.getEmail().toLowerCase().contains("gmail.com")).collect(Collectors.toList());

        studentsWithGmail.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch()));
    }

    public static void showAge() {
        System.out.println("========================Age Of All Students==============================");
        System.out.println("ID\t" + "Name\t" + "Age\t");
        students.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + findAge(student.getDob())));
    }

    public static void studentsWithGreaterThan25AndCSE() {
        System.out.println("========================studentsWithLessThan25==============================");

        List<Student> studentsWithGreaterThan25AndCSE = students.stream().filter(student -> findAge(student.getDob()) > 25 && student.getBranch().equalsIgnoreCase("cse")).collect(Collectors.toList());
        System.out.println("ID\t" + "Name\t" + "Email\t" + "DOB\t" + "Branch\t");
        studentsWithGreaterThan25AndCSE.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch()));
    }

    public static void studentsWithLessThan25() {
        System.out.println("========================studentsWithLessThan25==============================");

        List<Student> studentsWithLessThan25 = students.stream().filter(student -> findAge(student.getDob()) < 25).collect(Collectors.toList());
        System.out.println("ID\t" + "Name\t" + "Email\t" + "DOB\t" + "Branch\t");
        studentsWithLessThan25.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch()));

    }

    public static int findAge(String dob) {
        LocalDate dobDate = LocalDate.parse(dob);
        LocalDate curDate = LocalDate.now();
        return Period.between(dobDate, curDate).getYears();
    }

    public static void studentNameStartWithP() {
        System.out.println("========================studentNameStartWithP==============================");

        List<Student> studentsWithP = students.stream().filter(student -> student.getName().toLowerCase().startsWith("p")).collect(Collectors.toList());
        System.out.println("ID\t" + "Name\t" + "Email\t" + "DOB\t" + "Branch\t");
        studentsWithP.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch()));
    }

    public static void averageMarks() {
        System.out.println("========================Average Marks==============================");
        System.out.println("ID\t" + "Name\t" + "Average marks\t");
        students.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getMarks().stream().mapToInt(s -> s).summaryStatistics().getAverage()));
    }

    public static void sortStudentAccordingToBranch() {
        System.out.println("========================Sorted students==============================");
        students.sort(Comparator.comparing(Student::getBranch));
        System.out.println("ID\t" + "Name\t" + "Email\t" + "DOB\t" + "Branch\t");
        students.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch()));
    }

    public static void branchStudent(String branchName) {
        System.out.println("========================" + branchName + " students==============================");
        List<Student> branchStudent = students.stream().filter(student -> student.getBranch().equals(branchName)).collect(Collectors.toList());
        System.out.println("ID\t" + "Name\t" + "Email\t" + "DOB\t" + "Branch\t");
        branchStudent.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch()));

    }

    public static void addStudent(int id, String name, String email, String dob, String branch,

                                  ArrayList<Integer> integers) {
        students.add(new Student(id, name, email, dob, branch, integers));
        System.out.println("========================Student " + name + " Added ==============================");
    }

    public static void showStudents() {
        System.out.println("========================All the Students are==============================");
        System.out.println("ID\t" + "Name\t" + "Email\t" + "DOB\t" + "Branch\t");
        students.forEach(student -> System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getEmail() + "\t" + student.getDob() + "\t" + student.getBranch() + "\t"));

//        + student.getMarks().stream().mapToInt(s -> s).sum()
    }

    public static void showOption() {
        System.out.println("0 : To Quit");
        System.out.println("1 : To see all students");
        System.out.println("2 : To see a specific student");
        System.out.println("3 : To add a student");
        System.out.println("4 : To remove a student");
        System.out.println("5 : Students of a specific branch: ");
        System.out.println("6 : Sort students according to branch: ");
        System.out.println("7 : Average marks of all student: ");
        System.out.println("8 : Students Name with P: ");
        System.out.println("9 : Students with less than 25 years ");
        System.out.println("10 : Students with greater than 25 years and belong to CSE ");
        System.out.println("11 : Age Of all students ");
        System.out.println("12 : Students with gmail ");


        System.out.println("========================Choose an option to continue:==============================");


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = 1;

        System.out.println("Hello world!");

        while (true) {
            System.out.println("\n\n\n================================================================");
            showOption();
            int n = scanner.nextInt();
            if (n == 0) break;
            switch (n) {
                case 1:
                    showStudents();
                    break;
                case 2:
                case 4:

                    break;

                case 3:
                    addStudent(c++, "D", "d@d.com", "1999-07-01", "BTECH", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "D", "d@d.com", "1999-07-01", "MCA", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "D", "d@d.com", "1999-07-01", "BTECH", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "D", "d@d.com", "1999-07-01", "MCA", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "p", "d@d.com", "1999-07-01", "MCA", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "p", "d@d.com", "1990-07-01", "MCA", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "v", "d@d.com", "1990-07-01", "CSE", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    addStudent(c++, "v", "d@gmail.com", "1990-07-01", "CSE", new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50)));
                    break;

                case 5:
                    branchStudent("BTECH");
                    break;

                case 6:
                    sortStudentAccordingToBranch();
                    break;

                case 7:
                    averageMarks();
                    break;
                case 8:
                    studentNameStartWithP();
                    break;
                case 9:
                    studentsWithLessThan25();
                    break;
                case 10:
                    studentsWithGreaterThan25AndCSE();
                    break;
                case 11:
                    showAge();
                    break;
                case 12:
                    studentsWithGmail();
                    break;
            }
        }
    }
}