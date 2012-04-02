package ground;

public class Equipe
{
	private String name;

	public Equipe(String name) {
		this.name = name;
	}

	/**
	 * Retourne le nom de l'equipe
	 */
	public String getName() {
		return this.name;
	}
	/**
	 * Permet de modifier le nom de l'equipe
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}
