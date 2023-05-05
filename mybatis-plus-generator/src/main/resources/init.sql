create table acc_account
(
    id              bigint       not null,
    username        varchar(128) not null comment '用户名',
    phone           varchar(32)  null comment '手机号',
    name            varchar(32)  null comment '姓名',
    id_number_crypt varchar(128) null comment '身份证信息（加密）',
    birthday        datetime     null comment '生日',
    status          int          not null comment 'enum=10:NORMAL:正常;20:BANNED:停用;',
    version         int          not null comment '版本号',
    deleted         tinyint      not null comment '逻辑删除',
    create_user_id  bigint       not null comment '创建人id',
    create_time     datetime     not null comment '创建人姓名',
    update_user_id  bigint       not null comment '更新人id',
    update_time     datetime     not null comment '更新时间',
    constraint acc_account_id_uindex
        unique (id)
)
    comment '账号';

alter table acc_account
    add primary key (id);

create table acc_business_account
(
    id             bigint        not null comment 'id',
    account_id     bigint        not null comment '账号id',
    status         int           not null comment 'enum=10:NORMAL:正常;20:BANNED:停用;',
    type           int           not null comment 'enum=10:OPERATION_PLATFORM:运营后台;20:SUPPLY_CHAIN:供应链;',
    phone          varchar(32)   null comment '联系方式',
    username       varchar(128)  null comment '用户名',
    password       varchar(1024) null comment '密码',
    tenant_id      bigint        not null comment '租户id',
    create_user_id bigint        not null comment '创建人id',
    create_time    datetime      not null comment '创建时间',
    update_user_id bigint        not null comment '更新人id',
    update_time    datetime      not null comment '更新时间',
    version        int           not null comment '版本号',
    deleted        tinyint       not null comment '逻辑删除',
    constraint acc_business_account_id_uindex
        unique (id)
)
    comment '业务账号';

alter table acc_business_account
    add primary key (id);

create table acc_business_account_extra
(
    id                  bigint       not null comment 'id',
    business_account_id bigint       not null comment '业务账号id',
    province_code       varchar(16)  null comment '省编码',
    province            varchar(16)  null comment '省名称',
    city_code           varchar(16)  null comment '市编码',
    city                varchar(16)  null comment '市名称',
    district_code       varchar(16)  null comment '区编码',
    district            varchar(16)  null comment '区名称',
    avatar              varchar(512) null comment '头像',
    addr_detail         varchar(128) null comment '详细地址',
    signature           varchar(128) null comment '签名',
    create_user_id      bigint       not null comment '创建人id',
    create_time         datetime     not null comment '创建时间',
    update_user_id      bigint       not null comment '更新人id',
    update_time         datetime     not null comment '更新时间',
    version             int          not null comment '版本号',
    deleted             tinyint      not null comment '逻辑删除',
    constraint acc_account_extra_id_uindex
        unique (id)
)
    comment '账号拓展信息';

create index acc_account_extra_account_id_index
    on acc_business_account_extra (business_account_id);

alter table acc_business_account_extra
    add primary key (id);


create table acc_business_third_app_ref
(
    id                     bigint       not null comment 'id',
    business_account_id    bigint       not null comment '业务账号id',
    third_party_account_id bigint       not null comment '三方账号id',
    business_type          int          not null comment '业务类型',
    third_type             int          not null comment '三方账号类型',
    app_account            varchar(256) not null comment '应用账号',
    create_user_id         bigint       not null comment '创建人id',
    create_time            datetime     not null comment '创建时间',
    update_user_id         bigint       not null comment '更新人id',
    update_time            datetime     not null comment '更新时间',
    version                int          not null comment '版本号',
    deleted                tinyint      not null comment '逻辑删除',
    constraint acc_business_third_app_ref_id_uindex
        unique (id)
)
    comment '业务-三方关联表';

alter table acc_business_third_app_ref
    add primary key (id);


create table acc_third_party_account
(
    id                  bigint       not null comment 'id',
    account_id          bigint       not null comment '账号id',
    type                int          not null comment 'enum=10:WECHAT:微信;20:ALIPAY:支付宝;',
    third_party_account varchar(256) not null comment '三方账号',
    create_user_id      bigint       not null comment '创建人id',
    create_time         datetime     not null comment '创建时间',
    update_user_id      bigint       not null comment '更新人id',
    update_time         datetime     not null comment '更新时间',
    version             int          not null comment '版本号',
    deleted             tinyint      not null comment '逻辑删除',
    constraint acc_third_party_account_id_uindex
        unique (id)
)
    comment '三方账号';

create index acc_third_party_account_account_id_index
    on acc_third_party_account (account_id);

alter table acc_third_party_account
    add primary key (id);



alter table xxx
    add version        int      not null comment '版本号',
    add deleted        tinyint  not null comment '逻辑删除',
    add create_user_id bigint   not null comment '创建人id',
    add create_time    datetime not null comment '创建时间',
    add update_user_id bigint   not null comment '更新人id',
    add update_time    datetime not null comment '更新时间';
