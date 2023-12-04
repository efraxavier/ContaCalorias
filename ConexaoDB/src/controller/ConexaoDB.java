package controller;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class ConexaoDB {

	@SuppressWarnings("resource")
	public void RegistraUsuario() {

		         Scanner myObj1 = new Scanner(System.in);
				 System.out.println("\nInsira o nome do usuário:");
				 String userName = myObj1.nextLine();  // Read user input
		
			     Scanner myObj2 = new Scanner(System.in);
				 System.out.println("Insira sistema métrico de peso (lbs/kg):");
				 String metricSys = myObj2.nextLine();  // Read user input

			     Scanner myObj3 = new Scanner(System.in);
				 System.out.println("Quantos "+metricSys+" o usuário "+userName+" pesa?");
				 int weight = myObj3.nextInt();  // Read user input

					

		String sqlQuery = "Insert into Pessoa values('"+userName+"',"+weight+",'"+metricSys+"');";

		String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";

		try  {

			Connection conn = DriverManager.getConnection(connectionUrl, "root", "");

	        PreparedStatement ps = conn.prepareStatement(sqlQuery);
 
	        int rs = ps.executeUpdate();

	        System.out.println(rs+ " novo usuário inserido com sucesso.\n");

		} catch (SQLException e) {

			System.err.println(e);

		} 

	}

	
	
	@SuppressWarnings("resource")
	public void ConsultaCalorias() {
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("Insira o dia:");
		String date = myObj1.nextLine();  // Read user input
		Scanner myObj2 = new Scanner(System.in);
		System.out.println("Insira o nome da pessoa:");
		String userName = myObj2.nextLine();  // Read user input
		System.out.println("");
		String sqlQuery = "SELECT * FROM alimento WHERE Dia = '"+date+"' and PessoaNome= '"+userName+"';";

		String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";
		try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "");

		        PreparedStatement ps = conn.prepareStatement(sqlQuery);

		        ResultSet rs = ps.executeQuery()) {
		    	int auxCal = 0;
		    	int auxProt = 0;
		    	int auxCarb = 0;
		    	int auxFat = 0;
			    
			    System.out.println("\n\t   CALORIAS DIA "+date+" PARA "+userName);
		        while (rs.next()) {
		            int cal = rs.getInt("Calorias");
		            int prot = rs.getInt("Proteinas");
		            int carb = rs.getInt("Carboidratos");
		            int fat = rs.getInt("Gordura");

		            auxCal = auxCal + cal;
		            auxProt = auxProt + prot;
		            auxCarb = auxCarb + carb;
		            auxFat = auxFat + fat;

		        	

		            String name = rs.getString("AlimentoNome");

		            System.out.println("\n\tNome: "+ name +"\n\tCalorias: "+ cal + "kcal Carboidrato: " + carb + "g Proteinas: " + prot + "g Gordura: " + fat + "g");

		        }
		        System.out.println("\n\tCalorias no dia: "+auxCal+"kcal Carboidrato: " + auxCarb + "g Proteinas: " + auxProt + "g Gordura: " + auxFat + "g\n");

		} catch (SQLException e) {

			System.err.println(e);

		}

	}

	@SuppressWarnings("resource")
	public void InsereAlimento() {

		         Scanner myObj1 = new Scanner(System.in);
				 System.out.println("\nInsira quem consumiu o alimento:");
				 String userName = myObj1.nextLine();  // Read user input
		
			     Scanner myObj2 = new Scanner(System.in);
				 System.out.println("Insira o nome do Alimento");
				 String foodName = myObj2.nextLine();  // Read user input

			     Scanner myObj3 = new Scanner(System.in);
				 System.out.println("Quantas calorias o alimento possui?");
				 int calories = myObj3.nextInt();  // Read user input
					
				
			     Scanner myObj4 = new Scanner(System.in);
				 System.out.println("Quantos gramas de carboidratos o alimento possui?");
				 int carbs = myObj4.nextInt();  // Read user input
					
			     Scanner myObj5 = new Scanner(System.in);
				 System.out.println("Quantos gramas de proteinas o alimento possui?");
				 int protein = myObj5.nextInt();  // Read user input
					
				
			     Scanner myObj6 = new Scanner(System.in);
				 System.out.println("Quantos gramas de gordura o alimento possui?");
				 int fat = myObj6.nextInt();  // Read user input
				 
				 Scanner myObj7 = new Scanner(System.in);
				 System.out.println("Insira a data de hoje");
				 String date = myObj7.nextLine(); // Read user input
					
				

		String sqlQuery = "Insert into Alimento values('"+userName+"','"+date+"','"+foodName+"',"+calories+","+carbs+","+protein+","+fat+");";

		String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";

		try  {

			Connection conn = DriverManager.getConnection(connectionUrl, "root", "");

	        PreparedStatement ps = conn.prepareStatement(sqlQuery);
 
	        int rs = ps.executeUpdate();

	        System.out.println(rs+ " novo alimento inserido com sucesso.\n");

		} catch (SQLException e) {

			System.err.println(e);

		} 

	}

	@SuppressWarnings("resource")
	public void AlteraMetrica() {
		
		Scanner myObj2 = new Scanner(System.in);
		System.out.println("Insira o nome da pessoa que iremos alterar o sistema métrico:");
		String userName = myObj2.nextLine();  // Read user input
		System.out.println("");
		
		String sqlQuery = "SELECT * FROM Pessoa WHERE PessoaNome= '"+userName+"';";

		String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";
		try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
				
		        PreparedStatement ps = conn.prepareStatement(sqlQuery);

		        ResultSet rs = ps.executeQuery()) {
				rs.next();
			    double weight = rs.getFloat("PessoaPeso");
		        String metSys = rs.getString("Metrica");
		        
		       		        
		        String newMetSys;
		        Double newWeight = weight;

		        if(metSys.equals("lbs")) {
		        	newMetSys="kg";
		        	newWeight = newWeight * 0.4536;
		        } else {
		        	newMetSys="lbs";
		        	newWeight = newWeight / 0.4536;

		        }
		        

		        String sqlQuery1 = "UPDATE Pessoa SET Metrica = '"+newMetSys+"',PessoaPeso = "+newWeight+" WHERE PessoaNome= '"+userName+"';";
				String connectionUrl1 = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";

				Connection conn1 = DriverManager.getConnection(connectionUrl1, "root", "");

		        PreparedStatement ps1 = conn1.prepareStatement(sqlQuery1);
	 
		        int rs1 = ps1.executeUpdate();
		        DecimalFormat df = new DecimalFormat("0.##");
		        String dx = df.format(newWeight);
		        System.out.println(rs1+" item alterado: "+userName+" pesa "+dx+""+newMetSys+"\n");
			    
		      
		
		} catch (SQLException e) {

			System.err.println(e);

		} 

	}

	@SuppressWarnings("resource")
	public void ExcluiAlimento() {

		 Scanner myObj1 = new Scanner(System.in);
		 System.out.println("\nInsira o nome do usuário:");
		 String userName = myObj1.nextLine();  // Read user input
		 
		 Scanner myObj2 = new Scanner(System.in);
		 System.out.println("\nInsira o dia do registro a ser excluído para o usuário "+userName+":");
		 String date = myObj2.nextLine();  // Read user input
		 
		 Scanner myObj3 = new Scanner(System.in);
		 System.out.println("\nInsira o nome do alimento:");
		 String foodName = myObj3.nextLine();  // Read user input

		String sqlQuery = "DELETE FROM Alimento WHERE PessoaNome = '"+userName+"' AND Dia = '"+date+"' AND AlimentoNome = '"+foodName+"';";

		String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";

		try  {

			Connection conn = DriverManager.getConnection(connectionUrl, "root", "");

	        PreparedStatement ps = conn.prepareStatement(sqlQuery);
 
	        int rs = ps.executeUpdate();

	        System.out.println(rs+" item excluídos.\n");

		} catch (SQLException e) {

			System.err.println(e);

		} 

	}
	
	
	
	@SuppressWarnings("resource")
	public void ImprimeRelatorio() {
		
		Scanner myObj1 = new Scanner(System.in);
		System.out.println("Insira o nome da pessoa:");
		String userName = myObj1.nextLine();  // Read user input
		System.out.println("");
		
		String sqlQuery = "SELECT DISTINCT Dia,PessoaPeso,Metrica FROM alimento a inner join pessoa p on a.PessoaNome = p.PessoaNome WHERE a.PessoaNome= '"+userName+"';";
		

		String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";
		try {
			
				Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
		        PreparedStatement ps = conn.prepareStatement(sqlQuery, ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		        ResultSet rs = ps.executeQuery();	    
		        
		        if(rs.absolute(1)) {
			        String weight = rs.getString("PessoaPeso");
			        String metSys = rs.getString("Metrica");
			        System.out.println("=======================================================================================");
			        System.out.println("\t\t\tRelatório do Usuário");
			        System.out.println("=======================================================================================");
			        System.out.println("\t\tNome: "+userName+" \t\t Peso: "+weight+""+metSys+"\t\t");
			        System.out.println("=======================================================================================");

		        }
		        rs.beforeFirst();
		        while (rs.next()) {
		            String date = rs.getString("Dia");
		            BuscaDatas(date,userName);
		        }
			    
		} catch (SQLException e) {

			System.err.println(e);

		}
		}
	
		public void BuscaDatas(String date,String name) {
			String connectionUrl = "jdbc:mysql://localhost:3306/ContaCalorias?user=root";
			java.sql.CallableStatement cstmt = null;
			try {
			   Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
			   String SQL = "{call conta_calorias('"+date+"','"+name+"')}";
			   cstmt = conn.prepareCall (SQL);
			   ResultSet rs1 = cstmt.executeQuery();
		        System.out.println("\t\t\tCALORIAS DIA "+date);
	
			        while (rs1.next()) {
			            int cal = rs1.getInt("calT");
			            int prot = rs1.getInt("protT");
			            int carb = rs1.getInt("carbT");
			            int fat = rs1.getInt("fatT");

			        	
			            String nameAlim = rs1.getString("alimNomeT");
			            if(nameAlim.contains("TOTAL")) {
			            	System.out.println("\n\t"+ nameAlim +" consumidos dia "+date+"\n\tCalorias: "+ cal + "kcal Carboidrato: " + carb + "g Proteinas: " + prot + "g Gordura: " + fat + "g\n");	
					        System.out.println("=======================================================================================\n");

			            }else {
				            System.out.println("\n\tNome do alimento: "+ nameAlim +"\n\tCalorias: "+ cal + "kcal Carboidrato: " + carb + "g Proteinas: " + prot + "g Gordura: " + fat + "g");		
			            }
		        }
                   
			   
		        
			}
			catch (SQLException e) {
				System.err.println(e);
			}

	}
	


}