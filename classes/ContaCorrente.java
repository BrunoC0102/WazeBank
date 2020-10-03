package classes;

public class ContaCorrente {

    private int num_conta;
    private double saldo;
    private double limite_especial;
    private String nome_cliente;


    public int getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(int num_conta) {
        this.num_conta = num_conta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimite_especial() {
        return limite_especial;
    }

    public void setLimite_especial(double limite_especial) {
        this.limite_especial = limite_especial;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    @Override
    public String toString() {
        return "Cliente \n[{ \n\tcodigo = " + num_conta + ", \n\tnome = " + nome_cliente + ", \n\tsaldo = R$" + saldo + ", \n\tLimite do Especial = R$"+ limite_especial +"\n}]";
    }
}
