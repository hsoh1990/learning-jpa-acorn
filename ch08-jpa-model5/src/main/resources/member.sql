create table MEMBER (
        ID varchar(255) not null,
        age integer,
        create_date timestamp,
        description clob,
        last_modified_date timestamp,
        role_type varchar(255),
        NAME varchar(255),
        primary key (ID)
)