//package jpa.ex.ch02.member;
//
//import lombok.*;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Entity
//@Table(name="MEMBER", uniqueConstraints = {@UniqueConstraint(
//        name = "NAME_AGE_UNIQUE",
//        columnNames = {"name", "age"}
//)})
//@Getter
//@Setter
//@EqualsAndHashCode(of = "id")
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class Member {
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY?)
//    @GeneratedValue //기본은 strategy = GenerationType.AUTO
//    private String id;
//
//    @Column(name = "name", nullable = false, length = 10)
//    private String username;
//
//    private Integer age;
//
//    @Column(name = "role_type")
//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;
//
//    @Column(name = "create_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createDate;
//
//    @Column(name = "last_modified_date")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    @Lob
//    private String description;
//
//    @Transient
//    private String Temp; // database에 반영되지 않음
//}