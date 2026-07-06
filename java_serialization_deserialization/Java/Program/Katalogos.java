package Program;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Katalogos {
    private static final String DATA_FILE = "member.ser";

    static void serializeMember(ArrayList<Member> list) {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            output.writeObject(list);
        } catch (IOException e) {
            throw new RuntimeException("Αποτυχία αποθήκευσης μελών.", e);
        }
    }

    static ArrayList<Member> deserializeMember() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            return (ArrayList<Member>) input.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Αποτυχία ανάγνωσης μελών.", e);
        }
    }
}
