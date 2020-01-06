package start;

import strategy.joined.Album;
import strategy.joined.Book;
import strategy.joined.Movie;
import strategy.mapped.Member;
import strategy.mapped.Seller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch07");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();

//            startJoinStrategy(em);
            startMappedSuperClass(em);

            et.commit();
        } catch(Exception e) {
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    // MappedSuperClass 사용. BaseEntity 테이블이 생기지 않음.
    private static void startMappedSuperClass(EntityManager em) {
        Member member = new Member();
        member.setName("회원");   // 부모
        member.setEmail("이메일");
        em.persist(member);

        Seller seller = new Seller();
        seller.setName("판매자");  // 부모
        seller.setShopName("상점");
        em.persist(seller);

    }

    // 조인 전략
    private static void startJoinStrategy(EntityManager em) {

        Album album = new Album();
        album.setArtist("artist1");
        album.setName("yoojin");
        album.setPrice(1000);

//        album.setId(1L);
// -> javax.persistence.PersistenceException: org.hibernate.PersistentObjectException: detached entity passed to persist: entity.Album
//        <- Item id에 @GeneratedValue 를 명시했기 때문에 id를 지정하면 에러 발생

        em.persist(album);

        Movie movie = new Movie();
        movie.setActor("actor1");
        movie.setDirector("director1");
        movie.setName("yoojin");
        movie.setPrice(2000);
        em.persist(movie);

        Book book  = new Book();
        book.setAuthor("author1");
        book.setIsbn("12345");
        book.setName("yoojin");
        book.setPrice(3000);
        em.persist(book);

    }
}
