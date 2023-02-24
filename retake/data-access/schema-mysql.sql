CREATE TABLE IF NOT EXISTS user(
    id INT NOT NULL AUTO_INCREMENT,
    firstname VARCHAR(255) NOT NULL,
    lastname VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO user (firstname, lastname, email)
VALUES
    ('John', 'Doe', 'John@Doe.com'),
    ('Jane', 'Doe', 'Jane@Doe.com'),
    ('John', 'Smith', 'John@Smith.com'),
    ('Jason', 'Tavernier', 'j.tavernier@student.fontys.nl'),
    ('Marek', 'Broz', 'm.broz@student.fontys.nl');

