DROP TABLE IF EXISTS 'users';
CREATE TABLE 'users'
(
'id' int NOT NULL AUTO_INCREMENT,
'username' varchar(45) DEFAULT NULL,
'email' varchar(45) DEFAULT NULL,
'password' varchar(60) DEFAULT NULL,
PRIMARY KEY ('id'),
UNIQUE KEY `client_email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `role_id` int NOT NULL AUTO_INCREMENT,
                        `role_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



