import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'getRemovableIndices' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING str1
     *  2. STRING str2
     */

    public static List<Integer> getRemovableIndices(String str1, String str2) {
        List<Integer> removableIndices = new ArrayList<>();

        int n = str1.length();

        for (int i = 0; i < n; i++) {
            // Simulate the deletion of the character at position i
            int p1 = 0, p2 = 0;

            while (p1 < n) {
                if (p1 == i) {
                    p1++; // we skip the deleted character
                    continue;
                }

                if (p2 < str2.length() && str1.charAt(p1) == str2.charAt(p2)) {
                    p1++;
                    p2++;
                } else {
                    break;
                }
            }

            // If we have traversed all of str2, then deleting str1[i] works
            if (p2 == str2.length()) {
                removableIndices.add(i);
            }
        }

        if (removableIndices.isEmpty()) {
            removableIndices.add(-1);
        }

        return removableIndices;
    }
}