create table acc_account
(
    id              bigint       not null,
    username        varchar(128) not null comment '用户名',
    phone           varchar(32)  null comment '手机号',
    name            varchar(32)  null comment '姓名',
    id_number_crypt varchar(128) null comment '身份证信息（加密）',
    birthday        datetime     null comment '生日',
    status          int          not null comment 'enum=10:NORMAL:正常;20:BANNED:停用;',
    constraint acc_account_id_uindex
        unique (id)
)
    comment '账号';

alter table acc_account
    add primary key (id);
