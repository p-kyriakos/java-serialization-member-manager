package Program;

import java.util.ArrayList;
import java.util.Scanner;

import static Program.Katalogos.deserializeMember;
import static Program.Katalogos.serializeMember;

public class MainProgram {
    public static void main(String[] args) {
        ArrayList<Member> members = deserializeMember();

        try (Scanner scanner = new Scanner(System.in)) {
            int choice = 0;

            while (choice != 7) {
                printMenu();
                choice = readInt(scanner);

                switch (choice) {
                    case 1:
                        showMembers(members);
                        break;
                    case 2:
                        addMember(scanner, members);
                        break;
                    case 3:
                        searchByName(scanner, members);
                        break;
                    case 4:
                        searchByCode(scanner, members);
                        break;
                    case 5:
                        editMember(scanner, members);
                        break;
                    case 6:
                        deleteMember(scanner, members);
                        break;
                    case 7:
                        System.out.println("Τερματισμός εφαρμογής.");
                        break;
                    default:
                        System.out.println("Μη έγκυρη επιλογή. Προσπαθήστε ξανά.");
                        break;
                }
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Προβολή όλων των μελών");
        System.out.println("2. Προσθήκη νέου μέλους");
        System.out.println("3. Αναζήτηση βάσει ονόματος");
        System.out.println("4. Αναζήτηση βάσει κωδικού");
        System.out.println("5. Επεξεργασία μέλους βάσει κωδικού");
        System.out.println("6. Διαγραφή μέλους βάσει κωδικού");
        System.out.println("7. Έξοδος");
        System.out.print("Επιλέξτε λειτουργία: ");
    }

    private static int readInt(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Παρακαλώ δώστε αριθμό επιλογής: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void showMembers(ArrayList<Member> members) {
        if (members.isEmpty()) {
            System.out.println("Δεν υπάρχουν καταχωρημένα μέλη.");
            return;
        }

        for (Member member : members) {
            System.out.println(member);
        }
    }

    private static void addMember(Scanner scanner, ArrayList<Member> members) {
        Member member = new Member();

        System.out.print("Εισάγετε κωδικό: ");
        member.setCode(scanner.next());

        System.out.print("Εισάγετε ονοματεπώνυμο: ");
        member.setFullName(scanner.next());

        System.out.print("Εισάγετε ρόλο: ");
        member.setRole(scanner.next());

        System.out.print("Εισάγετε email: ");
        member.setEmail(scanner.next());

        members.add(member);
        serializeMember(members);
        System.out.println("Το μέλος εισήχθη επιτυχώς.");
    }

    private static void searchByName(Scanner scanner, ArrayList<Member> members) {
        System.out.print("Εισάγετε όνομα για αναζήτηση: ");
        String fullName = scanner.next();
        Member member = findByName(members, fullName);

        if (member == null) {
            System.out.println("Δεν βρέθηκε μέλος με αυτό το όνομα.");
        } else {
            System.out.println(member);
        }
    }

    private static void searchByCode(Scanner scanner, ArrayList<Member> members) {
        System.out.print("Εισάγετε κωδικό για αναζήτηση: ");
        String code = scanner.next();
        Member member = findByCode(members, code);

        if (member == null) {
            System.out.println("Δεν βρέθηκε μέλος με αυτόν τον κωδικό.");
        } else {
            System.out.println(member);
        }
    }

    private static void editMember(Scanner scanner, ArrayList<Member> members) {
        System.out.print("Εισάγετε κωδικό για τροποποίηση στοιχείων: ");
        String code = scanner.next();
        Member member = findByCode(members, code);

        if (member == null) {
            System.out.println("Δεν βρέθηκε μέλος με αυτόν τον κωδικό.");
            return;
        }

        System.out.println(member);
        System.out.print("Εισάγετε νέο ονοματεπώνυμο: ");
        member.setFullName(scanner.next());

        System.out.print("Εισάγετε νέο ρόλο: ");
        member.setRole(scanner.next());

        System.out.print("Εισάγετε νέο email: ");
        member.setEmail(scanner.next());

        serializeMember(members);
        System.out.println("Τα στοιχεία ενημερώθηκαν.");
    }

    private static void deleteMember(Scanner scanner, ArrayList<Member> members) {
        System.out.print("Εισάγετε κωδικό για διαγραφή μέλους: ");
        String code = scanner.next();
        Member member = findByCode(members, code);

        if (member == null) {
            System.out.println("Δεν βρέθηκε μέλος με αυτόν τον κωδικό.");
            return;
        }

        members.remove(member);
        serializeMember(members);
        System.out.println("Το μέλος διαγράφηκε.");
    }

    private static Member findByCode(ArrayList<Member> members, String code) {
        for (Member member : members) {
            if (member.getCode().equals(code)) {
                return member;
            }
        }
        return null;
    }

    private static Member findByName(ArrayList<Member> members, String fullName) {
        for (Member member : members) {
            if (member.getFullName().equals(fullName)) {
                return member;
            }
        }
        return null;
    }
}
