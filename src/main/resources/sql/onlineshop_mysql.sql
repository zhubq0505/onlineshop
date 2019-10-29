use onlineshop;
create table `area`(
    `area_id` int(2) NOT NULL AUTO_INCREMENT,
    `area_name` varchar(200) NOT NULL,
    `weight` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key(`area_id`),
    unique key`CHINA_AREA`(`area_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `user_info`(
    `user_id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(128) DEFAULT NULL,
    `profile_img` varchar(256) DEFAULT NULL,
    `email` varchar(256) DEFAULT NULL,
    `gender` varchar(2) DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0' COMMENT '0:停用 1:启用 ',
    `user_type` int(2) NOT NULL DEFAULT '1' COMMENT '1:顾客   2店家  3管理员',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `wechat_account`(
    `wechar_account_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `open_id` varchar(512) NOT NULL,
    `create_time` datetime DEFAULT NULL,
    primary key(`wechar_account_id`),
    unique key `uk_wechataccount_profile`(`open_id`),
    constraint `fk_wechataccount_profile` 
    foreign key(`user_id`) references `user_info`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `local_account`(
    `local_account_id` int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `username` varchar(128) NOT NULL,
    `password` varchar(128) NOT NULL,
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key(`local_account_id`), 
    unique key `uk_localaccount_profile`(`username`),
    constraint `fk_localaccount_profile` 
    foreign key(`user_id`) references `user_info`(`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `head_line`(
    `line_id` int(11) NOT NULL AUTO_INCREMENT,
    `line_name` varchar(1024) DEFAULT NULL,
    `line_link` varchar(2048) NOT NULL,
    `line_img` varchar(2048) NOT NULL,
    `weight` int(2) DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key(`line_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `shop_category`(
    `shop_category_id` int(11) NOT NULL AUTO_INCREMENT,
    `shop_category_name` varchar(128) NOT NULL DEFAULT '',
    `shop_category_desc` varchar(1024) DEFAULT '',
    `shop_category_img` varchar(2048) DEFAULT NULL,
    `weight` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    `parent_id` int(11) DEFAULT NULL,
    primary key(`shop_category_id`),
    constraint `fk_shopcategory_self` 
    foreign key(`parent_id`) references `shop_category`(`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `shop`(
    `shop_id` int(11) NOT NULL AUTO_INCREMENT,
    `owner_id` int(11) NOT NULL COMMENT '店主',
    `area_id` int(5) DEFAULT NULL,
    `shop_category_id` int(11) DEFAULT NULL,
    `shop_name` varchar(128) NOT NULL,
    `shop_desc` varchar(1024) DEFAULT NULL,
    `shop_addr` varchar(1024) DEFAULT NULL,
    `phone` varchar(128) DEFAULT NULL,
    `shop_img` varchar(1024) DEFAULT NULL,
    `weight` int(2) DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0',
    `advice` varchar(256) DEFAULT NULL,
    primary key(`shop_id`),
    constraint `fk_shop_area` foreign key(`area_id`) references `area`(`area_id`),
    constraint `fk_shop_profile` foreign key(`owner_id`) references `user_info`(`user_id`),
    constraint `fk_shop_category` foreign key(`shop_category_id`) references `shop_category`(`shop_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `product_category`(
    `product_category_id` int(11) NOT NULL AUTO_INCREMENT,
    `product_category_name` varchar(128) NOT NULL,
    `weight` int(2) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL,
    `shop_id` int(11) NOT NULL DEFAULT '0',
    primary key(`product_category_id`),
    constraint `fk_productcate_shop` foreign key(`shop_id`) references `shop`(`shop_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `product`(
    `product_id` int(100) NOT NULL AUTO_INCREMENT,
    `product_name` varchar(100) NOT NULL,
    `product_desc` varchar(2048) DEFAULT NULL,
    `img_addr` varchar(2048) DEFAULT '',
    `normal_price` varchar(100) DEFAULT NULL,
    `discount_price` varchar(100) DEFAULT NULL,
    `weight` int(2) NOT NULL DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    `enable_status` int(2) NOT NULL DEFAULT '0',
    `product_category_id` int(11) DEFAULT NULL,
    `shop_id` int(11) NOT NULL DEFAULT '0',
    primary key(`product_id`),
    constraint `fk_product_productcate` foreign key(`product_category_id`) references `product_category`(`product_category_id`),
    constraint `fk_product_shop` foreign key(`shop_id`) references `shop`(`shop_id`) 
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `product_img`(
    `product_img_id` int(11) NOT NULL AUTO_INCREMENT,
    `img_addr` varchar(2048) NOT NULL,
    `img_desc` varchar(2048) DEFAULT NULL,
    `weight` int(2) DEFAULT '0',
    `create_time` datetime DEFAULT NULL,
    `product_id` int(11) DEFAULT NULL,
    primary key(`product_img_id`),
    constraint `fk_productimg_product` foreign key(`product_id`) references `product`(`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;











