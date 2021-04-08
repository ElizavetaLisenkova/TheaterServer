CREATE TABLE IF NOT EXISTS troup
(
    id INT NOT NULL ,
    actor_full_name  VARCHAR(250) NOT NULL
);

CREATE TABLE IF NOT EXISTS hall
(
    id SERIAL PRIMARY KEY,
    name  varchar(200) ,
    total_places INT NOT NULL
);

CREATE TABLE IF NOT EXISTS sector
(
    id    SERIAL PRIMARY KEY ,
    name VARCHAR(200) NOT NULL,
    hall_id SERIAL NOT NULL,
    seats_number INT NOT NULL,
    FOREIGN KEY (hall_id) REFERENCES hall (id) ON DELETE CASCADE

);

CREATE TABLE IF NOT EXISTS performance
(
    id    SERIAL PRIMARY KEY ,
    name VARCHAR(200) NOT NULL,
    date Date NOT NULL,
    time Time NOT NULL,
    troup_name INT,
    hall_id SERIAL NOT NULL,
    status VARCHAR(200),
    FOREIGN KEY (hall_id)  REFERENCES hall (id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS ticket
(
    id    SERIAL PRIMARY KEY ,
    price NUMERIC NOT NULL,
    performance_id INT NOT NULL,
    sector_id INT NOT NULL,
    place INT,
    availability BOOLEAN,
    FOREIGN KEY (performance_id)  REFERENCES performance (id) ON DELETE CASCADE ,
    FOREIGN KEY (sector_id)  REFERENCES sector (id) ON DELETE SET NULL
);




