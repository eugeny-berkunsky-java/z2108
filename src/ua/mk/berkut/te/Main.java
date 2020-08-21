package ua.mk.berkut.te;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
	    new Main().run();
    }

    private void run() {
        //
    }

    public List<String> readAll(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            List<String> result = new ArrayList<>();
//            String line;
//            while ((line = reader.readLine())!=null) {
//                result.add(line);
//            }
//            return result;
            return reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public int maxLength(List<String> list) {
        if (list.isEmpty()) return -1;
        int max = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            int length = list.get(i).length();
            if (length > max) max = length;
        }
        return max;
    }

    public String concatLines(int start, int count, List<String> lines) {
        List<String> list = lines.subList(start, start + count);
//        StringBuilder sb = new StringBuilder(list.get(0));
//        for (int i = 1; i < count; i++) {
//            sb.append("\n").append(list.get(i));
//        }
//        return sb.toString();
        return String.join("\n", list);
    }

    public int countWordsByLength(String line, int length) {
        String[] strings = line.split("\\W+");
        int count = 0;
        for (String string : strings) {
            if (string.length()==length) count++;
        }
        return count;
    }
}
