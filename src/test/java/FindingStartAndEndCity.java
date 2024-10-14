import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindingStartAndEndCity {

    public static void main(String[] args) {

        List<City> list = new ArrayList<>();
        list.add(new City("B","C"));
        list.add(new City("C","D"));
        list.add(new City("A","B"));
        list.add(new City("D","E"));
        list.add(new City("E","F"));
        City<String> city = findCity(list);
        System.out.println("Start ="+city.getStartCity() +", end="+city.getEndCity());
    }

    static City findCity(List<City> list) {
        List<String> newList = new ArrayList<>();

        list.forEach(city -> {
           String startCity = (String) city.getStartCity();
           String endCity = (String)  city.getEndCity();
            if(newList.contains(startCity)) {
                newList.remove(startCity);
            }
            else {
                newList.add(startCity);
            }

            if(newList.contains(endCity)) {
                newList.remove(endCity);
            }
            else
                newList.add(endCity);
        });
        return new City<>(newList.get(0), newList.get(1));
    }
}
class City<T> {

    private T startCity;
    private T endCity;

    public City(T startCity, T endCity) {
        this.startCity=startCity;
        this.endCity=endCity;
    }

    public T getStartCity() {
        return startCity;
    }

    public T getEndCity() {
        return endCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City<?> city = (City<?>) o;
        return Objects.equals(startCity, city.startCity) && Objects.equals(endCity, city.endCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startCity, endCity);
    }
}
