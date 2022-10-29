create table country_image (
    country_id CHAR(2) PRIMARY KEY,
    file_name varchar(255) not null,
    description varchar(255),
    content_type varchar(255) not null,
    size integer not null
);

ALTER TABLE country_image
    ADD CONSTRAINT fk_country_image FOREIGN KEY (country_id) REFERENCES countries (country_id);