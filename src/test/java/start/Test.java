package start;

import composite.embeddedId.ParentEmb;
import composite.embeddedId.ParentEmbId;
import composite.idclass.Parent;
import composite.idclass.ParentId;
import composite2.idclass.ChildDis;
import composite2.idclass.GrandChildDis;
import composite2.idclass.GrandChildId;
import composite2.idclass.ParentDis;
import onetoone.Board;
import onetoone.BoardDetail;
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
//            startMappedSuperClass(em);
//            startCompositeIdClassParent(em);
//            startCompositeEmbedParent(em);
//            startComposite2IdClassParent(em);
            startOneToOneIdentification(em);
            
            et.commit();
        } catch(Exception e) {
            et.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    // 일대일 식별관계
    private static void startOneToOneIdentification(EntityManager em) {

        Board board = new Board();
        board.setTitle("제목");
        em.persist(board);

        BoardDetail boardDetail = new BoardDetail();
        boardDetail.setContent("내용");
        boardDetail.setBoard(board);

        em.persist(boardDetail);
    }

    // 복합 키 식별관계 매핑 : @IdClass
    private static void startComposite2IdClassParent(EntityManager em) {

        ParentDis parent = new ParentDis();
        parent.setId("parent1");
        parent.setName("parentName");

        ChildDis child = new ChildDis();
        child.setParent(parent);
        child.setName("childName");
        child.setChildId("child1");

        GrandChildDis grandChild = new GrandChildDis();
        grandChild.setChild(child);
        grandChild.setId("grandChild1");
        grandChild.setName("grandChildName");

        em.persist(grandChild);
    }

    // 복합키를 사용하는 엔티티를 저장하고 조회한다. (부모 - EmbeddedId 이용)
    private static void startCompositeEmbedParent(EntityManager em) {

        // 저장
        ParentEmb parent = new ParentEmb();
        ParentEmbId parentId = new ParentEmbId("id11", "id22");
        parent.setId(parentId);
        parent.setName("parent");
        em.persist(parent);

        // 조회
        ParentEmb findParent = em.find(ParentEmb.class, parentId);

        System.out.println("findParent: " + findParent.getId() + ", " + findParent.getName());
        System.out.println("parent.equals(findParent): " + parent.equals(findParent));  // true
    }

    // 복합키를 사용하는 엔티티를 저장하고 조회한다. (부모 - IdClass 이용)
    private static void startCompositeIdClassParent(EntityManager em) {

        // 저장
        Parent parent = new Parent();
        parent.setId1("id1");
        parent.setId2("id2");
        parent.setName("222parentName");
        em.persist(parent);

        // 조회
        ParentId parentId = new ParentId("id1", "id2");
        Parent findParent = em.find(Parent.class, parentId);

        System.out.println("findParent: " + findParent.getId1() + ", " + findParent.getId2() + ", " + findParent.getName());
        System.out.println("parent.equals(findParent): " + parent.equals(findParent));  // true
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
