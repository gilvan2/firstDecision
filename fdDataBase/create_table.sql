\c postgres;

CREATE TABLE IF NOT EXISTS first_decision_cadastros_clientes (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL CHECK (LENGTH(nome) >= 3 AND LENGTH(nome) <= 50),
    email VARCHAR(100) NOT NULL CHECK (email ~* '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$'),
    senha VARCHAR(20) NOT NULL CHECK (LENGTH(senha) >= 6 AND LENGTH(senha) <= 20)
);