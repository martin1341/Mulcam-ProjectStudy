create table member (
	id varchar(10) primary key not null unique,
    pw varchar(10) not null,
    membername varchar(20) not null,
    email varchar(20)
);

CREATE TABLE article(
	article_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY UNIQUE,
    article_title VARCHAR(50) NOT NULL,
    article_author VARCHAR(10) NOT NULL,
    article_content TEXT NOT NULL,
    article_image VARCHAR(255),
    article_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    article_views INT NOT NULL DEFAULT 0,
    article_recommends INT NOT NULL DEFAULT 0,
	FOREIGN KEY (article_author) REFERENCES member(id)
);

CREATE TABLE recommends(
	article_id INT NOT NULL,
    member_id VARCHAR(10) NOT NULL,
    FOREIGN KEY (article_id) REFERENCES article(article_id),
    FOREIGN KEY (member_id) REFERENCES member(id)
);