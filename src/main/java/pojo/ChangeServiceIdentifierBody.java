package pojo;

public class ChangeServiceIdentifierBody {

	private String newServiceIdentifier;

	public String getNewServiceIdentifier()
	{
		return newServiceIdentifier;
	}

	public void setNewServiceIdentifier(String newServiceIdentifier)
	{
		if(!newServiceIdentifier.isEmpty()) {
			this.newServiceIdentifier = newServiceIdentifier;
		}
	}

}
