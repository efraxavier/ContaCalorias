create database ContaCalorias;
use ContaCalorias;
 
CREATE TABLE Alimento (PessoaNome varchar(25), Dia date, AlimentoNome varchar(25), Calorias int, Carboidratos int, Proteinas int, Gordura int, foreign key(PessoaNome) references Pessoa(PessoaNome), foreign key(Dia) references Dia(Dia));
CREATE TABLE Pessoa (PessoaNome varchar(25), PessoaPeso float, Metrica varchar(3), primary key(PessoaNome));

INSERT INTO Pessoa (PessoaNome, PessoaPeso, Metrica) VALUES 
  ('Alice', 65.5, 'kg'),
  ('Bob', 150, 'lbs'),
  ('Charlie', 80.2, 'kg'),
  ('Diana', 175, 'lbs'),
  ('Eva', 68.7, 'kg');
INSERT INTO Alimento (PessoaNome, Dia, AlimentoNome, Calorias, Carboidratos, Proteinas, Gordura) VALUES 
  ('Alice', '2023-11-10', 'Arroz', 150, 30, 5, 2),
  ('Bob', '2023-11-11', 'Frango Grelhado', 200, 0, 30, 5),
  ('Charlie', '2023-11-12', 'Salada de Legumes', 100, 15, 3, 2),
  ('Diana', '2023-11-13', 'Pizza', 300, 40, 10, 15),
  ('Eva', '2023-11-14', 'Salmão Assado', 250, 0, 25, 15),
  ('Alice', '2023-11-15', 'Maçã', 50, 12, 1, 0),
  ('Bob', '2023-11-16', 'Macarrão', 180, 35, 7, 2),
  ('Charlie', '2023-11-10', 'Sanduíche de Peru', 220, 25, 20, 5),
  ('Diana', '2023-11-11', 'Torta de Frutas', 280, 30, 5, 15),
  ('Eva', '2023-11-12', 'Batata Doce Cozida', 120, 25, 2, 1),
  ('Alice', '2023-11-13', 'Hamburguer', 280, 30, 15, 10),
  ('Bob', '2023-11-14', 'Brócolis Cozidos', 60, 10, 5, 1),
  ('Charlie', '2023-11-15', 'Iogurte Grego', 120, 15, 12, 5),
  ('Diana', '2023-11-16', 'Pão Integral', 90, 18, 3, 1),
  ('Eva', '2023-11-10', 'Cenoura Crua', 30, 7, 1, 0),
  ('Alice', '2023-11-11', 'Banana', 80, 20, 1, 0),
  ('Bob', '2023-11-12', 'Omelete', 200, 3, 15, 12),
  ('Charlie', '2023-11-13', 'Abacate', 160, 2, 2, 15),
  ('Diana', '2023-11-14', 'Arroz Integral', 180, 35, 5, 2),
  ('Eva', '2023-11-15', 'Feijão Preto', 220, 40, 15, 2),
  ('Alice', '2023-11-16', 'Muffin de Mirtilo', 150, 20, 3, 6),
  ('Bob', '2023-11-10', 'Peito de Peru', 120, 2, 25, 1),
  ('Charlie', '2023-11-11', 'Laranja', 70, 18, 1, 0),
  ('Diana', '2023-11-12', 'Cereal Integral', 120, 25, 5, 1),
  ('Eva', '2023-11-13', 'Pêssego', 50, 12, 1, 0),
  ('Alice', '2023-11-14', 'Queijo Cottage', 90, 6, 12, 2),
  ('Bob', '2023-11-15', 'Sopa de Legumes', 120, 15, 5, 3),
  ('Charlie', '2023-11-16', 'Atum em Lata', 160, 0, 20, 8),
  ('Diana', '2023-11-10', 'Amêndoas', 200, 8, 10, 15),
  ('Eva', '2023-11-11', 'Abóbora Cozida', 80, 20, 1, 0);


INSERT INTO Alimento (PessoaNome, Dia, AlimentoNome, Calorias, Carboidratos, Proteinas, Gordura) VALUES 
  ('Alice', '2023-11-12', 'Cenoura Cozida', 50, 10, 2, 0),
  ('Bob', '2023-11-13', 'Salada de Frutas', 120, 30, 2, 1),
  ('Charlie', '2023-11-14', 'Sushi', 250, 30, 15, 8),
  ('Diana', '2023-11-15', 'Iogurte de Morango', 90, 15, 8, 2),
  ('Eva', '2023-11-16', 'Espinafre Cozido', 70, 10, 5, 1),
  ('Alice', '2023-11-12', 'Pão de Centeio', 110, 20, 3, 1),
  ('Bob', '2023-11-13', 'Queijo Cheddar', 120, 1, 8, 10),
  ('Charlie', '2023-11-14', 'Pera', 60, 15, 1, 0),
  ('Diana', '2023-11-15', 'Peixe Assado', 200, 0, 25, 10),
  ('Eva', '2023-11-16', 'Lentilhas Cozidas', 180, 30, 10, 1),
  ('Alice', '2023-11-12', 'Batata Frita', 220, 30, 2, 10),
  ('Bob', '2023-11-13', 'Muffin de Chocolate', 180, 25, 3, 8),
  ('Charlie', '2023-11-14', 'Queijo Camembert', 150, 1, 8, 12),
  ('Diana', '2023-11-15', 'Carne de Porco Grelhada', 280, 0, 30, 15),
  ('Eva', '2023-11-16', 'Abacaxi', 70, 18, 1, 0),
  ('Alice', '2023-11-12', 'Hummus', 100, 15, 5, 5),
  ('Bob', '2023-11-13', 'Pão de Alho', 160, 20, 5, 8),
  ('Charlie', '2023-11-14', 'Cenoura Ralada', 40, 8, 1, 0),
  ('Diana', '2023-11-15', 'Frutas Vermelhas', 80, 20, 1, 0),
  ('Eva', '2023-11-16', 'Peru Assado', 220, 0, 30, 10),
  ('Alice', '2023-11-12', 'Sopa de Tomate', 120, 15, 5, 3),
  ('Bob', '2023-11-13', 'Ovos Mexidos', 180, 2, 15, 12),
  ('Charlie', '2023-11-14', 'Kiwi', 50, 12, 1, 0),
  ('Diana', '2023-11-15', 'Macarrão de Trigo Integral', 200, 40, 7, 2),
  ('Eva', '2023-11-16', 'Queijo Gorgonzola', 120, 1, 8, 10),
  ('Alice', '2023-11-12', 'Brócolis no Vapor', 40, 8, 3, 0),
  ('Bob', '2023-11-13', 'Pão Pita Integral', 90, 18, 3, 1),
  ('Charlie', '2023-11-14', 'Uvas', 70, 18, 1, 0),
  ('Diana', '2023-11-15', 'Salmão Grelhado', 250, 0, 25, 15),
  ('Eva', '2023-11-16', 'Feijão Verde Cozido', 60, 12, 3, 0);


select * from alimento;
select * from Pessoa;
