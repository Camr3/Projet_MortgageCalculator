CREATE TABLE services (
                          service_id INT AUTO_INCREMENT PRIMARY KEY,
                          name VARCHAR(255) NOT NULL
);
CREATE TABLE banks (
                       bank_id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       interest_rate DECIMAL(5, 4),
                       fee_rate DECIMAL(5, 4)
);
CREATE TABLE bank_services (
                               bank_id INT,
                               service_id INT,
                               PRIMARY KEY (bank_id, service_id),
                               FOREIGN KEY (bank_id) REFERENCES banks(bank_id),
                               FOREIGN KEY (service_id) REFERENCES services(service_id)
);