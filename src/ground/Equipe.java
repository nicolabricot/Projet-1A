package ground;

public class Equipe
{
	private String name;
	
	public Equipe(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString()
	{
		return this.name;
	}
}
