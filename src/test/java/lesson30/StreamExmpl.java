package lesson30;

import java.util.List;
import java.util.stream.Stream;

public class StreamExmpl {
    public static void main(String[] args) {
        List<Car> cars = List.of(
                new Car("BMW", 2012),
                new Car("BMW", 2020),
                new Car("Bmw", 2014),
                new Car("Audi", 2013),
                new Car("TESLA", 2017),
                new Car("INFINITY", 2019)
        );

        Stream<Car> stream = cars.stream();
        Stream<Car> stream2 = cars.stream();

        Stream<Car> sortOfStream = stream
                .filter(x -> x.getYear() > 2012)
                .filter(x -> !"BMW".equalsIgnoreCase(x.getModel()));

        Stream<Car> sortOfStreamWithBmw = stream2
                .filter(x -> x.getYear() > 2012)
                .filter(x -> "BMW".equalsIgnoreCase(x.getModel()));


        sortOfStream.forEach(x -> System.out.println(x.getModel()));
        System.out.println("-----------------");
        sortOfStreamWithBmw.forEach(x -> System.out.println(x.getModel()));

    }
}
