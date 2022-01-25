DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(36) NULL DEFAULT NULL COMMENT '姓名',
    age INT(11) NULL DEFAULT NULL COMMENT '年龄',
    email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱',
    state INT(11) DEFAULT 0 COMMENT '状态',
    PRIMARY KEY (id)
);

CREATE TABLE dept
(
    id BIGINT(20) NOT NULL COMMENT '主键ID',
    name VARCHAR(36) NULL DEFAULT NULL COMMENT '部门名称',
    `ct` datetime                     null comment '记录插入或更新时间',
    create_time datetime                     null comment '创建时间',
    update_time datetime                     null comment '修改时间',
    future datetime                     null comment '未来的一个时间点',
    is_deleted bit(1) DEFAULT 'false' COMMENT '是否被删除',
    PRIMARY KEY (id)
);