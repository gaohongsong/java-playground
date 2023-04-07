create table if not exists persistent_logins
(
    series    varchar(255) not null,
    last_used datetime     null,
    token     varchar(255) null,
    username  varchar(255) null,
    primary key (series)
);

create table if not exists t_authority
(
    id        int auto_increment
        primary key,
    authority varchar(255) null
);

create table if not exists t_my_user
(
    id       int          not null,
    password varchar(128) null comment '密码',
    username varchar(64)  not null,
    primary key (id)
);

create table if not exists my_user_authority
(
    ref_my_user_id   int not null,
    ref_authority_id int not null,
    primary key (ref_my_user_id, ref_authority_id),
    constraint FKdwn700tr0i632uurici06d7nt
        foreign key (ref_my_user_id) references t_my_user (id),
    constraint FKkqyoviwwsk8gnv6yybegdcqq6
        foreign key (ref_authority_id) references t_authority (id)
);


