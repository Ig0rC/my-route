CREATE TABLE users (
  id UUID PRIMARY KEY,
  email VARCHAR(180) UNIQUE NOT NULL,
  password VARCHAR(180) NOT NULL,
  created_at TIMESTAMP NOT NULL
);

CREATE TABLE employees (
  id UUID PRIMARY KEY,
  full_name VARCHAR(180) NOT NULL,
  position VARCHAR(180),
  registration VARCHAR(180),
  lot_number VARCHAR(180),
  user_id UUID NOT NULL,
  created_at TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE cars (
  id UUID PRIMARY KEY,
  year VARCHAR(4) NOT NULL,
  plate VARCHAR(180) NOT NULL,
  mark VARCHAR(180) NOT NULL,
  model VARCHAR(180) NOT NULL,
  user_id UUID NOT NULL,
  created_at TIMESTAMP NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE services_month (
  id UUID PRIMARY KEY,
  date_month DATE NOT NULL,
  car_id UUID NOT NULL,
  created_at TIMESTAMP NOT NULL,

  FOREIGN KEY (car_id) REFERENCES cars(id)
);

CREATE TABLE services_day (
  id UUID PRIMARY KEY,
  service_date TIMESTAMP NOT NULL,
  description_service TEXT,
  departure_time VARCHAR(5) NOT NULL,
  arrival_time VARCHAR(5) NOT NULL,
  departure_odometer INT NOT NULL,
  arrival_odometer INT NOT NULL,
  service_month_id UUID NOT NULL,
  created_at TIMESTAMP NOT NULL,
  FOREIGN KEY (service_month_id) REFERENCES services_month(id)
);
