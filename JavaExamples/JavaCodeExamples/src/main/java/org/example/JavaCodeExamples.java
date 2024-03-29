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
				
				//Передача в функцию:
				calc(1, 2, o1);
				calc(1, 2, o2);
				calc(1, 2, o3);
				
				
			}
			
			//делаем метод который имеет такие же входные параметры и выходные и можно его использовать как method reference
			public static int go(int t, int z){
				return t / z;
			}
			
			//В жизни используется для передачи в функции
			public static int calc(int x, int y, Operation o){
				return o.apply(x, y);
			}	

			//Stream API
			
				//Базовые интерфейсы
					//forEach, peek
					Consumer<String> printer = System.out::println;
					printer.accept("Hello");
					
					//filter, anyMatch, allMatch, noneMatch	
					Predicate<Integer> isOdd = x -> x % 2 != 0;
					
					//map, FlatMap
					Function<String, Integer> length = String::length;
					System.out.pringln("length.apply("123"));
					
					//collect
					Supplier<Integer> supplier = () -> 1;
					Supplier<Map<String, Map<Integer, Set<Long>>>> supplier = HashMap::new;
				
				//Пример использования
				
					//filter odd and print
					Stream.of(1,2,3,4,5,6,7,8,9)
					.filter(x -> x % 2 == 0)
					.forEach(System.out::println);
					
					//increment all values by 1 and collect to list
					List<Integer> list = Stream.of(1,2,3,4,5)
						.map(x -> x + 2)
						.toList();
						
					System.out.println(list.toString());
	}
}