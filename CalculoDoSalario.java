import java.util.Scanner;

public class CalculoDoSalario {

    public static void main(String[] args) {
        double[] salarioFuncionarios = new double[5];
        Scanner sc = new Scanner(System.in);

        System.out.println("Bem vindo ao sistema de cálculo de salários, por favor...");

        //Preenche o array de salarios brutos
        for(int i=0; i<5; i++){
            System.out.println("Insira o salário bruto do funcionário " + (i+1));
            salarioFuncionarios[i] = sc.nextDouble();
        }
        System.out.println("-----------------------------------------");

        //Percorre o array e mostra na tela as informações respectivas de cada funcionário
        for(int i=0; i<5; i++){
            System.out.println(); //Esse System.out.println é somente para facilitar visualização dos blocos de informação no console
            System.out.println("--- Tabela de Salários Funcionário " + (i+1) + "---");

            //Salário Bruto
            System.out.println("Salário Bruto do Funcionário " + (i+1) + ":");
            System.out.println(salarioFuncionarios[i]);

            //Desconto INSS
            System.out.println("Desconto ao INSS do Funcionário " + (i+1) + ":");
            double descontoInss = calculaINSS(salarioFuncionarios[i]);
            System.out.println(descontoInss);

            //Desconto Imposto de Renda
            System.out.println("Desconto de Imposto de Renda do Funcionário " + (i+1) + ":");
            double descontoImposto = calculaImpostoRenda(salarioFuncionarios[i]);
            System.out.println(descontoImposto);

            //Salário líquido
            System.out.println("Salário Líquido do Funcionário " + (i+1) + ":");
            double salarioLiquido = calculaLiquido(salarioFuncionarios[i],descontoInss, descontoImposto);
            System.out.println(salarioLiquido);

        }

        System.out.println(); //Esse System.out.println é somente para facilitar visualização dos blocos de informação no console
        System.out.println("Obrigada pela utilização!");

        sc.close();
    }

    //Função para cálculo do desconto ao INSS respectivo à tabela do enunciando
    public static double calculaINSS(double salarioBruto) {
        double descontoINSS = 0;
        if (salarioBruto < 1212.00) {
            descontoINSS = ((salarioBruto * 7.5) / 100);
        } else if (1212.01 <= salarioBruto && salarioBruto < 2427.35) {
            descontoINSS = ((salarioBruto * 9) / 100);
        } else if (2427.36 <= salarioBruto && salarioBruto < 3641.03){
            descontoINSS = ((salarioBruto * 12) / 100);
        }else if(3641.04 <= salarioBruto && salarioBruto <=7087.22){
            descontoINSS = ((salarioBruto * 14) / 100);
        }else if (salarioBruto > 7087.22){
            descontoINSS = ((salarioBruto * 14) / 100);
        }
        return descontoINSS;
    }

    //Função para cálculo do desconto de Imposto de Renda respectivo à tabela do enunciando
    public static double calculaImpostoRenda(double salarioBruto) {
        double descontoImposto = 0;
        if (salarioBruto < 1903.98) {
            descontoImposto = ((salarioBruto * 0) / 100);
        } else if (1903.99 <= salarioBruto && salarioBruto < 2826.65) {
            descontoImposto = ((salarioBruto * 7.5) / 100);
        } else if (2826.66 <= salarioBruto && salarioBruto < 3751.05){
            descontoImposto = ((salarioBruto * 15) / 100);
        }else if(3751.06 <= salarioBruto && salarioBruto <=4664.68){
            descontoImposto = ((salarioBruto * 22.5) / 100);
        }else if(salarioBruto> 4664.68){
            descontoImposto = ((salarioBruto * 27.5) / 100);
        }
        return descontoImposto;
    }

    //Função para cálculo do salário líquido do usuário
    public static double calculaLiquido(double salarioBruto, double descontoINSS, double descontoImposto){
        double salarioLiquido = 0;
        salarioLiquido = salarioBruto - descontoImposto - descontoINSS;
        return salarioLiquido;
    }
}
