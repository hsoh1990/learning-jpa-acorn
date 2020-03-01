package jpa.ex.ch07;


import jpa.ex.ch07.entity.*;
import jpa.ex.ch07.entity.item.Item;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-acorn");
        EntityManager em = emf.createEntityManager(); //엔티티 매니저 생성
        EntityTransaction tx = em.getTransaction(); //트랜잭션 기능 획득

        try {
            tx.begin(); //트랜잭션 시작
            //TODO 비즈니스 로직
            logic(em);
            tx.commit();//트랜잭션 커밋
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback(); //트랜잭션 롤백
        } finally {
            em.close(); //엔티티 매니저 종료
        }

        emf.close(); //엔티티 매니저 팩토리 종료
    }

    public static void logic(EntityManager em) {
        Member member = Member.builder().name("tester").city("seoul").street("..").zipcode("..").build();
        em.persist(member);

        Category category01 = Category.builder().name("computer").build();
        Category category02 = Category.builder().parent(category01).name("laptop").build();
        em.persist(category01);
        em.persist(category02);

        List<Category> categories = Arrays.asList(category01, category02);

        Item air = Item.builder().categories(categories).name("macbook air").price(150).stockQuantity(100).build();
        em.persist(air);

        Item pro = Item.builder().categories(categories).name("macbook pro").price(200).stockQuantity(100).build();
        em.persist(pro);


        OrderItem order1 = OrderItem.builder().item(air).count(1).orderPrice(150).build();
        OrderItem order2 = OrderItem.builder().item(pro).count(1).orderPrice(150).build();
        em.persist(order1);
        em.persist(order2);

        Order order = Order.builder().member(member).orderItems(Arrays.asList(order1, order2)).status(OrderStatus.ORDER).build();
        em.persist(order);

        Delivery delivery = Delivery.builder().city("seoul").build();
        order.setDelivery(delivery);
        em.persist(delivery);

        em.flush();

        Order findOrder = em.find(Order.class, order.getId());
        OrderItem findOrderItem = findOrder.getOrderItems().get(0);
        Item findItem = findOrderItem.getItem();
        String orderMemberName = findOrder.getMember().getName();

        Delivery findOrderDelivery = findOrder.getDelivery();

        List<Category> findAirCategories = air.getCategories();

        System.out.println(findItem.getName());
        System.out.println(orderMemberName);
        System.out.println(findOrderDelivery.getCity());
        System.out.println(findAirCategories.toString());
    }
}
