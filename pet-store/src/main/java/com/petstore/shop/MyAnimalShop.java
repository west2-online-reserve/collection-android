package com.petstore.shop;

import com.petstore.animal.Animal;
import com.petstore.animal.AnimalNameGenerator;
import com.petstore.animal.Cat;
import com.petstore.animal.ChineseRuralDog;
import com.petstore.animal.Gender;
import com.petstore.animal.GoldenHamster;
import com.petstore.animal.MiniPig;
import com.petstore.animal.Parrot;
import com.petstore.customer.Customer;
import com.petstore.exception.AnimalNotFoundException;
import com.petstore.exception.InsufficientBalanceException;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

//展开导包之后再大的气也消了嗯对吧就是。

/**
 * 我的宠物店（{@link AnimalShop} 的实现）。
 *
 * @author pet-store
 */
public class MyAnimalShop implements AnimalShop {

    /**
     * 初始默认余额
     */
    public static final double DEFAULT_BALANCE = 200.0;

    /**
     * 每天最多接待顾客数
     */
    public static final int MAX_CUSTOMERS_PER_DAY = 10;

    /**
     * 开业时间（小时）
     */
    public static final int OPEN_HOUR = 14;

    /**
     * 歇业时间（小时）
     */
    public static final int CLOSE_HOUR = 21;

    /**
     * 每位顾客推进的分钟数
     */
    public static final int MINUTES_PER_CUSTOMER = 40;

    /**
     * 进价占售价的比例
     */
    public static final double PURCHASE_RATIO = 0.2;

    private final ShopDate shopDate;
    private final AnimalNameGenerator nameGenerator = new AnimalNameGenerator();

    private double balance;
    private final List<Animal> animalList = new ArrayList<>();
    private final List<Customer> customerList = new ArrayList<>();
    private boolean isOpen;

    /**
     * 全部动物品种
     */
    public static final List<Class<? extends Animal>> SPECIES_CLASSES = List.of(
            ChineseRuralDog.class, Cat.class, MiniPig.class, Parrot.class, GoldenHamster.class);

    /**
     * 每类动物的进货候选货位（每类 5 个）
     */
    private final Map<Class<? extends Animal>, List<Animal>> candidateSlots = new HashMap<>();

    /**
     * 今日光顾顾客（含未成交）
     */
    private final List<Customer> todayVisitors = new ArrayList<>();
    /**
     * 今日成交金额
     */
    private double todaySales;
    /**
     * 今日进货花销
     */
    private double todayPurchaseCost;

    public MyAnimalShop(double balance) {
        this.balance = balance;
        // 自定营业日起始日期（不使用真实时间）
        this.shopDate = new ShopDate(LocalDate.of(2026, 1, 1));
    }

    public MyAnimalShop() {
        this(DEFAULT_BALANCE);
    }

    // ==================== 接口方法 ====================

    @Override
    public void buyAnimal(Animal animal) throws InsufficientBalanceException {
        double cost = animal.getPrice() * PURCHASE_RATIO;
        if (balance < cost) {
            throw new InsufficientBalanceException(
                    String.format("余额不足：需要 ¥%.2f，当前余额 ¥%.2f", cost, balance));
        }
        balance -= cost;
        animalList.add(animal);
        todayPurchaseCost += cost;
    }

    @Override
    public void entertainCustomer(Customer customer) throws AnimalNotFoundException {
        if (animalList.isEmpty()) {
            throw new AnimalNotFoundException("店内没有动物可卖！");
        }
        // 题目要求：出售店内第一只动物
        Animal sold = animalList.remove(0);
        balance += sold.getPrice();
        todaySales += sold.getPrice();
        recordCustomerVisit(customer);
    }

    @Override
    public DailyReport close() {
        DailyReport report = new DailyReport(
                shopDate.getDate().toString(),
                new ArrayList<>(todayVisitors),
                todaySales,
                todayPurchaseCost);
        // 控制台输出原题要求
        System.out.println(report);
        // 重置当日统计，进入下一营业日
        todayVisitors.clear();
        todaySales = 0;
        todayPurchaseCost = 0;
        isOpen = false;
        shopDate.nextDay();
        // 次日进货货位补货
        refillCandidateSlots();
        return report;
    }

    // ==================== GUI 辅助方法 ====================

    /**
     * 开业：重置当日统计。
     */
    public void open() {
        todayVisitors.clear();
        todaySales = 0;
        todayPurchaseCost = 0;
        isOpen = true;
    }

    /**
     * 生成一只候选动物（用于进货界面货位）。
     *
     * @param speciesClass 品种类
     * @return 候选动物；编号耗尽返回 {@code null}
     */
    public Animal createCandidate(Class<? extends Animal> speciesClass) {
        String name = nameGenerator.nextName(speciesClass);
        if (name == null) {
            return null;
        }

        Gender gender = randomGender();
        Random r = new Random();
        int age = r.nextInt(5);

        //ThreadLocalRandom.current().nextInt(1, 5); // 1~4

        if (speciesClass == Cat.class) {
            return new Cat(name, age, gender);
        } else if (speciesClass == ChineseRuralDog.class) {
            return new ChineseRuralDog(name, age, gender);
        } else if (speciesClass == GoldenHamster.class) {
            return new GoldenHamster(name, age, gender);
        } else if (speciesClass == MiniPig.class) {
            return new MiniPig(name, age, gender);
        } else if (speciesClass == Parrot.class) {
            return new Parrot(name, age, gender);
        } else {
            throw new IllegalStateException("无该动物类型: " + speciesClass.getSimpleName());
            //名称.getSimpleName为Java内置方法，导包即可使用
        }


    /*  try {
             return speciesClass.getConstructor(String.class, int.class, Gender.class)
             .newInstance(name, age, gender);
           //上述操作意为寻找构造器（getConstructor）
           //即寻找该speciesClass是否拥有含有String，int和Gender的public方法
           //若没有则捕捉以下异常
        } catch (ReflectiveOperationException e) {
            throw new IllegalStateException("无法创建动物实例: " + speciesClass.getSimpleName(), e);
        }
    */
    }

    /**
     * 获取指定品种的 5 个进货货位（首次调用时初始化）。
     *
     * @param speciesClass 品种类
     * @return 长度为 5 的货位列表（元素可能为 null，表示空位）
     */
    public List<Animal> getCandidateSlots(Class<? extends Animal> speciesClass) {
        return candidateSlots.computeIfAbsent(speciesClass, k -> {
            //candidateSlots是一个map集合（种类，集合）
            // 集合.computeIfAbsent方法（key, mappingFunction）的含义是：
            //查看是否已有这个键为speciesClass的集合，若则直接返回key
            //若无则先调用mappingFunction方法创建该集合，然后返回键key
            //使用lambda表达式用k接收mapping返回的值，赋给下面方法获得候选动物
            //此lambda表达式只在第一次调用getCandiateSlots时生效
            // 其他时候key直接返回，随后返回该key对应的value，即集合
            List<Animal> slots = new ArrayList<>(5);
            for (int i = 0; i < 5; i++) {
                slots.add(createCandidate(k));
            }
            return slots;
        });

        /*该方法使用了lambda表达式，具体表现为k->{}
        若用匿名内部类的格式表示，应为：
        不用 Lambda 的老写法（等价）
    return candidateSlots.computeIfAbsent(speciesClass, new Function<Class<? extends Animal>, List<Animal>>() {
    @Override
    public List<Animal> apply(Class<? extends Animal> k) {
        List<Animal> slots = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            slots.add(createCandidate(k));
        }
        return slots;
    }
});
         */
    }

    /**
     * 从货位取出一只候选动物（货位置空）。
     *
     * @param speciesClass 品种类
     * @param index        货位索引 0~4
     * @return 取出的动物；若货位已空返回 {@code null}
     */
    public Animal takeCandidate(Class<? extends Animal> speciesClass, int index) {
        List<Animal> slots = getCandidateSlots(speciesClass);
        Animal animal = slots.get(index);
        slots.set(index, null);
        return animal;
    }

    /**
     * 将动物放回货位（买入失败时回滚）。
     *
     * @param speciesClass 品种类
     * @param index        货位索引
     * @param animal       要放回的动物
     */
    public void returnCandidate(Class<? extends Animal> speciesClass, int index, Animal animal) {
        getCandidateSlots(speciesClass).set(index, animal);
    }

    /**
     * 补货：将所有空货位用新候选动物填满（歇业后次日调用）。
     */
    public void refillCandidateSlots() {
        for (Class<? extends Animal> speciesClass : SPECIES_CLASSES) {
            List<Animal> slots = getCandidateSlots(speciesClass);
            for (int i = 0; i < slots.size(); i++) {
                if (slots.get(i) == null) {
                    slots.set(i, createCandidate(speciesClass));
                }
            }
        }
    }

    /**
     * 查找店内符合顾客要求的动物。
     *
     * @param species 品种名（中文）
     * @param gender  性别
     * @param age     年龄
     * @return 符合条件的动物列表
     */
    public List<Animal> findMatchingAnimals(String species, Gender gender, int age) {
        List<Animal> result = new ArrayList<>();
        for (Animal a : animalList) {
            if (a.getSpecies().equals(species)
                    && a.getGender() == gender
                    && a.getAge() == age) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * 将指定动物出售给顾客（GUI 选动物成交）。
     *
     * @param customer 顾客
     * @param animal   要出售的动物
     * @return 是否成功
     */
    public boolean sellToCustomer(Customer customer, Animal animal) {
        if (!animalList.remove(animal)) {
            return false;
        }
        balance += animal.getPrice();
        todaySales += animal.getPrice();
        recordCustomerVisit(customer);
        return true;
    }

    /**
     * 记录顾客到店（同名顾客累加次数，否则新增）。
     *
     * @param customer 顾客
     */
    public void recordCustomerVisit(Customer customer) {
        Optional<Customer> existing = customerList.stream()
                .filter(c -> c.getName().equals(customer.getName()))
                .findFirst();
        if (existing.isPresent()) {
            existing.get().visit(shopDate.getDate());
            // 若今日已记录过该顾客则不重复加入今日列表
            if (!todayVisitors.contains(existing.get())) {
                todayVisitors.add(existing.get());
            }
            //来到else说明CustomerList（顾客纪念册中无该顾客）
        } else {
            customer.visit(shopDate.getDate());
            customerList.add(customer);
            todayVisitors.add(customer);
        }
    }
    /*
    下面总结上述方法用到的嵌套方法。
    1-optinal类，本代码指定泛型为Customer，名字为existing
    2-steam流，本代码以集合调用；filter过滤（保留）集合中与形参相同的数据
      findFirst顾名思义获取第一个过滤得到的元素，赋给exiting（optional类）
    3-optinal.isPresent，与isEmpty相反
    4-optional.get（），取出optional内存储的元素
    5-customer.visit是本代码自写方法，更新顾客到店时间并增加到店次数
    */

    /**
     * 仅记录顾客到店（未成交也调用）。
     *
     * @param customer 顾客
     */
    public void visitOnly(Customer customer) {
        recordCustomerVisit(customer);
    }

    // ==================== 工具方法 ====================

    private Gender randomGender() {
        Gender[] values = Gender.values();
        return values[ThreadLocalRandom.current().nextInt(values.length)];
    }

    // ==================== Getter ====================

    public double getBalance() {
        return balance;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public ShopDate getShopDate() {
        return shopDate;
    }

    public AnimalNameGenerator getNameGenerator() {
        return nameGenerator;
    }

    public List<Customer> getTodayVisitors() {
        return todayVisitors;
    }

    public double getTodaySales() {
        return todaySales;
    }

    public double getTodayPurchaseCost() {
        return todayPurchaseCost;
    }
}