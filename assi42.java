import java.io.*;

class Vehicle
{
    //static int r = 0;
    int n;
    String Company;
    float price;
    //int n;

    Vehicle(String Company,float price)
    {
        this.Company=Company;
        this.price=price;
        //r=r+1;
        //n=r;
    }
    public void display()
    {


        //System.out.print("\t"+n);
        System.out.print("\t"+Company);
        System.out.print("\t"+price);
    }

}
class LightMotorVehicle extends Vehicle
{
    float mileage;
    static int r = 0;
    int n;

    LightMotorVehicle(String Company,float price,float mileage)
    {
        super(Company,price);
        this.mileage=mileage;
        r=r+1;
        n=r;
    }

    public void display()
    {
        System.out.print(""+n);
        super.display();
        System.out.println("\t"+mileage);

    }

}

class HeavyMotorVehicle extends Vehicle
{
    float capacity_in_tons;
    static int r = 0;
    int n;

    HeavyMotorVehicle(String Company,float price,float capacity_in_tons)
    {
        super(Company,price);
        this.capacity_in_tons=capacity_in_tons;
        r=r+1;
        n=r;
    }

    public void display()
    {
        //System.out.println("\t"+n);
        System.out.print(""+n);
        super.display();
        System.out.println("\t"+capacity_in_tons);

    }

}

class assi42
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n,ch;
        String Company;
        float mileage,capacity_in_tons,price;
        Vehicle v[]=null;
        do{
            System.out.println("Choose your option:");
            System.out.println("\n1: LightMotorVehicle");
            System.out.println("2: HeavyMotorVehicle");
            System.out.println("3: Exit\n");
            System.out.println("Enter your choice : ");
            ch = Integer.parseInt(br.readLine());
            switch(ch)
            {
                case 1:
                    while(true)
                    {
                        System.out.println("Enter how many Vehicles : ");
                        n = Integer.parseInt(br.readLine());
                        if(n>0)
                            break;
                    }
                    v= new LightMotorVehicle[n];
                    for(int i=0;i<n;i++)
                    {
                        while(true)
                        {
                            System.out.println("Enter Company Name : ");
                            Company = br.readLine();
                            if(Company.length()==0)
                            {
                                System.out.println("Company Name Cannot be Empty");
                            }
                            else
                            {
                                break;
                            }
                        }

                        System.out.println("Enter price : ");

                        while(true)
                        {
                            price = Float.parseFloat(br.readLine());
                            if(price > 0)
                                break;
                            else if(price < 0)
                                System.out.println("Price must be positive !!");

                            System.out.println(" Enter price : ");


                        }
                        System.out.println(" Enter Milage : ");
                        while(true)
                        {
                            mileage = Float.parseFloat(br.readLine());
                            if(mileage > 0)
                                break;
                            else
                                System.out.println("Mileage must be positive!!");
                            System.out.println(" Enter Milage : ");
                        }
                        v[i]=new LightMotorVehicle(Company,price,mileage);
                    }
                    System.out.println("<---------------All vehicle are as follows : ---------------->");
                    System.out.println("\n"+"\tCompany\tPrice\tMileage");
                    for(int i=0;i<n;i++)
                        v[i].display();
                    break;

                case 2:
                    while(true)
                    {
                        System.out.println("Enter how many Vehicles : ");
                        n = Integer.parseInt(br.readLine());
                        if(n>0)
                            break;
                    }
                    v= new HeavyMotorVehicle[n];
                    for(int i=0;i<n;i++)
                    {
                        while(true)
                        {
                            System.out.println("Enter Company Name : ");
                            Company = br.readLine();
                            if(Company.length()==0)
                            {
                                System.out.println("Company Name Cannot be Empty");
                            }
                            else
                            {
                                break;
                            }
                        }
                        System.out.println("Enter price : ");

                        while(true)
                        {
                            price = Float.parseFloat(br.readLine());
                            if(price > 0)
                                break;
                            else
                                System.out.println("Price must be positive!!");
                            System.out.println("Enter price : ");
                        }
                        System.out.println("Enter capacity_in_tons : ");

                        while(true)
                        {
                            capacity_in_tons = Float.parseFloat(br.readLine());
                            if(capacity_in_tons > 0)
                                break;
                            else
                                System.out.println("Capacity_in_tons must be Greater than Zero!!");
                            System.out.println("Enter capacity_in_tons : ");
                        }
                        v[i]=new HeavyMotorVehicle(Company,price,capacity_in_tons);
                    }
                    System.out.println("<------------------------------All Heavy weight vehicles are as follows : ------------------------------->");
                    System.out.println("\n"+"\tCompany\tPrice\tCapacity in Tons");
                    for(int i=0;i<n;i++)
                        v[i].display();
                    break;

                case 3:
                    System.out.println("Exiting application");
                    break;

                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(ch!=3);

    }
}

