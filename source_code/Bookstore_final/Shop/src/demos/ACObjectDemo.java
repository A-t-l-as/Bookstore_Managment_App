package demos;

public abstract class ACObjectDemo
{
//public:
	public ACObjectDemo(Object argObj)
	{
		this.obj = argObj;
		System.out.println(this.getClass().getSimpleName() + ":");
		System.out.println("---------------------------------------");
	}
	
	public void printConstructor(String objName, String insideValue)
	{
		String objTypeName = this.obj.getClass().getSimpleName();
		System.out.println(
							objTypeName + " " + objName + " := new " +
							objTypeName + "(" + insideValue + ");"
		        		  );
	}
	
//private:
	private Object obj;
}
