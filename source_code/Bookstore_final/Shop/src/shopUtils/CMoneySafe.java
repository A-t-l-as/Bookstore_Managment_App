package shopUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import exceptions.MoneySafeException;

public class CMoneySafe
{
//public:
	public CMoneySafe(long argValue)
	{
		this.money = argValue;
	}
	
	public CMoneySafe()
	{
		this(0);
	}
	
	public CMoneySafe(CMoneySafe other)
	{
		this.money = other.money;
	}
	
	public CMoneySafe(Path argFilePath) throws IOException
	{
		this.money = 0;
		this.loadStatusFromFile(argFilePath);
	}
	
	public void loadStatusFromFile(Path argFilePath) throws IOException
	{
		BufferedReader fin = new BufferedReader( new FileReader( argFilePath.toString() ) );

		String line = new String();

		while((line = fin.readLine()) != null)
		{	
			this.money = Long.parseLong(line);
		}

		fin.close();
	}
	
	public void saveStatusToFile(Path argCsvFilePath) throws IOException
	{
		BufferedWriter fout = new BufferedWriter( new FileWriter( argCsvFilePath.toString() ) );
		
		fout.write
		(
			String.valueOf(this.money)
		);
		
		fout.close();
	}
	
	@Override
	public String toString()
	{
		return "Money: " + this.money + " PLN";
	}
	
	@Override
	public int hashCode() 
	{
		return Objects.hash(money);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CMoneySafe other = (CMoneySafe) obj;
		return money == other.money;
	}
	
	public long getStatusOfMoney()
	{	
		return this.money;
	}
	
	
	public void depositMoney(long value) throws MoneySafeException
	{	
		if(value < 0)
			throw new MoneySafeException(
					"You are trying to deposit a negative amount.");
		
		this.money += value;
	}
	
	public long withdrawMoney(long value) throws MoneySafeException
	{
		if(value > this.money)
			throw new MoneySafeException(
					"You are trying to withdraw more money than is in the safe.");
		
		this.money -= value;
		
		return value;
	}
	

//private:
	private long money;
	
}
