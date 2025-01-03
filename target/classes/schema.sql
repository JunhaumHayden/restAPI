-- Tabela Cliente
CREATE TABLE IF NOT EXISTS cliente (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(256) NOT NULL,
    telefone VARCHAR(15),
    cep VARCHAR(9),
    complemento_endereco VARCHAR(100),
    numero_endereco VARCHAR(10),
    cpf VARCHAR(11) NOT NULL UNIQUE,
    CONSTRAINT pk_cliente PRIMARY KEY(id)
);

-- Tabela Profissional
CREATE TABLE IF NOT EXISTS profissional (
    id INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(256) NOT NULL,
    telefone VARCHAR(15),
    cep VARCHAR(9),
    numero_endereco VARCHAR(10),
    complemento_endereco VARCHAR(100),
    especialidade VARCHAR(100) NOT NULL,
    registro_profissional VARCHAR(50) UNIQUE,
    CONSTRAINT pk_profissional PRIMARY KEY (id)
);

-- Tabela Servico
CREATE TABLE IF NOT EXISTS servico (
    id INT AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    preco DECIMAL(10, 2) NOT NULL,
    duracao INT NOT NULL,
    data_disponivel DATE,
    situacao ENUM('ATIVO', 'INATIVO', 'BLOQUEADO') NOT NULL DEFAULT 'BLOQUEADO',
    profissional_id INT NOT NULL,
    CONSTRAINT pk_servico PRIMARY KEY (id),
    CONSTRAINT fk_servico_profissional FOREIGN KEY (profissional_id) REFERENCES profissional(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

-- Tabela Agendamento
CREATE TABLE IF NOT EXISTS agendamento (
    id INT AUTO_INCREMENT,
    cliente_id INT NOT NULL,
    servico_id INT NOT NULL,
    data_hora TIMESTAMP NOT NULL,
    CONSTRAINT pk_agendamento PRIMARY KEY (id),
    CONSTRAINT fk_agendamento_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
    CONSTRAINT fk_agendamento_servico FOREIGN KEY (servico_id) REFERENCES servico(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
    );