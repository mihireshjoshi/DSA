import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * Advent-style Circular Dial puzzle (Parts 1 & 2)
 *
 * A dial has 100 positions labelled 0-99 and currently points to 50. You are given a list
 * of rotations expressed as strings such as "L68" or "R14":
 *   - 'L' rotates the dial left (decrementing the position) by the specified amount.
 *   - 'R' rotates the dial right (incrementing the position) by the specified amount.
 * The dial wraps around, so values are taken modulo 100.
 *
 * Part 1: Count the number of rotations that finish with the dial pointing exactly at 0.
 *
 * Part 2 (method 0x434C49434B): Count how many individual clicks cause the dial to point
 * at 0, including intermediate positions while the dial is still moving. For example,
 * R1000 from position 50 passes zero ten times even though it never stops there.
 *
 * The goal is to process the rotation sequence and return the Part 2 password: the total
 * number of times the dial points at 0 across the entire sequence.
 */

public class CircularDial {

    public int getPassword(String[] rotations) {
        int password = 0;
        int val = 50;
        for(String rotation : rotations) {
            char c = rotation.charAt(0);
            int n = Integer.parseInt(rotation.substring(1));

            // Debug: show current rotation and value before applying it
            System.out.println("Applying rotation: " + rotation + " | Start val = " + val);

            switch(c){
                case 'R':
                    password += (val + n) / 100; // part 2
                    val = (val + n) % 100;
                    break;
                case 'L':
                    if (val == 0) {
                        password += n / 100; // part 2
                    } else if (n >= val) {
                        int hits = 1 + (n - val) / 100;
                        password += hits; // part 2
                    }
                    val = ((val - n) % 100 + 100) % 100;
                    break;
            }

            // Debug: show value after applying the rotation
            System.out.println("After rotation: " + rotation + " | End val = " + val + " | Password = " + password + "\n");

            // part 1
            // if (val == 0) {
            //     password++;
            //     // Debug: notify when password counter increments
            //     System.out.println("Password incremented, current count = " + password);
            // }
        }

        // Debug: final result
        System.out.println("Final password count = " + password);
        return password;
    }

    /**
     * Utility method to read rotations from a text file.
     * Each line in the file becomes one element in the resulting String array.
     *
     * @param filePath path to the input file
     * @return String[] of rotations in the same order as the file
     * @throws IOException if the file cannot be read
     */
    public static String[] readRotationsFromFile(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Path.of(filePath));
        return lines.toArray(new String[0]);
    }

    public static void main(String[] args) {
        CircularDial circularDial = new CircularDial();
        try {
            // Adjust the path if you run from a different working directory
            String inputPath = "Java/problem_solving/input.txt";
            String[] rotations = readRotationsFromFile(inputPath);
            System.out.println(circularDial.getPassword(rotations));
        } catch (IOException e) {
            System.err.println("Failed to read rotations from file: " + e.getMessage());
        }
    }
}
