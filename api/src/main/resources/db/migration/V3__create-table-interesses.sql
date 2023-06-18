CREATE TABLE interesses (
  id bigint PRIMARY KEY AUTO_INCREMENT,
  usuario_id INT NOT NULL,
  livro_id INT NOT NULL,

  CONSTRAINT fk_interesses_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(id),
  CONSTRAINT fk_interesses_livro_id FOREIGN KEY (livro_id) REFERENCES Livros(id)
);