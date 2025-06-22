abstract class Person {
    String name, nic;
    int age;

    Person(String name, String nic, int age) {
        this.name = name;
        this.nic = nic;
        this.age = age;
    }
}

class Student extends Person {
    double gpa1, gpa2, gpa3, gpa4, finalGpa;

    Student(String name, String nic, int age, double gpa1, double gpa2, double gpa3, double gpa4) {
        super(name, nic, age);
        this.gpa1 = gpa1;
        this.gpa2 = gpa2;
        this.gpa3 = gpa3;
        this.gpa4 = gpa4;
    }

    double calculateFinalGpa() {
        finalGpa = (gpa1 + gpa2 + gpa3 + gpa4) / 4;
        return finalGpa;
    }

    String getFinalResult() {
        if (finalGpa >= 3.70)
            return "First Class";
        else if (finalGpa >= 3.30)
            return "Second Class (Upper Division)";
        else if (finalGpa >= 3.00)
            return "Second Class (Lower Division)";
        else
            return "Pass";
    }
}

abstract class StaffMember extends Person {
    double basicSalary, loanInstallment;
    double COLA = 7800.00;

    StaffMember(String name, String nic, int age, double basicSalary, double loanInstallment) {
        super(name, nic, age);
        this.basicSalary = basicSalary;
        this.loanInstallment = loanInstallment;
    }

    abstract double getSalary();
}

class AcademicStaff extends StaffMember {
    int academicAllowance = 25;

    AcademicStaff(String name, String nic, int age, double basicSalary, double loanInstallment) {
        super(name, nic, age, basicSalary, loanInstallment);
    }

    double getSalary() {
        return basicSalary + COLA + (basicSalary * academicAllowance / 100) - loanInstallment;
    }
}

class NonAcademicStaff extends StaffMember {
    double overtimeHours;

    NonAcademicStaff(String name, String nic, int age, double basicSalary, double loanInstallment, double overtimeHours) {
        super(name, nic, age, basicSalary, loanInstallment);
        this.overtimeHours = overtimeHours;
    }

    double overtimeAmount() {
        return (basicSalary / (20 * 8)) * overtimeHours;
    }

    double getSalary() {
        return basicSalary + COLA + overtimeAmount() - loanInstallment;
    }
}

public class PersonDemo {
    public static void main(String[] args) {
        // Student example
        Student student = new Student("Tasuntha", "123456789V", 21, 3.5, 3.7, 3.8, 3.9);
        System.out.println(" Student Final GPA: " + student.calculateFinalGpa());
        System.out.println(" Degree Classification: " + student.getFinalResult());

        // Academic staff example
        AcademicStaff academicStaff = new AcademicStaff("John Doe", "987654321V", 40, 50000, 5000);
        System.out.println(" Academic Staff Salary: Rs. " + academicStaff.getSalary());

        // Non-academic staff example
        NonAcademicStaff nonAcademicStaff = new NonAcademicStaff("Jane Smith", "112233445V", 35, 45000, 4000, 10);
        System.out.println(" Non-Academic Staff Salary: Rs. " + nonAcademicStaff.getSalary());
    }
}
