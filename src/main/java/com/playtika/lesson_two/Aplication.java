package com.playtika.lesson_two;

import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Aplication {
    public static void main(String[] args) {

        System.out.println("end\"\'\n\t\r" + "end");
        // conmpare equals
        String token = null;
        if ("HTML".equals(token)) {
            System.out.println("MACH TOKEN");
        }
        // compose
        //String fullName = "Roman" + "Filipchak:" + "Kiev";
        String location = "Kiev";
        String name = "Roman";
        double money = 10.56;

        //String fullName = String.format("%s Filipchak:%s", name, location);
        String fullName = String.format("%s Filipchak: %S has $%f", name, location, money);

        fullName = name + "Filipchak from " + location + " has $ " + money;

        //fullName = name + "Filipchak from " + location + "has $ " +money;

        fullName = new StringBuilder()
                .append(name)
                .append("Filipchak from ")
                .append(location)
                .append("has $ ")
                .append(money).toString();

        fullName = MessageFormat.format("{0}Filipchak from {1}has $ {2}", name, location, money);

        System.out.println(fullName);
        // find

        String text = "I have 5 dollars";
        //text.indexOf("have");
        System.out.printf(String.format("Found substring: %s", text.indexOf("have")));
        System.out.println();
        System.out.println(String.format("Found substring: %s", text.indexOf("has")));


        System.out.println(text.matches(".*5.*"));

        //split

        System.out.println(Arrays.toString(text.split(" ")));

        StringTokenizer tokenizer = new StringTokenizer(text);

        System.out.println(tokenizer.countTokens());
//        while (tokenizer.hasMoreElements()){
//            System.out.println(tokenizer.nextToken());
//        }

        // 1 - String
        // 2 - Appache commons lang - StringUtils
        // 3 - String Google guava
        //_______________________________________________________________________-Collections


        int[] numbers = new int[5];
        int[] numbers1 = new int[]{1, 2, 4, 111, 6, 7, 8, 9};

        System.out.println(numbers[3]);

        String[] sentane = new String[6];
        String[] sentane1 = new String[]{"ss", "dd", "ff"};

        System.out.println(sentane[5]);
        System.out.println(numbers1.length);
        System.out.println(sentane1.length);

        Arrays.sort(numbers1);
        System.out.println(Arrays.toString(numbers1));

        Arrays.fill(numbers, 4);
        System.out.println(Arrays.toString(numbers));
        // 1 - Arrays
        // 2 - Appache commons lang - ArraysUtils
        // 3 - String Google guava


        // List

        List<String> list = new ArrayList<>(5);
        System.out.println(list.size());

        list.add("as");
        System.out.println(list.size());
        System.out.println(list);

        System.out.println(list.get(0));

        list.toArray();
        list.toArray(new String[list.size()]);// если чтото принимает на вход еррей


        //list.add(3,"bb");
        //list.set(3,"bb");
        list.clear();
        System.out.println(list.size());

        //Set - уникальность еллементов

        Set<String> set = new HashSet<>();//
        set.add("dd");
        set.add("aa");
        set.add("aa");
        System.out.println(set.size());

        for (String s : set) {//iter - попробовать
            System.out.println(s);
        }

        Set<String> set2 = new LinkedHashSet<>();

        set2.add("aa");
        set2.add("aa");
        set2.add("dd");
        System.out.println(set2);
        // MAP___

        Map<String, Integer> stats = new HashMap<>();// ctrl +shift+ space
        stats.put("have", 5);
        stats.put("roman", 45);
        stats.put("roman", 46);
        stats.put("Roman", 46);


        System.out.println(stats);
        System.out.println(stats.size());

        for (Map.Entry<String, Integer> entry : stats.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
        for (String word : stats.keySet()) {
            Integer count = stats.get(word);
            System.out.println(word + " :" + count);

        }


        //QUEue__________dequeue

        Deque<String> queue = new ArrayDeque<>();
        queue.add("Roman");
        queue.add("Fill");


        System.out.println(queue.poll());
        System.out.println(queue.poll());


        // Exeption

        try {
            int result = printHello("roman");
            printHello(null);
        } catch (IllegalStateException e) {
            System.out.println(e);
        } finally {
            //
        }
    }


    public static int printHello(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name is requared");
        }
        System.out.println(name + ", Hello");
        return name.length();
    }

    public int countWord(String text) {
        if(text == null){
            return 0;
        }

        String trimmedText = text.trim();
        if ("".equals(trimmedText)){
            return 0;
        }

        return trimmedText.split("\\s+").length;

//     text.split(" ").length;
//
//        List<String> arrayList = Arrays.asList(text.split(" "));
//        List<String> strings = arrayList.stream().filter(input -> input != " ").collect(toList());
    }


}







