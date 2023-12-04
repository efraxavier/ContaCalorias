DROP PROCEDURE  IF EXISTS conta_calorias;
DELIMITER $$

CREATE PROCEDURE conta_calorias(IN DiaP varchar(25), IN PessoaNomeP VARCHAR(25))
BEGIN

DECLARE alimNomeP varchar(25) default "";

DECLARE auxCal int default 0;
DECLARE auxProt int default 0;
DECLARE auxCarb int default 0;
DECLARE auxFat int default 0;

DECLARE cal int default 0;
DECLARE prot int default 0;
DECLARE carb int default 0;
DECLARE fat int default 0;

DECLARE fimLoop int default 0;

DECLARE alimNomeCu CURSOR FOR SELECT AlimentoNome FROM alimento where Dia = DiaP and PessoaNome = PessoaNomeP;
DECLARE calCu CURSOR FOR SELECT Calorias FROM alimento where Dia = DiaP and PessoaNome = PessoaNomeP;
DECLARE protCu CURSOR FOR SELECT Proteinas FROM alimento where Dia = DiaP and PessoaNome = PessoaNomeP;
DECLARE carbCu CURSOR FOR SELECT Carboidratos FROM alimento where Dia = DiaP and PessoaNome = PessoaNomeP;
DECLARE fatCu CURSOR FOR SELECT Gordura FROM alimento where Dia = DiaP and PessoaNome = PessoaNomeP;

DECLARE CONTINUE HANDLER FOR NOT FOUND SET fimLoop = 1;

DROP TABLE IF EXISTS mytemptable;
CREATE TEMPORARY TABLE IF NOT EXISTS mytemptable(id int auto_increment, alimNomeT varchar(25),calT int, carbT int, protT int, fatT int, primary key(id));

OPEN alimNomeCu;
OPEN calCu;
OPEN protCu;
OPEN carbCu;
OPEN fatCu;

	while(fimLoop != 1) DO
    
		fetch alimNomeCu into alimNomeP;
		fetch calCu into cal;
		fetch carbCu into carb;
		fetch protCu into prot;
		fetch fatCu into fat;
        
		INSERT INTO mytemptable VALUES (0,alimNomeP,cal,carb,prot,fat);
        
       
        
    end while;
	DELETE FROM mytemptable order by id desc limit 1;

     set auxCal  = (SELECT SUM(calT) FROM mytemptable);
	 set auxCarb = (SELECT SUM(carbT) FROM mytemptable);
	 set auxProt = (SELECT SUM(protT) FROM mytemptable);
	 set auxFat  = (SELECT SUM(fatT) FROM mytemptable);
     
	INSERT INTO mytemptable VALUES (0,'TOTAL',auxCal,auxCarb,auxProt,auxFat);
    SELECT * FROM mytemptable;
CLOSE alimNomeCu;
CLOSE calCu;
CLOSE protCu;
CLOSE carbCu;
CLOSE fatCu;
END $$
DELIMITER ;

call conta_calorias('2023-11-13','Bob');