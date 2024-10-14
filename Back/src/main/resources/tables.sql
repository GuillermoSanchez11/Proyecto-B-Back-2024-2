CREATE TABLE "payment"(
                          "id_payment" bigserial NOT NULL,
                          "id_booking" BIGINT NOT NULL,
                          "amount" DECIMAL(8, 2) NOT NULL,
                          "payment_date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                          "payment_status" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "payment" ADD PRIMARY KEY("id_payment");
CREATE TABLE "pilot"(
                        "id_pilot" bigserial NOT NULL,
                        "first_name" VARCHAR(255) NOT NULL,
                        "last_name" VARCHAR(255) NOT NULL,
                        "license_number" VARCHAR(255) NOT NULL,
                        "date_of_birth" DATE NOT NULL,
                        "nationality" VARCHAR(255) NOT NULL,
                        "rank" VARCHAR(255) NOT NULL,
                        "hours_flown" FLOAT(53) NOT NULL,
                        "employee_date" DATE NOT NULL,
                        "status" VARCHAR(255) NOT NULL,
                        "home_base" VARCHAR(255) NOT NULL,
                        "last_medical_check" DATE NOT NULL
);
ALTER TABLE
    "pilot" ADD PRIMARY KEY("id_pilot");
CREATE TABLE "seat"(
                       "id_seat" bigserial NOT NULL,
                       "id_flight" BIGINT NOT NULL,
                       "seat_number" VARCHAR(255) NOT NULL,
                       "is_reserved" BOOLEAN NOT NULL,
                       "price" DECIMAL(8, 2) NOT NULL,
                       "seat_class" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "seat" ADD PRIMARY KEY("id_seat");
CREATE TABLE "city"(
                       "id_city" bigserial NOT NULL,
                       "name" VARCHAR(255) NOT NULL,
                       "country_id" BIGINT NOT NULL,
                       "timezone" VARCHAR(255) NOT NULL,
                       "latitude" FLOAT(53) NOT NULL,
                       "longitude" FLOAT(53) NOT NULL
);
ALTER TABLE
    "city" ADD PRIMARY KEY("id_city");
CREATE TABLE "luggage"(
                          "id_luggage" bigserial NOT NULL,
                          "id_passenger" BIGINT NOT NULL,
                          "type" VARCHAR(255) NOT NULL,
                          "height_cm" DECIMAL(8, 2) NOT NULL,
                          "weight_kg" DECIMAL(8, 2) NOT NULL,
                          "width_cm" DECIMAL(8, 2) NOT NULL,
                          "extra_free" DECIMAL(8, 2) NOT NULL
);
ALTER TABLE
    "luggage" ADD PRIMARY KEY("id_luggage");
CREATE TABLE "country"(
                          "id_country" bigserial NOT NULL,
                          "name" VARCHAR(255) NOT NULL,
                          "continent" VARCHAR(255) NOT NULL,
                          "language" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "country" ADD PRIMARY KEY("id_country");
CREATE TABLE "plane"(
                        "id_plane" bigserial NOT NULL,
                        "model" VARCHAR(255) NOT NULL,
                        "manufacturer" VARCHAR(255) NOT NULL,
                        "capacity_economy" BIGINT NOT NULL,
                        "capacity_business" BIGINT NOT NULL,
                        "capacity_first_class" BIGINT NOT NULL,
                        "date_manufactured" DATE NOT NULL,
                        "last_maintenance_date" DATE NOT NULL,
                        "registration_number" VARCHAR(255) NOT NULL,
                        "fuel_capacity" FLOAT(53) NOT NULL
);
ALTER TABLE
    "plane" ADD PRIMARY KEY("id_plane");
CREATE TABLE "users"(
                        "id_user" bigserial NOT NULL,
                        "first_name" VARCHAR(255) NOT NULL,
                        "last_name" VARCHAR(255) NOT NULL,
                        "phone_number" VARCHAR(255) NOT NULL,
                        "email" VARCHAR(255) NOT NULL,
                        "nationality" VARCHAR(255) NOT NULL,
                        "date_of_birth" DATE NOT NULL,
                        "document_id" VARCHAR(255) NOT NULL,
                        "passport_number" VARCHAR(255) NOT NULL,
                        "registration_date" DATE NOT NULL,
                        "flyer_number" BIGINT NOT NULL,
                        "address" VARCHAR(255) NOT NULL,
                        "user_type" VARCHAR(255) NOT NULL,
                        "password_hash" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id_user");
CREATE TABLE "flight"(
                         "id_flight" bigserial NOT NULL,
                         "flight_number" BIGINT NOT NULL,
                         "id_plane" BIGINT NOT NULL,
                         "id_departure_city" BIGINT NOT NULL,
                         "id_arrival_city" BIGINT NOT NULL,
                         "departure_time" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                         "arrival_time" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                         "status" VARCHAR(255) NOT NULL,
                         "flight_duration" TIME(0) WITHOUT TIME ZONE NOT NULL,
                         "distance_km" FLOAT(53) NOT NULL,
                         "seats" INTEGER NOT NULL,
                         "id_captain" BIGINT NOT NULL,
                         "id_subcaptain" BIGINT NOT NULL,
                         "price_economy" DECIMAL(8, 2) NOT NULL,
                         "price_business" DECIMAL(8, 2) NOT NULL,
                         "price_first_class" DECIMAL(8, 2) NOT NULL
);
ALTER TABLE
    "flight" ADD PRIMARY KEY("id_flight");
CREATE TABLE "booking"(
                                    "id_booking" bigserial NOT NULL,
                                    "id_flight" BIGINT NOT NULL,
                                    "id_user" BIGINT NOT NULL,
                                    "booking_date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                                    "booking_status" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "booking" ADD PRIMARY KEY("id_booking");
CREATE TABLE "passenger"(
                            "id_passenger" bigserial NOT NULL,
                            "id_seat" BIGINT NOT NULL,
                            "first_name" VARCHAR(255) NOT NULL,
                            "last_name" VARCHAR(255) NOT NULL,
                            "date_of_birth" DATE NOT NULL,
                            "document_id" VARCHAR(255) NOT NULL,
                            "passport_number" VARCHAR(255) NOT NULL,
                            "nationality" VARCHAR(255) NOT NULL,
                            "special_requests" VARCHAR(255) NOT NULL,
                            "luggage_included" BOOLEAN NOT NULL
);
ALTER TABLE
    "passenger" ADD PRIMARY KEY("id_passenger");
CREATE TABLE "booking_passenger"(
                                    "id_booking_passenger" bigserial NOT NULL,
                                    "id_booking" BIGINT NOT NULL,
                                    "id_passenger" BIGINT NOT NULL
);
ALTER TABLE
    "booking_passenger" ADD PRIMARY KEY("id_booking_passenger");
CREATE TABLE "scale"(
                        "id_scale" bigserial NOT NULL,
                        "id_flight" BIGINT NOT NULL,
                        "id_city" BIGINT NOT NULL,
                        "arrival_time" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                        "departure_time" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                        "layover_duration" TIME(0) WITHOUT TIME ZONE NOT NULL
);
ALTER TABLE
    "scale" ADD PRIMARY KEY("id_scale");
ALTER TABLE
    "booking_passenger" ADD CONSTRAINT "booking_passenger_id_booking_foreign" FOREIGN KEY("id_booking") REFERENCES "booking"("id_booking");
ALTER TABLE
    "scale" ADD CONSTRAINT "scale_id_flight_foreign" FOREIGN KEY("id_flight") REFERENCES "flight"("id_flight");
ALTER TABLE
    "city" ADD CONSTRAINT "city_country_id_foreign" FOREIGN KEY("country_id") REFERENCES "country"("id_country");
ALTER TABLE
    "flight" ADD CONSTRAINT "flight_id_departure_city_foreign" FOREIGN KEY("id_departure_city") REFERENCES "city"("id_city");
ALTER TABLE
    "flight" ADD CONSTRAINT "flight_id_plane_foreign" FOREIGN KEY("id_plane") REFERENCES "plane"("id_plane");
ALTER TABLE
    "booking_passenger" ADD CONSTRAINT "booking_passenger_id_passenger_foreign" FOREIGN KEY("id_passenger") REFERENCES "passenger"("id_passenger");
ALTER TABLE
    "seat" ADD CONSTRAINT "seat_id_flight_foreign" FOREIGN KEY("id_flight") REFERENCES "flight"("id_flight");
ALTER TABLE
    "scale" ADD CONSTRAINT "scale_id_city_foreign" FOREIGN KEY("id_city") REFERENCES "city"("id_city");
ALTER TABLE
    "booking" ADD CONSTRAINT "booking_id_flight_foreign" FOREIGN KEY("id_flight") REFERENCES "flight"("id_flight");
ALTER TABLE
    "passenger" ADD CONSTRAINT "passenger_id_seat_foreign" FOREIGN KEY("id_seat") REFERENCES "seat"("id_seat");
ALTER TABLE
    "flight" ADD CONSTRAINT "flight_id_arrival_city_foreign" FOREIGN KEY("id_arrival_city") REFERENCES "city"("id_city");
ALTER TABLE
    "flight" ADD CONSTRAINT "flight_id_subcaptain_foreign" FOREIGN KEY("id_subcaptain") REFERENCES "pilot"("id_pilot");
ALTER TABLE
    "booking" ADD CONSTRAINT "booking_id_user_foreign" FOREIGN KEY("id_user") REFERENCES "users"("id_user");
ALTER TABLE
    "luggage" ADD CONSTRAINT "luggage_id_passenger_foreign" FOREIGN KEY("id_passenger") REFERENCES "passenger"("id_passenger");
ALTER TABLE
    "payment" ADD CONSTRAINT "payment_id_booking_foreign" FOREIGN KEY("id_booking") REFERENCES "booking"("id_booking");
ALTER TABLE
    "flight" ADD CONSTRAINT "flight_id_captain_foreign" FOREIGN KEY("id_captain") REFERENCES "pilot"("id_pilot");



INSERT INTO pilot (first_name, last_name, license_number, date_of_birth, nationality, rank, hours_flown, employee_date, status, home_base, last_medical_check)
VALUES
    ('John', 'Doe', 'LIC12345', '1980-05-15', 'USA', 'Captain', 10000, '2005-03-01', 'Active', 'JFK', '2023-01-01'),
    ('Jane', 'Smith', 'LIC67890', '1975-10-22', 'Canada', 'First Officer', 8000, '2008-06-15', 'Active', 'YYZ', '2023-02-15'),
    ('Carlos', 'Gomez', 'LIC54321', '1982-03-09', 'Mexico', 'Captain', 9500, '2006-04-25', 'Active', 'MEX', '2023-03-10'),
    ('Emily', 'Johnson', 'LIC98765', '1988-07-12', 'UK', 'First Officer', 7500, '2010-09-12', 'Active', 'LHR', '2023-04-05'),
    ('Paul', 'Brown', 'LIC13579', '1979-02-18', 'Australia', 'Captain', 11000, '2004-12-05', 'Active', 'SYD', '2023-05-20'),
    ('Anna', 'Davis', 'LIC24680', '1990-11-05', 'Germany', 'First Officer', 7000, '2011-07-17', 'Active', 'FRA', '2023-06-25'),
    ('Robert', 'Wilson', 'LIC11223', '1977-04-23', 'Brazil', 'Captain', 12000, '2003-11-11', 'Active', 'GRU', '2023-07-15'),
    ('Maria', 'Martinez', 'LIC33445', '1985-01-30', 'Spain', 'First Officer', 6000, '2012-02-02', 'Active', 'MAD', '2023-08-10'),
    ('David', 'Miller', 'LIC55667', '1983-09-13', 'France', 'Captain', 9000, '2007-05-27', 'Active', 'CDG', '2023-09-01'),
    ('Sara', 'Garcia', 'LIC77889', '1987-06-19', 'Argentina', 'First Officer', 8500, '2010-03-30', 'Active', 'EZE', '2023-09-15');


INSERT INTO plane (model, manufacturer, capacity_economy, capacity_business, capacity_first_class, date_manufactured, last_maintenance_date, registration_number, fuel_capacity)
VALUES
    ('Boeing 737', 'Boeing', 180, 20, 10, '2010-03-15', '2024-09-01', 'N737EX', 26000),
    ('Airbus A320', 'Airbus', 190, 25, 15, '2012-06-21', '2024-08-20', 'F320AL', 25000),
    ('Boeing 777', 'Boeing', 300, 40, 20, '2009-11-11', '2024-07-10', 'B777EX', 35000),
    ('Airbus A350', 'Airbus', 280, 35, 25, '2013-09-05', '2024-06-30', 'A350XY', 34000),
    ('Boeing 787', 'Boeing', 260, 30, 20, '2015-01-22', '2024-05-15', 'B787XL', 33000);


INSERT INTO country (name, continent, language)
VALUES
    ('United States', 'North America', 'English'),
    ('Canada', 'North America', 'English'),
    ('Mexico', 'North America', 'Spanish'),
    ('United Kingdom', 'Europe', 'English'),
    ('France', 'Europe', 'French');


INSERT INTO city (name, country_id, timezone, latitude, longitude)
VALUES
    ('New York', 1, 'America/New_York', 40.7128, -74.0060),
    ('Toronto', 2, 'America/Toronto', 43.651070, -79.347015),
    ('Mexico City', 3, 'America/Mexico_City', 19.4326, -99.1332),
    ('London', 4, 'Europe/London', 51.5074, -0.1278),
    ('Paris', 5, 'Europe/Paris', 48.8566, 2.3522);


INSERT INTO flight (flight_number, id_plane, id_departure_city, id_arrival_city, departure_time, arrival_time, status, flight_duration, distance_km, seats, id_captain, id_subcaptain, price_economy, price_business, price_first_class)
VALUES
    (101, 1, 1, 2, '2024-10-10 10:00:00', '2024-10-10 14:00:00', 'Scheduled', '04:00:00', 1500, 180, 1, 2, 200.00, 500.00, 1000.00),
    (102, 2, 3, 4, '2024-10-11 08:00:00', '2024-10-11 12:00:00', 'Scheduled', '04:00:00', 1600, 200, 3, 4, 220.00, 520.00, 1020.00),
    (103, 3, 5, 5, '2024-10-12 14:00:00', '2024-10-12 18:00:00', 'Scheduled', '04:00:00', 1700, 220, 5, 6, 240.00, 540.00, 1040.00),
    (104, 4, 3, 2, '2024-10-13 16:00:00', '2024-10-13 20:00:00', 'Scheduled', '04:00:00', 1800, 240, 7, 8, 260.00, 560.00, 1060.00),
    (105, 5, 1, 5, '2024-10-14 12:00:00', '2024-10-14 16:00:00', 'Scheduled', '04:00:00', 1900, 250, 9, 10, 280.00, 580.00, 1080.00);

INSERT INTO seat (id_flight, seat_number, is_reserved, price, seat_class)
VALUES
    (1, '1A', FALSE, 200.00, 'Economy'),
    (1, '1B', FALSE, 200.00, 'Economy'),
    (1, '2A', FALSE, 220.00, 'Business'),
    (2, '2B', FALSE, 220.00, 'Business'),
    (2, '3A', FALSE, 240.00, 'First Class'),
    (3, '3B', FALSE, 240.00, 'First Class'),
    (4, '4A', FALSE, 260.00, 'Economy'),
    (5, '4B', FALSE, 260.00, 'Economy'),
    (5, '5A', FALSE, 280.00, 'Business'),
    (5, '5B', FALSE, 280.00, 'Business');


INSERT INTO scale (id_flight, id_city, arrival_time, departure_time, layover_duration)
VALUES
    (2, 3, '2024-10-10 13:00:00', '2024-10-10 14:00:00', '01:00:00'),
    (3, 4, '2024-10-11 11:00:00', '2024-10-11 12:00:00', '01:00:00');


INSERT INTO users (first_name, last_name, phone_number, email, nationality, date_of_birth, document_id, passport_number, registration_date, flyer_number, address, user_type, password_hash)
VALUES
    ('John', 'Doe', '1234567890', 'john.doe@example.com', 'USA', '1985-02-15', 'D1234567', 'P1234567', '2024-01-01', 10001, '1234 Elm Street', 'regular', 'hash_password1'),
    ('Jane', 'Smith', '2345678901', 'jane.smith@example.com', 'Canada', '1990-03-22', 'S2345678', 'P2345678', '2024-01-05', 10002, '5678 Maple Avenue', 'regular', 'hash_password2'),
    ('Mike', 'Johnson', '3456789012', 'mike.johnson@example.com', 'UK', '1988-07-10', 'J3456789', 'P3456789', '2024-01-10', 10003, '9012 Oak Drive', 'premium', 'hash_password3'),
    ('Emily', 'Brown', '4567890123', 'emily.brown@example.com', 'Australia', '1995-05-14', 'B4567890', 'P4567890', '2024-02-02', 10004, '3456 Pine Lane', 'regular', 'hash_password4'),
    ('Chris', 'Davis', '5678901234', 'chris.davis@example.com', 'New Zealand', '1992-09-18', 'D5678901', 'P5678901', '2024-02-15', 10005, '7890 Cedar Court', 'regular', 'hash_password5'),
    ('Sarah', 'Miller', '6789012345', 'sarah.miller@example.com', 'Germany', '1991-11-25', 'M6789012', 'P6789012', '2024-02-20', 10006, '1234 Birch Way', 'premium', 'hash_password6'),
    ('David', 'Wilson', '7890123456', 'david.wilson@example.com', 'France', '1989-04-30', 'W7890123', 'P7890123', '2024-02-28', 10007, '5678 Redwood Road', 'regular', 'hash_password7'),
    ('Jessica', 'Moore', '8901234567', 'jessica.moore@example.com', 'Spain', '1987-12-12', 'M8901234', 'P8901234', '2024-03-01', 10008, '9012 Willow Drive', 'regular', 'hash_password8'),
    ('Daniel', 'Taylor', '9012345678', 'daniel.taylor@example.com', 'Italy', '1993-06-08', 'T9012345', 'P9012345', '2024-03-10', 10009, '3456 Palm Avenue', 'regular', 'hash_password9'),
    ('Sophia', 'Anderson', '0123456789', 'sophia.anderson@example.com', 'Japan', '1986-01-04', 'A0123456', 'P0123456', '2024-03-15', 10010, '7890 Cypress Boulevard', 'premium', 'hash_password10');
