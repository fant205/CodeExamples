package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JavaCodeExamples {

    public static void main(String[] args) {

        //fill collection
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
        }

        //remove element from collection.
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
            list.removeIf(x -> x < 0);
        }

        //print collection
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
            list.forEach(System.out::println);
        }

        //switch
        {
            LocalDate date = LocalDate.now();
            DayOfWeek day = date.getDayOfWeek();
            switch (day) {
                case MONDAY:
                    System.out.println("Понедельник");
                case TUESDAY:
                    System.out.println("Вторник");
                case WEDNESDAY:
                    System.out.println("Среда");
                case THURSDAY:
                    System.out.println("Четверг");
                case FRIDAY:
                    System.out.println("Пятница");
                case SATURDAY:
                    System.out.println("Суббота");
                case SUNDAY:
                    System.out.println("Воскресенье");
            }
        }

        {
            //string format
            System.out.println(String.format("%-10s Hi", "Alex"));//10 это кол-во пустых мест в строке
//          Вывод:Alex       Hi
            System.out.println(String.format("%-10.5s Hi", "ABCDEFGHIK"));
//          Вывод:ABCDE      Hi
            System.out.println(String.format("%3d", 1));
//          Вывод:1
            System.out.println(String.format("%05d", 1));//заполнить нулями перецифрой
//          Вывод:00001
        }

//      date
        Date date = new Date();
        System.out.println(date.toString());
		
		//Lambda
			//Объявляем интерфейс с 1 методом, аннотация @FunctionalInterface делает проверку что в интерейсе только 1 метод (можно создавать другие методы, но тогда они должны быть default)
			@FunctionalInterface
			public interface Operation {				
				int apply(int x, int y);				
			}
			
			public static void main(String[] args){
				//lambda
				Operation o1 = (x, y) -> x + y;
				
				//Method reference
					//1.
					Operation o2 = Integer::sum;
					//2.
					Operation o3 = Main::go;
				
				//Делаем вызов
				o1.apply(1,2);
				o2.apply(1,2);
				o3.apply(1,2);
				
			}
			
			//делаем метод который имеет такие же входные параметры и выходные и можно его использовать как method reference
			public static int go(int t, int z){
				return t / z;
			}
				
			
        
        
    }
}
