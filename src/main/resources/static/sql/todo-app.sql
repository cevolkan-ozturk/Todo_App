DROP TABLE IF EXISTS 'user';
CREATE TABLE 'user'
(
'user_id' int NOT NULL AUTO_INCREMENT,
'user_username' varchar(45) DEFAULT NULL,
'user_email' varchar(45) DEFAULT NULL,
'user_password' varchar(60) DEFAULT NULL,
PRIMARY KEY ('user_id'),
UNIQUE KEY `client_email_UNIQUE` (`user_email`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
                        `role_id` int NOT NULL AUTO_INCREMENT,
                        `role_name` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



