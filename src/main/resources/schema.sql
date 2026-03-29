CREATE TABLE IF NOT EXISTS venues(
    venue_id SERIAL PRIMARY KEY,
    venue_name VARCHAR(50) NOT NULL,
    location VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS events(
    event_id SERIAL PRIMARY KEY,
    event_name VARCHAR(50) NOT NULL,
    event_date DATE,
    venue_id INT NOT NULL,
    CONSTRAINT fk_venue FOREIGN KEY (venue_id) REFERENCES venues (venue_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS attendees(
    attendee_id SERIAL PRIMARY KEY,
    attendee_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS event_attendee(
    attendee_id INT,
    event_id INT,
    PRIMARY KEY (attendee_id, event_id),
    FOREIGN KEY (attendee_id) REFERENCES attendees(attendee_id) ON DELETE CASCADE,
    FOREIGN KEY (event_id) REFERENCES events(event_id) ON DELETE CASCADE
);