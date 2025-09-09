CREATE TABLE IF NOT EXISTS Livros (
    id bigint not null auto_increment,
    titulo VARCHAR(255) NOT NULL,
    preco DOUBLE PRECISION NOT NULL,
    disponivel BOOLEAN NOT NULL,
    ano_lancamento VARCHAR(50) NOT NULL,
    genero VARCHAR(50) NOT NULL,
    autor VARCHAR(50) NOT NULL,
    primary Key(id)
    );