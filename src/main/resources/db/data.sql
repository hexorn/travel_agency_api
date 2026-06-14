INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8445-4495f3db0b8a', 'testusername', 'testpassword', 'ADMIN', '39092939', 139000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', 'john_doe', 'password123', 'USER', '38071234567', 50000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', 'jane_smith', 'securepass', 'USER', '38097654321', 75000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', 'bob_manager', 'managerpass', 'MANAGER', '38063334455', 120000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', 'alice_admin', 'adminpass', 'ADMIN', '38050998877', 200000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8450-5f7ab8c9d0e1', 'charlie_user', 'charliepass', 'USER', '38093112233', 30000, false);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8451-6a8bc9d0e1f2', 'diana_user', 'dianapass', 'USER', '38066445566', 90000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8452-7b9cd0e1f2a3', 'evan_manager', 'evanpass', 'MANAGER', '38099778899', 150000, true);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8453-8caed1f2a3b4', 'fiona_user', 'fionapass', 'USER', '38073221100', 45000, false);
INSERT INTO users(id, username, password, role, phone_number, balance, active) VALUES ('019ebbf2-72c2-74e9-8454-9dbfe2a3b4c5', 'george_user', 'georgepass', 'USER', '38050334455', 60000, true);

-- testusername (019ebbf2-72c2-74e9-8445-4495f3db0b8a)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebc0f-8c85-7b01-8f47-9f8b69ec5d8b', 'Safari Adventure Kenya', 'Exciting safari tour through the Kenyan savannah', 2500.00, 'SAFARI', 'JEEPS', 'FOUR_STARS', 'REGISTERED', '2024-06-01', '2024-06-10', '019ebbf2-72c2-74e9-8445-4495f3db0b8a', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8445-4495f3db0002', 'Bali Leisure Escape', 'Relaxing beach holiday on the island of Bali', 1900.00, 'LEISURE', 'PLANE', 'FIVE_STARS', 'PAID', '2024-07-10', '2024-07-20', '019ebbf2-72c2-74e9-8445-4495f3db0b8a', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8445-4495f3db0003', 'Himalaya Trek Adventure', 'Challenging adventure trek through Himalayan trails', 3500.00, 'ADVENTURE', 'MINIBUS', 'THREE_STARS', 'REGISTERED', '2024-08-15', '2024-08-30', '019ebbf2-72c2-74e9-8445-4495f3db0b8a', false);

-- john_doe (019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebc0f-8c85-7561-ab03-0363eb925dc3', 'Paris Wine Tour', 'Exclusive wine tasting across French vineyards', 1800.00, 'WINE', 'TRAIN', 'FIVE_STARS', 'PAID', '2024-07-15', '2024-07-22', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebc0f-8c85-7f09-ab5a-a12557c99bcf', 'Tokyo Cultural Journey', 'Immersive cultural experience in modern Tokyo', 2700.00, 'CULTURAL', 'PLANE', 'FOUR_STARS', 'REGISTERED', '2024-09-01', '2024-09-10', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebc0f-8c85-702a-b247-c528ab0e452e', 'Costa Rica Eco Tour', 'Sustainable eco tour through Costa Rican rainforest', 1600.00, 'ECO', 'JEEPS', 'THREE_STARS', 'CANCELED', '2024-10-05', '2024-10-15', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebc0f-8c85-7a2f-b48f-22c8e715ae8a', 'Maldives Leisure Resort', 'Luxury leisure stay at a private Maldives island', 4500.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'PAID', '2024-11-01', '2024-11-10', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', true);

-- jane_smith (019ebbf2-72c2-74e9-8447-2c4de5f6a7b8)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a701', 'Alpine Health Retreat', 'Relaxing health and wellness retreat in the Swiss Alps', 3200.00, 'HEALTH', 'PLANE', 'FIVE_STARS', 'PAID', '2024-08-05', '2024-08-15', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a702', 'Sahara Desert Safari', 'Thrilling jeep safari across the Sahara desert dunes', 2200.00, 'SAFARI', 'JEEPS', 'TWO_STARS', 'REGISTERED', '2024-09-20', '2024-09-28', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a703', 'Tuscany Wine Experience', 'Guided wine tour through the hills of Tuscany', 1700.00, 'WINE', 'PRIVATE_CAR', 'FOUR_STARS', 'PAID', '2024-10-12', '2024-10-19', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a704', 'Patagonia Adventure Trek', 'Extreme adventure trekking in the wilds of Patagonia', 4000.00, 'ADVENTURE', 'BUS', 'THREE_STARS', 'REGISTERED', '2024-11-15', '2024-11-28', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', true);

-- bob_manager (019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b801', 'Amazon Eco Tour', 'Immersive eco tour through the Amazon rainforest', 1500.00, 'ECO', 'MINIBUS', 'THREE_STARS', 'REGISTERED', '2024-09-10', '2024-09-20', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b802', 'Iceland Sports Expedition', 'Action-packed sports tour across volcanic Iceland', 3800.00, 'SPORTS', 'ELECTRICAL_CARS', 'FOUR_STARS', 'PAID', '2024-10-01', '2024-10-10', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b803', 'Greek Islands Cruise', 'Luxury cruise through the beautiful Greek islands', 2900.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'PAID', '2024-11-05', '2024-11-15', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', true);

-- alice_admin (019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c901', 'Rome Cultural Experience', 'Deep dive into Roman history and culture', 2100.00, 'CULTURAL', 'PLANE', 'FOUR_STARS', 'CANCELED', '2024-10-01', '2024-10-08', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c902', 'Tibetan Health Journey', 'Spiritual health and meditation retreat in Tibet', 2800.00, 'HEALTH', 'PLANE', 'THREE_STARS', 'REGISTERED', '2024-11-10', '2024-11-20', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c903', 'Norway Sports Adventure', 'Skiing and winter sports in the Norwegian mountains', 3300.00, 'SPORTS', 'TRAIN', 'FOUR_STARS', 'PAID', '2024-12-01', '2024-12-10', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c904', 'Bordeaux Wine Route', 'Prestigious wine route through the Bordeaux region', 2400.00, 'WINE', 'PRIVATE_CAR', 'FIVE_STARS', 'REGISTERED', '2024-12-15', '2024-12-22', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', true);