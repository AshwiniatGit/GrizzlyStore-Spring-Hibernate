delimiter $$

CREATE TABLE `category` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

delimiter $$

delimiter $$

CREATE TABLE `user` (
  `userId` varchar(10) NOT NULL DEFAULT '',
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `userType` varchar(1) DEFAULT NULL,
  `userStatus` int(1) DEFAULT NULL,
  `contactNumber` varchar(10) DEFAULT NULL,
  `designation` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

CREATE TABLE `product` (
  `id` varchar(10) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `category` varchar(10) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `brand` varchar(20) DEFAULT NULL,
  `offer` float DEFAULT NULL,
  `rating` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8$$

