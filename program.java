package iftm;

import java.util.Scanner;

public class program {

	public static void main(String[] args) 
	{
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("1 para criptografar\n2 para descriptografar");
		int op = Integer.parseInt(teclado.nextLine());
		
		System.out.println("Digite a frase: ");
		String var = teclado.nextLine().toLowerCase().replace(" ", "");
		
		String alfabeto = "abcdefghijklmnopqrstuvwxyz";
		
		
		if(op == 1)
		{
			System.out.println("Digite a chave: ");
			int chave = Integer.parseInt(teclado.nextLine());
			String resul = "";
			
			for (int i = 0; i < var.length(); i++) 
			{
				if(alfabeto.contains(Character.toString(var.charAt(i))))
				{
					int index = alfabeto.indexOf(Character.toString(var.charAt(i)));
					
					index = (index+chave)<26 ? index + chave : (index+chave) - 26;
					
					resul+= alfabeto.charAt(index);
				}
				else
					resul+=var.charAt(i);
			}
			System.out.println(resul);
			System.out.println();
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
					if(alfabeto.contains(Character.toString(var.charAt(j))))
					{
						index = alfabeto.indexOf(Character.toString(var.charAt(j)));
						
						index = (index-i)>=0 ? index - i : (index-i) + 26;
						
						resul+= alfabeto.charAt(index);
					}
					else
						resul+=var.charAt(i);
				}
				System.out.println(i + "º: " + resul);
			}
			
			System.out.println();
		}
		
		teclado.close();
	}
}
