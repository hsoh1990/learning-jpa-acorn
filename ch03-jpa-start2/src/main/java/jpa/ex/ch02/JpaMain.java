package jpa.ex.ch02;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        //엔티티 매니저 팩토리 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-acorn");

        //엔티티 매니저 생성
        EntityManager em = emf.createEntityManager();
        //트랜잭션 기능 획득
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin(); //트랜잭션 시작
            logic(em);  //비즈니스 로직 --> 로직만으로는 insert sql을 DB에 전송 X 내부 쿼리 저장소 저장 O
            tx.commit();//트랜잭션 커밋 --> sql DB에 전송
        } catch (Exception e) {
            e.printStackTrace();
            //트랜잭션 롤백
            tx.rollback();
        } finally {
            //엔티티 매니저 종료
            em.close();
        }
        //엔티티 매니저 팩토리 종료
        emf.close();
    }

    public static void logic(EntityManager em) {
        // 객체를 생성한 상태 (비영속)
        String id = "id1";
        Member member = new Member();
        member.setId(id);
//        member.setUsername("wellstone");
        member.setAge(2);

        // 객체를 저장한 상태(영속) --> 1차 캐쉬시에 저장
        em.persist(member);

        // 1차 캐시 또는 영속성 컨테스트가 관리하는 영속상태 객체는 스냅샷을 비교하여 변경상태 확
        member.setAge(3);

        //한 건 조회 --> 1차 캐쉬에서 조회
        Member findMember = em.find(Member.class, id);
        System.out.println("findMember=" + findMember.getUsername() + ", age=" + findMember.getAge());


        // 영속성 컨테스트가 관리하지 않는 상태(준영속)를 만드지는 방법 3가
        em.detach(member);
//        em.clear();
//        em.close();

        // 준영속 상태의 엔티티를 다시 영속 상태로 변경
        Member merge = em.merge(member);

        // 객체를 삭제한 상태(삭제)
        em.remove(merge);

        // 프러시 모드 직접 설정
        em.setFlushMode(FlushModeType.COMMIT);

        em.flush();
    }
}
