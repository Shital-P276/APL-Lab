class InsuffiecientException extends RuntimeException
{
    int TotValue;

    InsuffiecientException(int Total)
    {
        this.TotValue=Total;
    }

    public String toString()
    {
        return "Insuffiecient";

    }
}

class BankAccount
{
    int balance=10000;
    int toamount;//=9000000;

    int CheckAmount(int Amount)
    {
        this.toamount=Amount;
        return Amount;
    }

    void deposit(int amount)
    {
        this.balance=balance+amount;
    }

    void withdraw(int amount) throws InsuffiecientException
    {
        if(amount>balance)
        {
            throw new InsuffiecientException(balance);
        }
        this.balance=balance-amount;
    }

    int Check()
    {
        return balance;
    }

    public static void main(String []args)
    {
        BankAccount var=new BankAccount();
        
        try
        {
            var.deposit(10000);
            var.withdraw(5000);
        }
        catch(InsuffiecientException e)
        {
            System.out.println(e);
        }
        System.out.println("Withdrawn Successfully. "+var.Check());
    }

}