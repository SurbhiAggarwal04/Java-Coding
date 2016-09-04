package DesignPattern;
interface Bank
{
	void display();
}
interface Loan
{
	void display();
}

class HDFC implements Bank
{
	public void display()
	{
	System.out.println("HDFC Bank");
	}
}
class ICIC implements Bank
{
	public void display()
	{
	System.out.println("ICIC bank");
	}
}

class Personal implements Loan
{
	public void display()
	{
	System.out.println("Personal");
	}
}
class Academic implements Loan
{
	public void display()
	{
	System.out.println("Academic");
	}
}

class BankFactory extends AbstractFactory
{

	@Override
	Bank getBank(String type) {
		// TODO Auto-generated method stub
		if(type.equals("HDFC"))return new HDFC();
		else return new ICIC();
		
	}

	@Override
	Loan getLoan(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
class LoanFactory extends AbstractFactory
{

	@Override
	Bank getBank(String type) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	Loan getLoan(String type) {
		// TODO Auto-generated method stub
		if(type.equals("Personal"))return new Personal();
		else return new Academic();
		
	}
	
}
abstract class AbstractFactory
{
	abstract Bank getBank(String type);
	abstract Loan getLoan(String type);
}
class FactoryCreator
{
	public static AbstractFactory getFactory(String type)
	{
		if(type.equals("bank"))return new BankFactory();
		else return new LoanFactory();
	}
}
public class AbstractFactoryPattern {
public static void main(String[] args) {
	AbstractFactory factory=FactoryCreator.getFactory("bank");
	Bank bank=factory.getBank("HDFC");
	bank.display();
	bank=factory.getBank("ICICi");
	bank.display();
	
	factory=FactoryCreator.getFactory("loan");
	Loan loan=factory.getLoan("Personal");
	loan.display();
	loan=factory.getLoan("Academic");
	loan.display();
}
}
