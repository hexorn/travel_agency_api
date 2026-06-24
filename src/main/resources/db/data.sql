-- Users
INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8445-4495f3db0b8a', 'adminFirstName', 'adminLastName', 'adminEmail@example.com', '$2a$10$hObr3ECKLAdvhSXbTMgY6.BmnaDI.YAC2m.f.MnMzgx8VXae7e4Gm', 'ADMIN', 139000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', 'John', 'Doe Manager', 'john.doe@example.com', '$2a$10$hObr3ECKLAdvhSXbTMgY6.BmnaDI.YAC2m.f.MnMzgx8VXae7e4Gm', 'MANAGER', 50000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', 'Jane', 'Smith User', 'jane.smith@example.com', '$2a$10$hObr3ECKLAdvhSXbTMgY6.BmnaDI.YAC2m.f.MnMzgx8VXae7e4Gm', 'USER', 75000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', 'Bob', 'Manager', 'bob.manager@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'MANAGER', 120000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', 'Alice', 'Admin', 'alice.admin@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'ADMIN', 200000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8450-5f7ab8c9d0e1', 'Charlie', 'User', 'charlie.user@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'USER', 30000, false);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8451-6a8bc9d0e1f2', 'Diana', 'User', 'diana.user@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'USER', 90000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8452-7b9cd0e1f2a3', 'Evan', 'Manager', 'evan.manager@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'MANAGER', 150000, true);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8453-8caed1f2a3b4', 'Fiona', 'User', 'fiona.user@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'USER', 45000, false);

INSERT INTO users(id, first_name, last_name, email, password, role, balance, active)
VALUES ('019ebbf2-72c2-74e9-8454-9dbfe2a3b4c5', 'George', 'User', 'george.user@example.com', '$2a$10$MnWeCytf/BGPGymw84hdzuau6m2IE7K62BDEnnKQYkoNIe8BqaWni', 'USER', 60000, true);


-- Vouchers (3-4 на каждого юзера)

-- adminFirstName (019ebbf2-72c2-74e9-8445-4495f3db0b8a)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8445-4495f3db0001', 'Safari Adventure Kenya', 'Exciting safari tour through the Kenyan savannah', 2500.00, 'SAFARI', 'JEEPS', 'FOUR_STARS', 'REGISTERED', '2024-06-01', '2024-06-10', '019ebbf2-72c2-74e9-8445-4495f3db0b8a', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8445-4495f3db0002', 'Bali Leisure Escape', 'Relaxing beach holiday on the island of Bali', 1900.00, 'LEISURE', 'PLANE', 'FIVE_STARS', 'PAID', '2024-07-10', '2024-07-20', '019ebbf2-72c2-74e9-8445-4495f3db0b8a', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8445-4495f3db0003', 'Himalaya Trek Adventure', 'Challenging adventure trek through Himalayan trails', 3500.00, 'ADVENTURE', 'MINIBUS', 'THREE_STARS', 'REGISTERED', '2024-08-15', '2024-08-30', '019ebbf2-72c2-74e9-8445-4495f3db0b8a', false);

-- John Doe (019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8446-1b3cd4e50001', 'Paris Wine Tour', 'Exclusive wine tasting across French vineyards', 1800.00, 'WINE', 'TRAIN', 'FIVE_STARS', 'PAID', '2024-07-15', '2024-07-22', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8446-1b3cd4e50002', 'Tokyo Cultural Journey', 'Immersive cultural experience in modern Tokyo', 2700.00, 'CULTURAL', 'PLANE', 'FOUR_STARS', 'REGISTERED', '2024-09-01', '2024-09-10', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8446-1b3cd4e50003', 'Costa Rica Eco Tour', 'Sustainable eco tour through Costa Rican rainforest', 1600.00, 'ECO', 'JEEPS', 'THREE_STARS', 'CANCELED', '2024-10-05', '2024-10-15', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8446-1b3cd4e50004', 'Maldives Leisure Resort', 'Luxury leisure stay at a private Maldives island', 4500.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'PAID', '2024-11-01', '2024-11-10', '019ebbf2-72c2-74e9-8446-1b3cd4e5f6a7', true);

-- Jane Smith (019ebbf2-72c2-74e9-8447-2c4de5f6a7b8)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a701', 'Alpine Health Retreat', 'Relaxing health and wellness retreat in the Swiss Alps', 3200.00, 'HEALTH', 'PLANE', 'FIVE_STARS', 'PAID', '2024-08-05', '2024-08-15', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a702', 'Sahara Desert Safari', 'Thrilling jeep safari across the Sahara desert dunes', 2200.00, 'SAFARI', 'JEEPS', 'TWO_STARS', 'REGISTERED', '2024-09-20', '2024-09-28', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8447-2c4de5f6a703', 'Tuscany Wine Experience', 'Guided wine tour through the hills of Tuscany', 1700.00, 'WINE', 'PRIVATE_CAR', 'FOUR_STARS', 'PAID', '2024-10-12', '2024-10-19', '019ebbf2-72c2-74e9-8447-2c4de5f6a7b8', false);

-- Bob Manager (019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b801', 'Amazon Eco Tour', 'Immersive eco tour through the Amazon rainforest', 1500.00, 'ECO', 'MINIBUS', 'THREE_STARS', 'REGISTERED', '2024-09-10', '2024-09-20', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b802', 'Iceland Sports Expedition', 'Action-packed sports tour across volcanic Iceland', 3800.00, 'SPORTS', 'ELECTRICAL_CARS', 'FOUR_STARS', 'PAID', '2024-10-01', '2024-10-10', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b803', 'Greek Islands Cruise', 'Luxury cruise through the beautiful Greek islands', 2900.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'PAID', '2024-11-05', '2024-11-15', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8448-3d5ef6a7b804', 'Norway Fjords Sports Tour', 'Kayaking and hiking adventure across Norwegian fjords', 3300.00, 'SPORTS', 'BUS', 'THREE_STARS', 'REGISTERED', '2024-12-01', '2024-12-10', '019ebbf2-72c2-74e9-8448-3d5ef6a7b8c9', false);

-- Alice Admin (019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c901', 'Rome Cultural Experience', 'Deep dive into Roman history and culture', 2100.00, 'CULTURAL', 'PLANE', 'FOUR_STARS', 'CANCELED', '2024-10-01', '2024-10-08', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c902', 'Tibetan Health Journey', 'Spiritual health and meditation retreat in Tibet', 2800.00, 'HEALTH', 'PLANE', 'THREE_STARS', 'REGISTERED', '2024-11-10', '2024-11-20', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8449-4e6fa7b8c903', 'Bordeaux Wine Route', 'Prestigious wine route through the Bordeaux region', 2400.00, 'WINE', 'PRIVATE_CAR', 'FIVE_STARS', 'REGISTERED', '2024-12-15', '2024-12-22', '019ebbf2-72c2-74e9-8449-4e6fa7b8c9d0', true);

-- Charlie User (019ebbf2-72c2-74e9-8450-5f7ab8c9d0e1)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8450-5f7ab8c90001', 'Patagonia Adventure Trek', 'Extreme adventure trekking in the wilds of Patagonia', 4000.00, 'ADVENTURE', 'BUS', 'THREE_STARS', 'REGISTERED', '2024-06-15', '2024-06-28', '019ebbf2-72c2-74e9-8450-5f7ab8c9d0e1', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8450-5f7ab8c90002', 'Vienna Cultural Tour', 'Classical music and culture tour through Vienna', 1900.00, 'CULTURAL', 'TRAIN', 'FOUR_STARS', 'PAID', '2024-07-20', '2024-07-27', '019ebbf2-72c2-74e9-8450-5f7ab8c9d0e1', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8450-5f7ab8c90003', 'Galapagos Eco Expedition', 'Wildlife and eco exploration in the Galapagos Islands', 5200.00, 'ECO', 'SHIP', 'FOUR_STARS', 'REGISTERED', '2024-08-10', '2024-08-22', '019ebbf2-72c2-74e9-8450-5f7ab8c9d0e1', true);

-- Diana User (019ebbf2-72c2-74e9-8451-6a8bc9d0e1f2)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8451-6a8bc9d00001', 'Marrakech Leisure Getaway', 'Relaxing leisure stay in the heart of Marrakech', 1600.00, 'LEISURE', 'PRIVATE_CAR', 'FOUR_STARS', 'PAID', '2024-09-05', '2024-09-12', '019ebbf2-72c2-74e9-8451-6a8bc9d0e1f2', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8451-6a8bc9d00002', 'Maui Health Wellness Retreat', 'Tropical health and wellness retreat in Maui', 3500.00, 'HEALTH', 'PLANE', 'FIVE_STARS', 'REGISTERED', '2024-10-15', '2024-10-25', '019ebbf2-72c2-74e9-8451-6a8bc9d0e1f2', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8451-6a8bc9d00003', 'South Africa Safari Lodge', 'Luxury lodge safari in South Africa', 4200.00, 'SAFARI', 'JEEPS', 'FIVE_STARS', 'PAID', '2024-11-20', '2024-11-30', '019ebbf2-72c2-74e9-8451-6a8bc9d0e1f2', false);

-- Evan Manager (019ebbf2-72c2-74e9-8452-7b9cd0e1f2a3)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8452-7b9cd0e10001', 'Swiss Alps Sports Camp', 'Skiing and snowboarding camp in the Swiss Alps', 3100.00, 'SPORTS', 'TRAIN', 'FOUR_STARS', 'REGISTERED', '2024-12-05', '2024-12-12', '019ebbf2-72c2-74e9-8452-7b9cd0e1f2a3', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8452-7b9cd0e10002', 'Andalusia Wine Tasting', 'Wine tasting tour through Andalusian vineyards', 1500.00, 'WINE', 'BUS', 'THREE_STARS', 'PAID', '2025-01-10', '2025-01-17', '019ebbf2-72c2-74e9-8452-7b9cd0e1f2a3', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8452-7b9cd0e10003', 'Cairo Cultural Discovery', 'Ancient history tour through Cairo and the pyramids', 2300.00, 'CULTURAL', 'MINIBUS', 'FOUR_STARS', 'REGISTERED', '2025-02-01', '2025-02-08', '019ebbf2-72c2-74e9-8452-7b9cd0e1f2a3', true);

-- Fiona User (019ebbf2-72c2-74e9-8453-8caed1f2a3b4)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8453-8caed1f20001', 'Bahamas Leisure Cruise', 'Relaxing leisure cruise through the Bahamas islands', 2900.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'CANCELED', '2025-01-15', '2025-01-22', '019ebbf2-72c2-74e9-8453-8caed1f2a3b4', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8453-8caed1f20002', 'Borneo Eco Adventure', 'Rainforest eco adventure exploring Borneo wildlife', 2100.00, 'ECO', 'JEEPS', 'TWO_STARS', 'REGISTERED', '2025-02-10', '2025-02-20', '019ebbf2-72c2-74e9-8453-8caed1f2a3b4', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8453-8caed1f20003', 'Colorado Adventure Rafting', 'Whitewater rafting adventure in Colorado mountains', 1800.00, 'ADVENTURE', 'MINIBUS', 'THREE_STARS', 'PAID', '2025-03-01', '2025-03-08', '019ebbf2-72c2-74e9-8453-8caed1f2a3b4', true);

-- George User (019ebbf2-72c2-74e9-8454-9dbfe2a3b4c5)
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8454-9dbfe2a30001', 'Thailand Health Spa Retreat', 'Traditional health spa retreat in Thailand', 2200.00, 'HEALTH', 'PLANE', 'FOUR_STARS', 'REGISTERED', '2025-01-20', '2025-01-28', '019ebbf2-72c2-74e9-8454-9dbfe2a3b4c5', true);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8454-9dbfe2a30002', 'Namibia Desert Safari', 'Desert safari adventure across Namibian dunes', 3600.00, 'SAFARI', 'JEEPS', 'THREE_STARS', 'PAID', '2025-02-15', '2025-02-25', '019ebbf2-72c2-74e9-8454-9dbfe2a3b4c5', false);
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf3-72c2-74e9-8454-9dbfe2a30003', 'Loire Valley Wine Tour', 'Scenic wine tour through the Loire Valley chateaux', 1700.00, 'WINE', 'PRIVATE_CAR', 'FOUR_STARS', 'REGISTERED', '2025-03-10', '2025-03-17', '019ebbf2-72c2-74e9-8454-9dbfe2a3b4c5', false);

-- available vouchers
INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8445-4495f3db0001', 'Santorini Leisure Escape', 'Luxury holiday on the stunning island of Santorini', 3100.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'AVAILABLE', '2025-06-10', '2025-06-20', null, true);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8446-1b3cd4e50001', 'Nepal Adventure Trek', 'Breathtaking adventure trekking through Nepalese mountains', 2800.00, 'ADVENTURE', 'PLANE', 'THREE_STARS', 'AVAILABLE', '2025-07-05', '2025-07-18', null, false);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8447-2c4de5f6a701', 'Budapest Health Spa', 'Rejuvenating health and spa retreat in Budapest', 1400.00, 'HEALTH', 'TRAIN', 'FOUR_STARS', 'AVAILABLE', '2025-08-20', '2025-08-27', null, true);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8448-3d5ef6a7b801', 'Serengeti Safari Tour', 'Unforgettable wildlife safari across the Serengeti plains', 3700.00, 'SAFARI', 'JEEPS', 'FOUR_STARS', 'AVAILABLE', '2025-09-12', '2025-09-22', null, false);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8449-4e6fa7b8c901', 'Kyoto Cultural Journey', 'Immersive cultural experience through ancient Kyoto temples', 2600.00, 'CULTURAL', 'PLANE', 'FIVE_STARS', 'AVAILABLE', '2025-10-08', '2025-10-15', null, true);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8450-5f7ab8c90001', 'Patagonia Eco Expedition', 'Untouched wilderness eco tour through Patagonian landscapes', 4100.00, 'ECO', 'MINIBUS', 'TWO_STARS', 'AVAILABLE', '2025-11-01', '2025-11-14', null, false);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8451-6a8bc9d00001', 'Porto Wine Discovery', 'Exclusive wine discovery tour through Porto vineyards', 1600.00, 'WINE', 'PRIVATE_CAR', 'FOUR_STARS', 'AVAILABLE', '2025-05-15', '2025-05-22', null, true);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8452-7b9cd0e10001', 'Queenstown Sports Getaway', 'Bungee jumping and skydiving adventure in Queenstown', 3900.00, 'SPORTS', 'PLANE', 'FOUR_STARS', 'AVAILABLE', '2025-06-20', '2025-06-28', null, true);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8453-8caed1f20001', 'Maldives Overwater Retreat', 'Exclusive overwater bungalow retreat in the Maldives', 5500.00, 'LEISURE', 'SHIP', 'FIVE_STARS', 'AVAILABLE', '2025-07-10', '2025-07-20', null, false);

INSERT INTO vouchers(id, title, description, price, tour_type, transfer_type, hotel_type, status, arrival_date, eviction_date, user_id, is_hot)
VALUES ('019ebbf4-72c2-74e9-8454-9dbfe2a30001', 'Kilimanjaro Summit Trek', 'Epic trekking expedition to the summit of Kilimanjaro', 4800.00, 'ADVENTURE', 'JEEPS', 'THREE_STARS', 'AVAILABLE', '2025-08-05', '2025-08-18', null, true);