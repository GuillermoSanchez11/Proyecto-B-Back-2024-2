CREATE TABLE "payment"(
                          "id" BIGINT NOT NULL,
                          "id_booking" BIGINT NOT NULL,
                          "amount" DECIMAL(8, 2) NOT NULL,
                          "payment_date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                          "payment_status" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "payment" ADD PRIMARY KEY("id");
CREATE TABLE "pilot"(
                        "id_pilot" BIGINT NOT NULL,
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
                       "id_seat" BIGINT NOT NULL,
                       "id_flight" BIGINT NOT NULL,
                       "seat_number" VARCHAR(255) NOT NULL,
                       "is_reserved" BOOLEAN NOT NULL,
                       "price" DECIMAL(8, 2) NOT NULL,
                       "seat_class" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "seat" ADD PRIMARY KEY("id_seat");
CREATE TABLE "city"(
                       "id_city" BIGINT NOT NULL,
                       "name" VARCHAR(255) NOT NULL,
                       "country_id" BIGINT NOT NULL,
                       "timezone" VARCHAR(255) NOT NULL,
                       "latitude" FLOAT(53) NOT NULL,
                       "longitude" FLOAT(53) NOT NULL
);
ALTER TABLE
    "city" ADD PRIMARY KEY("id_city");
CREATE TABLE "luggage"(
                          "id_luggage" BIGINT NOT NULL,
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
                          "id_country" BIGINT NOT NULL,
                          "name" VARCHAR(255) NOT NULL,
                          "continent" VARCHAR(255) NOT NULL,
                          "language" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "country" ADD PRIMARY KEY("id_country");
CREATE TABLE "plane"(
                        "id_plane" BIGINT NOT NULL,
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
                        "id_user" BIGINT NOT NULL,
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
                         "id_flight" BIGINT NOT NULL,
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
                          "id_booking" BIGINT NOT NULL,
                          "id_flight" BIGINT NOT NULL,
                          "id_user" BIGINT NOT NULL,
                          "booking_date" TIMESTAMP(0) WITHOUT TIME ZONE NOT NULL,
                          "booking_status" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "booking" ADD PRIMARY KEY("id_booking");
CREATE TABLE "passenger"(
                            "id_passenger" BIGINT NOT NULL,
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
                                    "id" BIGINT NOT NULL,
                                    "id_booking" BIGINT NOT NULL,
                                    "id_passenger" BIGINT NOT NULL
);
ALTER TABLE
    "booking_passenger" ADD PRIMARY KEY("id");
CREATE TABLE "scale"(
                        "id_scale" BIGINT NOT NULL,
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


-- Insertar datos en la tabla country
INSERT INTO "country" ("id_country", "name", "continent", "language") VALUES
                                                                          (1, 'USA', 'North America', 'English'),
                                                                          (2, 'Canada', 'North America', 'English'),
                                                                          (3, 'Mexico', 'North America', 'Spanish');

-- Insertar datos en la tabla city
INSERT INTO "city" ("id_city", "name", "country_id", "timezone", "latitude", "longitude") VALUES
                                                                                              (1, 'New York', 1, 'UTC-5', 40.7128, -74.0060),
                                                                                              (2, 'Toronto', 2, 'UTC-5', 43.6510, -79.3470),
                                                                                              (3, 'Mexico City', 3, 'UTC-6', 19.4326, -99.1332);

-- Insertar datos en la tabla plane
INSERT INTO "plane" ("id_plane", "model", "manufacturer", "capacity_economy", "capacity_business", "capacity_first_class", "date_manufactured", "last_maintenance_date", "registration_number", "fuel_capacity") VALUES
                                                                                                                                                                                                                     (1, 'Boeing 737', 'Boeing', 150, 20, 10, '2015-01-01', '2023-01-01', 'N12345', 20000),
                                                                                                                                                                                                                     (2, 'Airbus A320', 'Airbus', 180, 30, 12, '2017-01-01', '2023-06-01', 'N67890', 25000);

-- Insertar datos en la tabla pilot
INSERT INTO "pilot" ("id_pilot", "first_name", "last_name", "license_number", "date_of_birth", "nationality", "rank", "hours_flown", "employee_date", "status", "home_base", "last_medical_check") VALUES
                                                                                                                                                                                                       (1, 'John', 'Doe', 'ABC123', '1980-01-01', 'USA', 'Captain', 5000, '2010-05-01', 'Active', 'New York', '2023-01-01'),
                                                                                                                                                                                                       (2, 'Jane', 'Smith', 'XYZ789', '1985-02-02', 'Canada', 'First Officer', 3000, '2015-03-01', 'Active', 'Toronto', '2023-06-01');

-- Insertar datos en la tabla flight
INSERT INTO "flight" ("id_flight", "flight_number", "id_plane", "id_departure_city", "id_arrival_city", "departure_time", "arrival_time", "status", "flight_duration", "distance_km", "seats", "id_captain", "id_subcaptain", "price_economy", "price_business", "price_first_class") VALUES
    (1, 1001, 1, 1, 2, '2024-01-01 08:00:00', '2024-01-01 10:00:00', 'Scheduled', '02:00:00', 500, 150, 1, 2, 200.00, 400.00, 600.00);

-- Insertar datos en la tabla seat
INSERT INTO "seat" ("id_seat", "id_flight", "seat_number", "is_reserved", "price", "seat_class") VALUES
                                                                                                     (1, 1, '12A', true, 200.00, 'Economy'),
                                                                                                     (2, 1, '12B', false, 200.00, 'Economy');

-- Insertar datos en la tabla users
INSERT INTO "users" ("id_user", "first_name", "last_name", "phone_number", "email", "nationality", "date_of_birth", "document_id", "passport_number", "registration_date", "flyer_number", "address", "user_type", "password_hash") VALUES
    (1, 'Alice', 'Johnson', '1234567890', 'alice@example.com', 'USA', '1990-01-01', 'DOC123', 'PASS123', '2023-01-01', 1, '123 Main St', 'Customer', 'hashed_password');

-- Insertar datos en la tabla booking
INSERT INTO "booking" ("id_booking", "id_flight", "id_user", "booking_date", "booking_status") VALUES
    (1, 1, 1, '2024-01-01 07:00:00', 'Confirmed');

-- Insertar datos en la tabla payment
INSERT INTO "payment" ("id", "id_booking", "amount", "payment_date", "payment_status") VALUES
    (1, 1, 150.00, '2024-01-01 07:30:00', 'Paid');

-- Insertar datos en la tabla passenger
INSERT INTO "passenger" ("id_passenger", "id_seat", "first_name", "last_name", "date_of_birth", "document_id", "passport_number", "nationality", "special_requests", "luggage_included") VALUES
    (1, 1, 'Bob', 'Brown', '1985-01-01', 'DOC456', 'PASS456', 'USA', 'Vegetarian meal', true);

-- Insertar datos en la tabla luggage
INSERT INTO "luggage" ("id_luggage", "id_passenger", "type", "height_cm", "weight_kg", "width_cm", "extra_free") VALUES
    (1, 1, 'Carry-on', 55.00, 7.00, 40.00, 0.00);

-- Insertar datos en la tabla scale
INSERT INTO "scale" ("id_scale", "id_flight", "id_city", "arrival_time", "departure_time", "layover_duration") VALUES
    (1, 1, 1, '2024-01-01 09:00:00', '2024-01-01 09:30:00', '00:30:00');

-- Insertar datos en la tabla booking_passenger
INSERT INTO "booking_passenger" ("id", "id_booking", "id_passenger") VALUES
    (1, 1, 1);
