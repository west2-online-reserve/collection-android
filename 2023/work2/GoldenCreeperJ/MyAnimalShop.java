package GoldenCreeperJ;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * @author GoldenCreeperJ
 * @date 2023/11/7
 */
public class MyAnimalShop implements AnimalsShop{
    private double remainder;
    private boolean istrade;
    private double profit=0;
    private LocalDate nowdate;
    private List<Animal> animalList =new ArrayList<>();
    private List<Customer> customerList = new ArrayList<>();


    public MyAnimalShop(double remainder, boolean istrade,LocalDate nowdate) {
        this.remainder = remainder;
        this.istrade = istrade;
        this.nowdate=nowdate;
    }

    public double getProfit() {
        return profit;
    }

    public LocalDate getNowdate() {
        return nowdate;
    }

    @Override
    public void buyNewAnimals(Animal animal) throws InsufficientBalanceException{
        if(this.remainder>=animal.getPrice()) {
            animalList.add(animal);
            this.remainder-=animal.getPrice();
            this.profit-=animal.getPrice();
            System.out.println("进货成功!\n");
        }else{
            throw new InsufficientBalanceException();
        }
    }

    @Override
    public void treatCustomers(Customer customer, Animal animal) throws AnimalNotFountException {
        if(this.istrade){
            boolean flag = true;
            for(Customer i:this.customerList){
                if(i.getName().equals(customer.getName())){
                    i.setArrivetimes(i.getArrivetimes()+1);
                    i.setLastestarrivaltime(this.nowdate);
                    flag=false;
                }
            }if(flag){
                customerList.add(customer);
            }flag=true;
            for (Animal i : this.animalList) {
                if (i.getClass().equals(animal.getClass())) {
                    this.remainder += i.getPrice();
                    this.profit += i.getPrice();
                    this.animalList.remove(i);
                    System.out.println(i);
                    System.out.println("出售成功!\n");
                    flag = false;
                    break;
                }
            }
            if (flag) {
                throw new AnimalNotFountException();
            }
        }else {
            System.out.println("歇业中，不出售动物!");
        }
    }

    @Override
    public void closeBusiness() {
        if(this.istrade){
            System.out.println("歇业了!");
            System.out.println("今日利润:"+this.profit+"元\n");
            System.out.println("今日顾客:");
            for(Customer i:customerList){
                if(i.getLastestarrivaltime().equals(this.nowdate)){
                    System.out.println(i);
                }
            }
            this.istrade = false;
        }else {
            System.out.println("已歇业!");
        }
    }

    public void openBusiness(){
        if(! this.istrade){
            System.out.println("开业了!");
            this.nowdate=this.nowdate.plusDays(1);
            this.istrade = true;
            this.profit=0;
        }else {
            System.out.println("已开业!");
        }

    }
}
