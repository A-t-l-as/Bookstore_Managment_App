package shopUtils;

import java.util.Objects;

public class CPosition
{
//public:
	public CPosition(String str, String howMuchStr)
	{
		this.str = str;
		this.howMuch = Integer.parseInt(howMuchStr);
	}
	
	public CPosition(String str, int howMuch)
	{
		this.str = str;
		this.howMuch = howMuch;
	}
	
	public CPosition(CPosition other)
	{
		this.str = new String(other.str);
		this.howMuch = other.howMuch;
	}
	
	public String getStr()
	{
		return str;
	}

	public void setStr(String argStr)
	{
		this.str = argStr;
	}

	public int getHowMuch()
	{
		return howMuch;
	}

	public void setHowMuch(int argHowMuch)
	{
		this.howMuch = argHowMuch;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(howMuch, str);
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
		CPosition other = (CPosition) obj;
		return howMuch == other.howMuch && Objects.equals(str, other.str);
	}

	@Override
	public String toString()
	{
		return "CPosition [str=" + str + ", howMuch=" + howMuch + "]";
	}

	//private:
	private String str;
	private int howMuch;
	
}
