package navbar;

import java.util.Scanner;

public class Navbar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("***************STUDENT MANAGE***************************");
        System.out.println("1. Show List Student\n" +
                "2. Create Student\n" +
                "3. Update Student\n" +
                "4. Delete Student\n" +
                "5. Sort Student By Age ASC (Tăng Dần).\n" +
                "6. Exit");
        System.out.print("nhap chuc nang:");
        int n = scanner.nextInt();
        Student student = new Student();
        Student[] listStudent = new Student[100];
        listStudent[0] = new Student(1, "tuan", 26);
        listStudent[1] = new Student(2, "long", 22);
        listStudent[2] = new Student(3, "trinh", 28);
        int leng = 3;
        while (true) {
            if (n==6){
                break;
            }

            switch (n) {
                case 1:
                    for (int i = 0; i < leng; i++) {
                        System.out.println(listStudent[i]);
                    }
                    break;
                case 2:
                    System.out.println("nhap ten");
                    String name = scanner.next();
                    System.out.println("nhap tuoi");
                    int age = scanner.nextInt();
                    listStudent[leng] = new Student(leng + 1, name, age);
                    ++leng;
                    for (int i = 0; i < leng; i++) {
                        System.out.println(listStudent[i]);
                    }
                    break;
                case 3:
                    System.out.print("nhap phan tu can up:");
                    int upId = scanner.nextInt();
                    System.out.print(listStudent[upId].name + "=>>>:");
                    String nameup = scanner.next();
                    listStudent[upId].name = nameup;
                    System.out.print(listStudent[upId].age + "=>>:");
                    int ageUp = scanner.nextInt();
                    listStudent[upId].age = ageUp;
                    for (int i = 0; i < leng; i++) {
                        System.out.println(listStudent[i]);
                    }
                    break;
                case 4:
                    System.out.print("nhap thu tu phan tu can delete:");
                    int delete = scanner.nextInt();
                    Student[] newSt = new Student[leng - 1];
                    for (int i = 0; i < delete; i++) {
                        newSt[i] = listStudent[i];
                    }
                    for (int i = delete + 1; i < leng; i++) {
                        newSt[i - 1] = listStudent[i];
                    }
                    leng--;
                    for (int i = 0; i < newSt.length; i++) {
                        listStudent[i]=newSt[i];
                    }
                    break;
                case 5:
                    for (int i = 0; i < leng; i++) {
                        for (int j = 0; j < leng; j++) {
                            Student tem;
                            if (listStudent[i].age <= listStudent[j].age) {
                                tem = listStudent[i];
                                listStudent[i] = listStudent[j];
                                listStudent[j] = tem;
                            }
                        }
                    }
                    for (int i = 0; i < leng; i++) {
                        System.out.println(listStudent[i]);
                    }
                    break;
            }
            System.out.print("nhap lai chuc nang:");
            n=scanner.nextInt();
        }
    }

}
