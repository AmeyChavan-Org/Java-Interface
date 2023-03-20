import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface CreditCardInterface //using interface!
{
    void viewCreditAmount() throws Exception;
    void useCard() throws Exception;
    void payCredit() throws Exception;
    void increaseLimit() throws Exception;
}


class SilverCardCustomer implements CreditCardInterface
{
    String name;
    String cardnumber;
    double creditAmount,creditLimit;


    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    SilverCardCustomer()
    {
        creditAmount=50000;
        creditLimit=50000;
    }

    public void accept() throws IOException
    {
        do
        {
            System.out.println("Enter name of customer:");
            name = br.readLine();
        }while (name.length()==0);


        while(true)
        {
            System.out.println("Enter 16-digt card number:");
            int flag=0;
            cardnumber = br.readLine();
            for(int i=0;i<cardnumber.length();i++)
            {
                if(!Character.isDigit(cardnumber.charAt(i)))
                    flag=1;
            }

            if(cardnumber.length()==16 && flag==0)
                break;
            else if(cardnumber.length()==16 && flag==1)
                System.out.println("Credit Card number has digits only!!");
            else if(cardnumber.length()!=16 && flag==1)
                System.out.println("Enter 16 digit Card Number which contains only digits");
            else
                System.out.println("invalid input....Please Enter 16 digit Card Number");

        }


    }
    public  void increaseLimit()
    {
        System.out.println("Since it is a Silver Card, can't increase the limit");
    }
    public  void viewCreditAmount()
    {
        System.out.println("\nYour Credit Amount is : "+creditAmount);
    }


    public void payCredit() throws NumberFormatException, IOException
    {
        Double payAmt;
        if(creditAmount!=creditLimit)
        {

            System.out.println("Enter the Amount  : ");
            while(true)
            {
                payAmt = Double.parseDouble(br.readLine());
                if(payAmt>0)
                {
                    if((payAmt+creditAmount)<=creditLimit)
                    {
                        creditAmount = creditAmount + payAmt;
                        System.out.println(" Successful");
                        viewCreditAmount();
                        break;
                    }
                    else
                    {
                        System.out.println("Exceeding Credited amount!!");
                        System.out.println("\n Enter Valid Paying Amount : ");
                    }

                }
                else
                {
                    System.out.println("Amount need to be positive");
                    System.out.println("Enter valid amount : ");
                }

            }
        }
        else{
            System.out.println("\nCredit card hasn't been used!!");
        }
    }
   /* {
        if(creditAmount==0)
        {
            System.out.println("\nCan not Pay credit,Your Balance is 0\n");
        }
        else
        {
            double amount;
            System.out.println("Enter amount : ");
            while(true)
            {
                amount = Double.parseDouble(br.readLine());
                if(amount>=0)
                {
                    if(amount > creditAmount)
                    {
                        System.out.println("\n Amount is more than credit Amount!!");
                        System.out.println("\n Enter Valid Credit Amount : ");

                    }
                    else
                    {
                        creditAmount = creditAmount - amount;
                        System.out.println("Paid Successfully !!!");
                        viewCreditAmount();
                        break;
                    }
                }
                else
                {
                    System.out.println("Amount cannot be less than Zero");
                    System.out.println("Enter amount : ");
                }
            }
        }
    }*/

    public void useCard()throws Exception
    {
        if(creditAmount==0)
        {
            System.out.println("\nCan not Pay ,Your Balance is 0\n");
        }
        else
        {
            double amount;
            System.out.println("Enter amount : ");
            while(true)
            {
                amount = Double.parseDouble(br.readLine());
                if(amount>0)

                {
   
                       if(amount > creditAmount)
                      {
                        System.out.println("\n Amount is more than credit limit !!");
                        System.out.println("\n Enter Valid Credit Amount : ");

                      }
                     
                    else
                    {
                        creditAmount = creditAmount - amount;
                        System.out.println("Paid Successfully !!!");
                        viewCreditAmount();
                        break;
                    }
                }
                else if(amount<0)
                {
                    System.out.println("Amount cannot be less than Zero");
                    System.out.println("Enter amount : ");
                }
                else
                { 
                     System.out.println("Transaction Aborted");
		     System.out.println("Enter amount : ");
                }
            }
        }
    }
   /* {
        Double payAmt;
        if(creditAmount!=creditLimit)
        {

            System.out.println("Enter the Amount for increasing creditAmount : ");
            while(true)
            {
                payAmt = Double.parseDouble(br.readLine());
                if(payAmt>0)
                {
                    if((payAmt+creditAmount)<=creditLimit)
                    {
                        creditAmount = creditAmount + payAmt;
                        System.out.println("Used Successful");
                        viewCreditAmount();
                        break;
                    }
                    else
                    {
                        System.out.println("Exceeding Credit Limit !!");
                        System.out.println("\n Enter Valid Paying Amount : ");
                    }

                }
                else
                {
                    System.out.println("Amount need to be positive");
                    System.out.println("Enter amount : ");
                }

            }
        }
        else{
            System.out.println("\nCredit limit has reached !!");
        }
    }*/
}

class GoldCardCustomer  extends SilverCardCustomer
{
    public int cnt;
    double amount;

    GoldCardCustomer()
    {
        creditLimit=100000;
        creditAmount=100000;
    }

    public void increaseLimit()
    {
        cnt++;
        if(cnt<4)
        {

            creditLimit = creditLimit + 5000;
            creditAmount=creditAmount+5000;
            System.out.println("Credit Limit is increased !!");
            System.out.println("Updated Credit limit is : "+creditLimit);
            System.out.println("\n");


        }
        else
            System.out.println("Can't increase limit more than 3 times !!!\n");

    }
    /*public  void viewCreditAmount()
    {
        System.out.println("\nYour Credit Amount is : "+creditAmount);
    }*/
}


class ass41
{
    public static void main(String args[]) throws Exception
    {
        int ch,cch;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do
        {
            System.out.println("1 : Silver Card ");

            System.out.println("2 : Gold card ");

            System.out.println("0 : EXIT ");


            System.out.println("Enter Card choice : ");
            cch = Integer.parseInt(br.readLine());
            switch(cch)
            {
                case 1:
                    SilverCardCustomer s = new SilverCardCustomer();
                    s.accept();

                    do
                    {
                        System.out.println("1 : Pay Due Credit");
                        System.out.println("2 : Pay using Silver Card");
                        System.out.println("3 : Increase Limit for Silver Card");
                        System.out.println("4 : View Balance");
                        System.out.println("0 : EXIT ");

                        System.out.println("Enter your choice :");
                        ch = Integer.parseInt(br.readLine());
                        switch(ch)
                        {
                            case 1:
                                s.payCredit();
                                break;

                            case 2:
                                s.useCard();
                                break;

                            case 3:
                                s.increaseLimit();
                                break;

                            case 4:
                                s.viewCreditAmount();
                                break;

                            case 0:System.out.println("Exit Silver Card ");break;
                            default:
                                System.out.println("\nInvalid Option !!\n");
                        }
                    }while(ch!=0);
                    break;
                case 2:
                    GoldCardCustomer g = new GoldCardCustomer();
                    g.accept();
                    do
                    {
                        System.out.println("1 : Pay Due Credit");
                        System.out.println("2 : Pay using Gold Card");
                        System.out.println("3 : Increase Limit for Gold");
                        System.out.println("4 : View Balance");
                        System.out.println("0 : EXIT ");

                        System.out.println("Enter your choice : ");
                        ch = Integer.parseInt(br.readLine());
                        switch(ch)
                        {
                            case 1:
                                g.payCredit();
                                break;

                            case 2:
                                g.useCard();
                                break;

                            case 3:
                                g.increaseLimit();
                                break;
                            case 4:
                                g.viewCreditAmount();
                                break;
                            case 0: System.out.println("Golden Card Menu Over");
                                break;
                            default:
                                System.out.println("\nInvalid Option !!\n");
                        }
                    }while(ch!=0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\nInvalid Option !!\n");

            }
        }while(cch!=0);
    }
}


