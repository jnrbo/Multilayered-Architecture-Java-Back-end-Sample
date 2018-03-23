CREATE TABLE IF NOT EXISTS `library` (
  `id` bigint(20) NOT NULL,
  `payment_account` bit(1) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `borrowed` bit(1) NOT NULL,
  `library_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `library_id` (`library_id`),
  CONSTRAINT `fk_books_library_id` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `person` (
  `id` bigint(20) NOT NULL,
  `cpf` varchar(11) NOT NULL UNIQUE,
  `name` varchar(255) NOT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `loan` (
  `id` bigint(20) NOT NULL,
  `returned` bit(1) NOT NULL,
  `loaned_on` datetime NOT NULL,
  `person_id` bigint(20),
  `book_id` bigint(20),
  `library_id` bigint(20),
  PRIMARY KEY (`id`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `fk_loan_person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `fk_loan_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`),
  KEY `library_id` (`library_id`),
  CONSTRAINT `fk_loan_library_id` FOREIGN KEY (`library_id`) REFERENCES `library` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
