CREATE TABLE users(
                      id bigserial PRIMARY KEY,
                      username VARCHAR(10) UNIQUE NOT NULL,
                      password VARCHAR NOT NULL,
                      NAME VARCHAR,
                      SURNAME VARCHAR ,
                      ADDRESS VARCHAR ,
                      AGE INT ,
                      EMAIL VARCHAR
);
CREATE TABLE roles(
                      id bigserial PRIMARY KEY,
                      name VARCHAR(20)
);
CREATE TABLE user_roles(
                           user_id INT NOT NULL,
                           role_id INT NOT NULL,
                           FOREIGN KEY (role_id)
                               REFERENCES roles (id) ,
                           FOREIGN KEY (user_id)
                               REFERENCES users (id)
);

CREATE TABLE balance(
                        id bigserial PRIMARY KEY ,
                        amount INT ,
                        users_id INT NOT NULL,
                        FOREIGN KEY(users_id) REFERENCES users(id)
);
CREATE TABLE author(
                       id bigserial PRIMARY KEY,
                       authorName VARCHAR
);

CREATE TABLE categories(
                           id bigserial PRIMARY KEY,
                           category_name VARCHAR
);
CREATE TABLE books(
                      id bigserial PRIMARY KEY,
                      book_name VARCHAR,
                      description VARCHAR,
                      quantity INT,
                      price INT,
                      author_id INT NOT NULL ,
                      category_id INT NOT NULL,
                      users_id INT NOT NULL,
                      FOREIGN KEY (users_id) REFERENCES users(id),
                      FOREIGN KEY (author_id) REFERENCES author(id),
                      FOREIGN KEY (category_id) REFERENCES categories(id)
);

