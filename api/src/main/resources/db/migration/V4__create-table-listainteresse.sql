CREATE TABLE listainteresse (
    usuario_id INT NOT NULL,
    livro_id INT NOT NULL,

    PRIMARY KEY (usuario_id, livro_id),
    CONSTRAINT fk_interesse_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
    CONSTRAINT fk_interesse_livro_id FOREIGN KEY (livro_id) REFERENCES Livros(id)
);