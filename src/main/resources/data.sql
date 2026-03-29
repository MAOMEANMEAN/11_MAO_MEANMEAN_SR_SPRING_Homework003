INSERT INTO venues (venue_name, location) VALUES ( 'KSHRD', 'Boeng Kok II'),
                          ( 'RUPP', 'Toul Kork'),
                          ( 'NUM', 'Daun Penh'),
                          ( 'Vanda', 'Toul Tompung'),
                          ( 'Western', 'Americ');

INSERT INTO events (event_name, event_date, venue_id) VALUES ( 'KSHRD Party', '2026-09-23',1),
                          ( 'RUPP Event', '2026-07-07',2),
                          ( 'NUM Event', '2026-09-28',3),
                          ( 'Vanda Khmer New Year', '2026-04-12',4),
                          ( 'Western Songkran', '2026-04-08',5);

INSERT INTO attendees (attendee_name, email) VALUES ( 'Sanguku', 'sangu@gmail.com'),
                                                    ('Linlin', 'lin@gmail.com'),
                                                    ('Sugar', 'sugar@gmail.com'),
                                                    ('Sanji', 'sanji@gmail.com'),
                                                    ('Namie', 'namie@gmail.com');

INSERT INTO event_attendee (event_id, attendee_id) VALUES ('1', '1'),
                                                          ('2','2'),
                                                          ('3', '3'),
                                                          ('4', '4'),
                                                          ('5', '5');


