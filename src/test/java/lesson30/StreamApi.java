package lesson30;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("two");

//        for (String i : list){
//            System.out.println(i);
//        }

//����� �� �����
//        Stream<String> exampleStream = list.stream();
//        exampleStream.forEach(x -> System.out.println(x));

//        Set<String> exampleStream = list
//                .stream()
//                .collect(Collectors.toSet());
//        exampleStream.forEach(x -> System.out.println(x));

// ������
//        Set<String> exampleStream = list.stream()
//                .filter(x -> x.equals("two"))
//                .collect(Collectors.toSet());
//        exampleStream.forEach(x -> System.out.println(x));

// � ������� ��������
//        Stream<String> exmplStream = list.stream()
//                .map(x -> x.toUpperCase());
//        exmplStream.forEach(x -> System.out.println(x));

//����� �������� ���������
//        Stream<String> exampleStream = Stream.of("one", "two");

//��������� ������ � ����� ������ (flatMap)
//        List<String> exampleStreamList = (List<String>) Stream.of(List.of("one","two"), List.of("three", "four"))
//                .flatMap(x -> x.stream().collect(Collectors.toList()));

//        int count = 0;
//        for (int element : new int[]{1,2,3}){
//            count+=element;
//        }
//        System.out.println(count);
//
//        int countExmpl = Stream.of(1,2,3)
//                .reduce(0,(count, element) ->count + element);
//        System.out.println(countExmpl);

        //sorted - ���������� �� ��������
//        Stream.of("one","two").sorted().collect(Collectors.toList());

        //limit - ������� ��������� ���������
//        Stream.of("one","two").limit(1).collect(Collectors.toList());

//distinct - ���������� ��������
//        Stream.of("one","two", "two").distinct().collect(Collectors.toList());

//skip - ��������� �������� one
//        Stream.of("one","two", "three").skip(1).collect(Collectors.toList());


    }
}
