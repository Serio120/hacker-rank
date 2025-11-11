import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.util.stream.Collectors.joining;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bufferedReader.readLine();

        String str2 = bufferedReader.readLine();

        List<Integer> result = Result.getRemovableIndices(str1, str2);

        System.out.println(
                (Object) result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
        );

        bufferedReader.close();
    }
}