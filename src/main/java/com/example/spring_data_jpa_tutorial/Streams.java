package com.example.spring_data_jpa_tutorial;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Streams {
    public static void main(String[] args) {

        //1.Filter the Even Numbers
        List<Integer>numbers=List.of(2,3,15,20,16,17,18,31);
         List<Integer>evenNumbers=methodOfEvenNumber(numbers);
        System.out.println("evenNumbers :::"+evenNumbers);

       /* --------------------------------------------------------------------------*/
        //2.Convert String lowercase to UpperCase
        List<String>lowerCaseStrings=List.of("arun","pnb","kvb","idbi","spring");

        List<String>upperCase=lowerCaseStrings.stream().
                map(Streams::toConvertingUpperCase).
                toList();
        System.out.println("upperCase:::::"+upperCase);
        /*  -------------------------------------------------------------------------*/

        //3.Total sum of lenth of String
        int stringLen=lowerCaseStrings.stream().mapToInt(String::length).sum();

        lowerCaseStrings.stream().peek(s-> System.out.println(" Length Of word "+s+" is "+s.length())).toList();
        System.out.println("stringLen:::::::"+stringLen);

        /*  -------------------------------------------------------------------------*/

        //3.Find Second Maximum in a array
        List<Integer>arrayList=new ArrayList<>(List.of(11,55,-88,10,-87,-63,2,55,1));

        Optional<Integer>finalResult=toFindSecondMaxArray(arrayList);

        System.out.println(" Second Maximun array:::::::"+finalResult);

        /*  -------------------------------------------------------------------------*/

        //4.Grouping
           List<Map<String,Object>>student=new ArrayList<>();
              Map<String,Object>s1=new HashMap<>();
                            s1.put("name","kamal");
                            s1.put("dept","CSE");
                            s1.put("marks",75);
                            student.add(s1);
            Map<String,Object>s2=new HashMap<>();
                            s2.put("name","Rajesh");
                            s2.put("dept","ECE");
                            s2.put("marks",80);
                            student.add(s2);
           Map<String,Object>s3=new HashMap<>();
                            s3.put("name","vimal");
                            s3.put("dept","Civil");
                            s3.put("marks",90);
                            student.add(s3);
        Map<String, Object> s4 = new HashMap<>();
                            s4.put("name", "Kavi");
                            s4.put("dept", "ECE");
                            s4.put("marks", 85);
                            student.add(s4);
        Map<String, Object> s5 = new HashMap<>();
                            s5.put("name", "Kavi");
                            s5.put("dept", "ECE");
                            s5.put("marks", 85);
                            student.add(s5);

          Map<String,Double>avgBydept=getAverageAndDept(student);
        System.out.println("avgBydept:::::::::::"+avgBydept);


    }
    public static Map<String,Double> getAverageAndDept(List<Map<String,Object>> student) {
        return student.stream().
                collect(Collectors.groupingBy(s->(String) s.get("dept"),
                        Collectors.averagingDouble(s->((Number)s.get("marks")).doubleValue())
                )
                );
    }

        public  static List<Integer> methodOfEvenNumber(List<Integer> numbers){

        return numbers.
                stream().
                filter(n->n % 2==0).toList();
    }

    public static String toConvertingUpperCase(String s){

        return  s.toUpperCase();

    }

    public static Optional<Integer>toFindSecondMaxArray(List<Integer> n){

        return n.stream().
                distinct().
                sorted(Comparator.reverseOrder()).
                skip(1).
                findFirst();
    }
}
