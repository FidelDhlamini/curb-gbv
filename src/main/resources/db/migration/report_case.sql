CREATE TABLE reportCase (
    id serial NOT NULL PRIMARY KEY,
    name text,
    contact TEXT,
    location TEXT,
    details TEXT NOT NULL,
    contactMe TEXT,
    resolved BOOLEAN
);