import java.util.ArrayList;
import java.util.Scanner;

import classes.ContaCorrente;

public class TesteContaCorrente {
    
    public static void main(String[] args) {

        int op;
        int i=0;

        Scanner sc = new Scanner(System.in);
        
        ArrayList<ContaCorrente> contas = new ArrayList<ContaCorrente>();

        do{

            System.out.print("[1] Cadastrar uma nova Conta corrente\n[2] Depositar\n[3] Saque\n[4] Verificar Saldo\n[5] Somatório\n[6] Sair\n Opção: ");
            op = sc.nextInt();

            switch(op){
                case 1:                   
                    ContaCorrente conta = new ContaCorrente();
                    conta.setNum_conta(i+=1);
                    
                    System.out.print("\nDigite seu nome: ");
                    conta.setNome_cliente(sc.next());

                    conta.setLimite_especial(1000);

                    contas.add(conta);

                    System.out.println(conta);

                break;

                case 2:
                    int num;
                    boolean n_existe = true;
                    
                    System.out.print("\n\nInforme o número da conta: ");
                    num = sc.nextInt();
                    for (ContaCorrente contaCorrente : contas) {
                        if(contaCorrente.getNum_conta() == num){
                            double dep = 0.0;
                            System.out.print("\n\nInforme o quanto você deseja depositar: ");
                            dep = sc.nextDouble();
                            while(dep <= 0){
                                System.out.print("\nInforme um valor maior que 0: ");
                                dep = sc.nextDouble();
                            }
                            contaCorrente.setSaldo(contaCorrente.getSaldo() + dep);
                            System.out.println(contaCorrente);
                            n_existe = false;
                        }
                    }
                    if(n_existe){
                        System.err.println("\n\nConta não existe\n\n");
                    }
                break;

                case 3:
                    n_existe = true;
                    
                    System.out.print("\n\nInforme o número da conta: ");
                    num = sc.nextInt();
                    for (ContaCorrente contaCorrente : contas) {
                        if(contaCorrente.getNum_conta() == num){
                            double sac = 0.0;
                            System.out.print("\n\nInforme o quanto você deseja sacar: ");
                            sac = sc.nextDouble();
                            while(sac <= 0){
                                System.out.print("\nInforme um valor maior que 0: ");
                                sac = sc.nextDouble();
                            }
                            if(sac <= contaCorrente.getSaldo() && contaCorrente.getSaldo() - sac >= 0){
                                contaCorrente.setSaldo(contaCorrente.getSaldo() - sac);
                            }else if(sac <= (contaCorrente.getSaldo()+contaCorrente.getLimite_especial())){
                                double saldo = contaCorrente.getSaldo() - sac, exp_necessario;
                                exp_necessario = contaCorrente.getLimite_especial() + saldo;
                                if(exp_necessario >= 0 && exp_necessario <= contaCorrente.getLimite_especial()){
                                    contaCorrente.setSaldo(0);
                                    contaCorrente.setLimite_especial(exp_necessario);
                                }
                            }else {
                                System.out.println("Saldo indisponível!");
                            }
                            System.out.println(contaCorrente);
                            n_existe = false;
                        }
                    }
                    if(n_existe){
                        System.err.println("\n\nConta não existe\n\n");
                    }
                break;

                case 4:
                    n_existe = true;
                        
                    System.out.print("\n\nInforme o número da conta: ");
                    num = sc.nextInt();
                    for (ContaCorrente contaCorrente : contas) {
                        if(contaCorrente.getNum_conta() == num){

                            System.out.println("\n\nConta Corrente - Proprietário: "+contaCorrente.getNome_cliente()+"\n");
                            System.out.println("Saldo: R$ "+contaCorrente.getSaldo()+"\n\n");
                            n_existe = false;
                        }
                    }
                    if(n_existe){
                        System.err.println("\n\nConta não existe\n\n");
                    }
                break;

                case 5:
                    double total_de_saldo = 0;
                    for (ContaCorrente contaCorrente : contas) {
                        if(contaCorrente.getLimite_especial() == 1000.0){
                            total_de_saldo += contaCorrente.getSaldo();
                        }
                    }
                    System.out.println("\n\nSomatório do saldos de pessoas que não utilizaram o especial: R$"+total_de_saldo+"\n\n");
                break;
            }
        }while(op != 6);
        sc.close();
    }
}
