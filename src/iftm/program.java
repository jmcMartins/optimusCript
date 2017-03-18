package iftm;
import java.util.Random;
import java.util.Scanner;

public class program {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("1 - Para criptografia basica.\n2 - Para descriptografia basica.\n3 - Para criptografia media.\n4 - Para descriptografia media.");
		int op = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Digite a frase: ");
		String var = teclado.nextLine().toUpperCase();
		
		String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		
		//Criptografia recebendo numero 
		if(op == 1)
		{
			System.out.println("Digite a chave: ");
			int chave = Integer.parseInt(teclado.nextLine());
			String resul = "";
			
			//E percorrido dois for um para o alfabeto e outro para string recebida vendo se contem ou não, e então armazenando o index
			//então substituido por outra letra do alfabeto soando o index+ o numero recebido.
			for (int i = 0; i < var.length(); i++) 
			{
				if(alfabeto.contains(Character.toString(var.charAt(i))))
				{
					int index = alfabeto.indexOf(Character.toString(var.charAt(i)));
					
					index = (index+chave)<26 ? index + chave : (index+chave) - 26;
					index = index % 26;
					
					resul+= alfabeto.charAt(index);
				}
				else
					resul+=var.charAt(i);
			}
			System.out.print("Criptografado: ");
			System.out.println(resul);
		}
		
		else if(op == 2)
		{
			System.out.println("Digite a chave maxima: ");
			int max = Integer.parseInt(teclado.nextLine());
			
			int index = 0;
			
			for (int i = 1; i <= max; i++) {
				String resul = "";
				
				for (int j = 0; j < var.length(); j++) 
				{
					if(alfabeto.contains(Character.toString(var.charAt(j))))//Verifica se contem no alfabeto
					{
						index = alfabeto.indexOf(Character.toString(var.charAt(j)));//Pega o index da string recebida no alfabeto
						
						index = index - i; while(index < 0) index = index + 26;//Roda um for jogando um if para q se for negativo o numero some 26
						
						resul+= alfabeto.charAt(index);//Recebe o conteudo da posição do alfabeto encontrada pelo index
					}
					else
						resul+=" ";//Se não for letra coloca espaço para organizar a escrita
				}
				System.out.println(i + "º: " + resul);
			}
			System.out.println();
		}
		
		//Criptografia avançada só deus sabe o que fiz
		else if(op == 3)
		{
			var = var.replace(" ", "");
			System.out.println("Chave de criptografia: ");
			String chave = teclado.nextLine().replace(" ", "").toUpperCase();//Retira os espaços
			
			int coluna = chave.length();
			int linha = (int) Math.ceil( ((float)var.length()/coluna) );
			char[][] matrix = new char[linha][coluna];
			int[] index = new int[coluna];
			
			//Pega os index de todas as palavras da string no alfabeto
			for (int i = 0; i < chave.length(); i++) 
				for (int j = 0; j < alfabeto.length(); j++) 				
					if(alfabeto.charAt(j) == chave.charAt(i))					
						index[i] = j;
			
			int cont = 0;
			Random rand = new Random();
			
			//Preenche a matriz com a string e com letras aleatorias para completar
			for (int i = 0; i < linha; i++) 
				for (int j = 0; j < coluna; j++) 
				{
					if(cont < var.length())
						matrix[i][j] = var.charAt(cont);
					else	
						matrix[i][j] = alfabeto.charAt(rand.nextInt(26));
					cont++;
				}
			//Aqui e onde toda a magica acontece. Seguindo a mesma logica que e escrever no papel a criptografia
			System.out.print("Criptografado: ");
			for (int k = 0; k < 26; k++) 
				for (int k2 = 0; k2 < index.length; k2++) 
					if(index[k2] == k)
						for (int i = 0; i < linha; i++) System.out.print(matrix[i][k2]);

			System.out.println();
		}
		
		else if(op == 4)
		{			
			
		}
		else
			System.out.println("Opção invalida. Tchau Brigado !!");
		
		teclado.close();
	}
}