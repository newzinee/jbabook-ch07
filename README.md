# jbabook-ch07

#### 상속 관계 매핑

데이터베이스에는 객체에서 다루는 상속 개념이 없기 때문에, 상속을 풀어내기 위한 다양한 방법이 있다. 

1. 각각의 테이블로 변환(조인 전략): 부모, 자식 테이블을 각각 만들고, 조회할 때 조인 

    - 부모 테이블의 기본 키를 받아, 기본 키 + 외래 키 전략
    
    - 테이블은 타입의 개념이 없으므로, 부모 테이블의 자식의 타입을 표시할 컬럼(DTYPE) 추가

2. 통합 테이블로 변환(단일 테이블 전략): 테이블을 하나만 사용해 통합

3. 서브타입 테이블로 변환(구현 클래스마다 테이블 전략): 자식 테이블을 만들고, 각 자식 테이블에 부모 정보 포함 

---

##### 조인 전략

- @Inheritance(strategy = InheritanceType.JOINED): 상속 매핑은 부모 클래스에 @Inheritance 을 설정해야 한다. 매핑 전략을 지정해야 하는데, 여기서는 조인 전략을 사용

- @DiscriminatorColumn(name = "DTYPE"): 부모 클래스에 구분 컬럼을 지정. 기본값이 DTYPE 이므로 @DiscriminatorColumn 으로 생략가능.

- @DiscriminatorVlaue("M"): 엔티티 저장시, 구분 컬럼에 입력할 값 지정.

- @PrimaryKeyJoinColumn(name = "BOOK_ID"): 자식 테이블의 기본 키 컬럼명을 변경하고 싶을 때 사용. (default: 부모 테이블의 ID 컬럼명을 그대로 사용)

```
Hibernate: 
    
    create table Album (
       artist varchar(255),
        ITEM_ID bigint not null,
        primary key (ITEM_ID)
    )
Hibernate: 
    
    create table Book (
       author varchar(255),
        isbn varchar(255),
        BOOK_ID bigint not null,
        primary key (BOOK_ID)
    )
Hibernate: 
    
    create table Item (
       DTYPE varchar(31) not null,
        ITEM_ID bigint not null,
        name varchar(255),
        price integer not null,
        primary key (ITEM_ID)
    )
Hibernate: 
    
    create table Movie (
       actor varchar(255),
        director varchar(255),
        ITEM_ID bigint not null,
        primary key (ITEM_ID)
    )
Hibernate: 
    
    alter table Album 
       add constraint FK75mrpprv8oigh00y92tibw7id 
       foreign key (ITEM_ID) 
       references Item
Hibernate: 
    
    alter table Book 
       add constraint FK9h9lj6m5b1wrqut7kqp5hhw7u 
       foreign key (BOOK_ID) 
       references Item
Hibernate: 
    
    alter table Movie 
       add constraint FKqqwswm36y8uqoh9emtoruoxcv 
       foreign key (ITEM_ID) 
       references Item
Hibernate: 
    call next value for hibernate_sequence
Hibernate: 
    call next value for hibernate_sequence
Hibernate: 
    call next value for hibernate_sequence
Hibernate: 
    /* insert Album
        */ insert 
        into
            Item
            (name, price, DTYPE, ITEM_ID) 
        values
            (?, ?, 'A', ?)
Hibernate: 
    /* insert Album
        */ insert 
        into
            Album
            (artist, ITEM_ID) 
        values
            (?, ?)
Hibernate: 
    /* insert Movie
        */ insert 
        into
            Item
            (name, price, DTYPE, ITEM_ID) 
        values
            (?, ?, 'M', ?)
Hibernate: 
    /* insert Movie
        */ insert 
        into
            Movie
            (actor, director, ITEM_ID) 
        values
            (?, ?, ?)
Hibernate: 
    /* insert Book
        */ insert 
        into
            Item
            (name, price, DTYPE, ITEM_ID) 
        values
            (?, ?, 'B', ?)
Hibernate: 
    /* insert Book
        */ insert 
        into
            Book
            (author, isbn, BOOK_ID) 
        values
            (?, ?, ?)
```

장점

- 테이블이 정규화됨

- 외래키 참조 무결성 제약조건 활용 가능

- 저장공간을 효율적으로 사용

단점 

- 조회할 때 조인이 많이 사용됨 -> 성능 저하 , 쿼리 복잡

- 데이터를 등록할 때, insert sql 이 두 번 실행  (자식, 부모)

특징 

- JPA 표준 명세는 구분 컬럼을 사용하도록 하지만 하이버네이트를 포함한 몇몇 구현체는 구분 컬럼(@DiscriminatorColumn) 없이도 동작한다. 

---

##### 단일 테이블 전략

단일 테이블 전략은 부모, 자식 정보 모두 합쳐진 테이블(ITEM) 하나만 사용하고, 구분 컬럼(DTYPE)으로 구분한다. 

- @Inheritance(strategy = InheritanceType.SINGLE_TABLE) 사용. 

장점

- 조인이 필요 없음 -> 조회 성능 빠름, 조회 쿼리 단순

단점

- 자식 엔티티가 매핑한 컬럼은 모두 null 허용이여야 함

- 단일 테이블에 모든 것을 저장하므로 테이블이 커질 수 있음. -> 조회 성능이 느려질 수 있음

특징

- 구분 컬럼 반드시 사용. @DiscriminatorColumn 반드시 설정해야 한다. 