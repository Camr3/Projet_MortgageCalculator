INSERT INTO services (name) VALUES ('Mortgage');
INSERT INTO services (name) VALUES ('Insurance');
INSERT INTO services (name) VALUES ('Savings account');
INSERT INTO services (name) VALUES ('Checking account');
INSERT INTO services (name) VALUES ('Credit card');

INSERT INTO banks (name, interest_rate, fee_rate)
VALUES ('RBC', 0.05, 0.005);

INSERT INTO banks (name, interest_rate, fee_rate)
VALUES ('TD', 0.03, 0.007);

INSERT INTO banks (name, interest_rate, fee_rate)
VALUES ('Scotiabank', 0.07, 0.003);

INSERT INTO banks (name, interest_rate, fee_rate)
VALUES ('Citibank', 0.06, 0.004);

INSERT INTO banks (name, interest_rate, fee_rate)
VALUES ('Bank of America', 0.04, 0.006);

INSERT INTO bank_services (bank_id, service_id) VALUES (1, 1);  -- RBC
INSERT INTO bank_services (bank_id, service_id) VALUES (2, 1);  -- TD
INSERT INTO bank_services (bank_id, service_id) VALUES (3, 1);  -- Scotiabank
INSERT INTO bank_services (bank_id, service_id) VALUES (4, 1);  -- Citibank
INSERT INTO bank_services (bank_id, service_id) VALUES (5, 1);  -- Bank of America
-- Exemple : Si l'ID de "Insurance" est 2
INSERT INTO bank_services (bank_id, service_id) VALUES (1, 2);  -- RBC
INSERT INTO bank_services (bank_id, service_id) VALUES (2, 2);  -- TD
INSERT INTO bank_services (bank_id, service_id) VALUES (3, 2);  -- Scotiabank
INSERT INTO bank_services (bank_id, service_id) VALUES (4, 2);  -- Citibank
INSERT INTO bank_services (bank_id, service_id) VALUES (5, 2);  -- Bank of America
-- Exemple : Si l'ID de "Savings account" est 3
INSERT INTO bank_services (bank_id, service_id) VALUES (1, 3);  -- RBC
INSERT INTO bank_services (bank_id, service_id) VALUES (2, 3);  -- TD
-- Exemple : Si l'ID de "Checking account" est 4
INSERT INTO bank_services (bank_id, service_id) VALUES (2, 4);  -- TD
INSERT INTO bank_services (bank_id, service_id) VALUES (3, 4);
-- Exemple : Si l'ID de "Credit card" est 5
INSERT INTO bank_services (bank_id, service_id) VALUES (4, 5);  -- Citibank
INSERT INTO bank_services (bank_id, service_id) VALUES (5, 5);  -- Bank of America