CREATE TABLE "users"(
                       "id_users" BIGINT NOT NULL,
                       "name" VARCHAR(255) NOT NULL,
                       "lastname" VARCHAR(255) NOT NULL,
                       "email" VARCHAR(255) NOT NULL,
                       "genrer" VARCHAR(255) NOT NULL,
                       "birthday" DATE NOT NULL,
                       "country" VARCHAR(255) NOT NULL,
                       "city" VARCHAR(255) NOT NULL,
                       "document_id" VARCHAR(255) NOT NULL,
                       "passport_number" VARCHAR(255) NOT NULL,
                       "register_date" DATE NOT NULL
);
ALTER TABLE
    "users" ADD PRIMARY KEY("id_users");
CREATE TABLE "luggage"(
                          "id_luggage" BIGINT NOT NULL,
                          "id_passenger" BIGINT NOT NULL,
                          "type" VARCHAR(255) NOT NULL,
                          "height" FLOAT(53) NOT NULL,
                          "width" FLOAT(53) NOT NULL,
                          "weight" FLOAT(53) NOT NULL
);
ALTER TABLE
    "luggage" ADD PRIMARY KEY("id_luggage");
CREATE TABLE "booking_passenger"(
                                    "id_booking" BIGINT NOT NULL,
                                    "id_passenger" BIGINT NOT NULL
);
ALTER TABLE
    "booking_passenger" ADD PRIMARY KEY("id_booking", "id_passenger");
CREATE TABLE "passenger"(
                            "id_passenger" BIGINT NOT NULL,
                            "id_seat" BIGINT NOT NULL,
                            "name" VARCHAR(255) NOT NULL,
                            "lastname" VARCHAR(255) NOT NULL,
                            "birthday" DATE NOT NULL,
                            "document_id" VARCHAR(255) NOT NULL,
                            "passport_number" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "passenger" ADD PRIMARY KEY("id_passenger");
CREATE TABLE "users_booking"(
                               "id_users" BIGINT NOT NULL,
                               "id_booking" BIGINT NOT NULL
);
ALTER TABLE
    "users_booking" ADD PRIMARY KEY("id_users", "id_booking");
CREATE TABLE "flight"(
                         "id_flight" BIGINT NOT NULL,
                         "id_plane" BIGINT NOT NULL,
                         "origin" VARCHAR(255) NOT NULL,
                         "destination" VARCHAR(255) NOT NULL,
                         "departure_date" DATE NOT NULL,
                         "arrival_date" DATE NOT NULL,
                         "status" VARCHAR(255) NOT NULL,
                         "aeroline" VARCHAR(255) NOT NULL,
                         "captain" VARCHAR(255) NOT NULL,
                         "sub_captain" VARCHAR(255) NOT NULL
);
ALTER TABLE
    "flight" ADD PRIMARY KEY("id_flight");
CREATE TABLE "payments"(
                           "id" BIGINT NOT NULL,
                           "id_booking" BIGINT NOT NULL,
                           "id_users" BIGINT NOT NULL
);
ALTER TABLE
    "payments" ADD PRIMARY KEY("id");
CREATE TABLE "booking"(
                          "id_booking" BIGINT NOT NULL,
                          "id_flight" BIGINT NOT NULL,
                          "status" BIGINT NOT NULL,
                          "created_at" DATE NOT NULL,
                          "updated_at" DATE NOT NULL,
                          "payment_id" BIGINT NOT NULL
);
ALTER TABLE
    "booking" ADD PRIMARY KEY("id_booking");
CREATE TABLE "seat"(
                       "id_seat" BIGINT NOT NULL,
                       "id_flight" BIGINT NOT NULL,
                       "seat_type" VARCHAR(255) NOT NULL,
                       "is_avaliable" BOOLEAN NOT NULL,
                       "price" FLOAT(53) NOT NULL
);
ALTER TABLE
    "seat" ADD PRIMARY KEY("id_seat");
CREATE TABLE "plane"(
                        "id_plane" BIGINT NOT NULL,
                        "model" VARCHAR(255) NOT NULL,
                        "capacity_max" INTEGER NOT NULL
);
ALTER TABLE
    "plane" ADD PRIMARY KEY("id_plane");
ALTER TABLE
    "passenger" ADD CONSTRAINT "passenger_id_seat_foreign" FOREIGN KEY("id_seat") REFERENCES "seat"("id_seat");
ALTER TABLE
    "booking_passenger" ADD CONSTRAINT "booking_passenger_id_passenger_foreign" FOREIGN KEY("id_passenger") REFERENCES "passenger"("id_passenger");
ALTER TABLE
    "users_booking" ADD CONSTRAINT "users_booking_id_booking_foreign" FOREIGN KEY("id_booking") REFERENCES "booking"("id_booking");
ALTER TABLE
    "flight" ADD CONSTRAINT "flight_id_plane_foreign" FOREIGN KEY("id_plane") REFERENCES "plane"("id_plane");
ALTER TABLE
    "users_booking" ADD CONSTRAINT "users_booking_id_users_foreign" FOREIGN KEY("id_users") REFERENCES "users"("id_users");
ALTER TABLE
    "luggage" ADD CONSTRAINT "luggage_id_passenger_foreign" FOREIGN KEY("id_passenger") REFERENCES "passenger"("id_passenger");
ALTER TABLE
    "booking_passenger" ADD CONSTRAINT "booking_passenger_id_booking_foreign" FOREIGN KEY("id_booking") REFERENCES "booking"("id_booking");
ALTER TABLE
    "booking" ADD CONSTRAINT "booking_id_flight_foreign" FOREIGN KEY("id_flight") REFERENCES "flight"("id_flight");
ALTER TABLE
    "seat" ADD CONSTRAINT "seat_id_flight_foreign" FOREIGN KEY("id_flight") REFERENCES "flight"("id_flight");



INSERT INTO "users" ("id_users", "name", "lastname", "email", "genrer", "birthday", "country", "city", "document_id", "passport_number", "register_date")
VALUES
    (1, 'John', 'Doe', 'john.doe@example.com', 'Male', '1990-01-01', 'USA', 'New York', '123456789', 'US1234567', '2023-01-01'),
    (2, 'Jane', 'Smith', 'jane.smith@example.com', 'Female', '1992-02-02', 'USA', 'Los Angeles', '987654321', 'US9876543', '2023-01-15'),
    (3, 'Robert', 'Johnson', 'robert.johnson@example.com', 'Male', '1985-05-05', 'Canada', 'Toronto', '456123789', 'CA4567891', '2023-02-20');

INSERT INTO "plane" ("id_plane", "model", "capacity_max")
VALUES
    (1, 'Boeing 737', 150),
    (2, 'Airbus A320', 180);

INSERT INTO "flight" ("id_flight", "id_plane", "origin", "destination", "departure_date", "arrival_date", "status", "aeroline", "captain", "sub_captain")
VALUES
    (1, 1, 'New York', 'Los Angeles', '2024-10-01', '2024-10-01', 'On Time', 'Delta', 'Captain A', 'Sub Captain B'),
    (2, 2, 'Toronto', 'Miami', '2024-10-05', '2024-10-05', 'Delayed', 'Air Canada', 'Captain C', 'Sub Captain D');

INSERT INTO "seat" ("id_seat", "id_flight", "seat_type", "is_avaliable", "price")
VALUES
    (1, 1, 'Economy', TRUE, 300.00),
    (2, 1, 'Business', FALSE, 600.00),
    (3, 2, 'Economy', TRUE, 350.00);

INSERT INTO "passenger" ("id_passenger", "id_seat", "name", "lastname", "birthday", "document_id", "passport_number")
VALUES
    (1, 1, 'John', 'Doe', '1990-01-01', '123456789', 'US1234567'),
    (2, 2, 'Jane', 'Smith', '1992-02-02', '987654321', 'US9876543');

INSERT INTO "luggage" ("id_luggage", "id_passenger", "type", "height", "width", "weight")
VALUES
    (1, 1, 'Checked', 24.5, 15.5, 23.0),
    (2, 2, 'Carry-on', 18.0, 12.0, 10.0);

INSERT INTO "booking" ("id_booking", "id_flight", "status", "created_at", "updated_at", "payment_id")
VALUES
    (1, 1, 1, '2024-09-10', '2024-09-10', 1),
    (2, 2, 1, '2024-09-12', '2024-09-12', 2);

INSERT INTO "booking_passenger" ("id_booking", "id_passenger")
VALUES
    (1, 1),
    (2, 2);

INSERT INTO "users_booking" ("id_users", "id_booking")
VALUES
    (1, 1),
    (2, 2);

INSERT INTO "payments" ("id", "id_booking", "id_users")
VALUES
    (1, 1, 1),
    (2, 2, 2);

