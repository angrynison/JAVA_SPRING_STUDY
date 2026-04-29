package hello.core.singleton;

public class StatefulService {

    private int price;


    //싱글톤 컨테이너는 무상태로 설계하기 위해 지역변수를 사용한다
    public int order(String name, int price) {
        System.out.println("name = " + name + ", price = " + price);
//        this.price = price;
        return price;
    }

//    public int getPrice() {
//        return price;
//    }


}
