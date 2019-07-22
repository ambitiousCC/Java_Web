-- 用户数据库//是反斜杠不是单引号！！！！！
CREATE TABLE user(
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    real_name VARCHAR(20) DEFAULT NULL,
    birthday DATE DEFAULT NULL,
    phone VARCHAR(16) DEFAULT NULL,
    address varchar(128) DEFAULT NULL,
    UNIQUE KEY user_username (username),
    PRIMARY KEY(`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;