package com.employee;

import java.util.Scanner;

public class EmployeeApp {
	public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Position: ");
                        String position = sc.nextLine();
                        System.out.print("Salary: ");
                        double salary = sc.nextDouble();
                        dao.addEmployee(name, position, salary);
                        break;
                    case 2:
                        dao.viewEmployees();
                        break;
                    case 3:
                        System.out.print("Employee ID: ");
                        int idU = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New Position: ");
                        String newPosition = sc.nextLine();
                        System.out.print("New Salary: ");
                        double newSalary = sc.nextDouble();
                        dao.updateEmployee(idU, newPosition, newSalary);
                        break;
                    case 4:
                        System.out.print("Employee ID: ");
                        int idD = sc.nextInt();
                        dao.deleteEmployee(idD);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (choice != 0);

        sc.close();
    }
}
