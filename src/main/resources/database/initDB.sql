CREATE TABLE IF NOT EXISTS troup
(
    id SERIAL PRIMARY KEY ,
    name  VARCHAR(250)

);

CREATE TABLE IF NOT EXISTS actor
(
    id SERIAL PRIMARY KEY ,
    troup_id INT,
    full_name  VARCHAR(250) NOT NULL,
    FOREIGN KEY (troup_id) REFERENCES troup (id) ON DELETE CASCADE 
);


CREATE TABLE IF NOT EXISTS hall
(
    id SERIAL PRIMARY KEY,
    name  varchar(200) ,
    total_places INT NOT NULL
);


CREATE TABLE IF NOT EXISTS performance
(
    id    SERIAL PRIMARY KEY ,
    name VARCHAR(200) NOT NULL,
    date Date NOT NULL,
    time Time NOT NULL,
    troup_id INT,
    hall_id SERIAL NOT NULL,
    status VARCHAR(200),
    FOREIGN KEY (hall_id)  REFERENCES hall (id) ON DELETE cascade,
    FOREIGN KEY (troup_id)  REFERENCES troup (id) ON DELETE cascade
);

CREATE TABLE IF NOT EXISTS ticket
(
    id    SERIAL PRIMARY KEY ,
    price NUMERIC NOT NULL,
    performance_id INT NOT NULL,
    place INT,
    availability BOOLEAN,
    FOREIGN KEY (performance_id)  REFERENCES performance (id) ON DELETE CASCADE
);




