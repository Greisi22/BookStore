package Model.Converters;

import Model.Login.AccessLevel;
import javafx.util.StringConverter;

public class AccessLevelStringConverter extends StringConverter<AccessLevel> {

	@Override
	public AccessLevel fromString(String s1) {
		if(s1.equals(AccessLevel.LIBRARIAN.toString()))
		{
			return AccessLevel.LIBRARIAN;
		}
		else if(s1.equals(AccessLevel.MANAGER.toString()))
		{
			return AccessLevel.MANAGER;
		}
		else
		{
			return AccessLevel.ADMINISTRATOR;
		}
		
	}

	@Override
	public String toString(AccessLevel ob) {
		if(ob.equals(AccessLevel.LIBRARIAN))
		{
			return AccessLevel.LIBRARIAN.toString();
		}
		else if(ob.equals(AccessLevel.MANAGER))
				{
			return AccessLevel.MANAGER.toString();
				}
		else 
		{
	return AccessLevel.ADMINISTRATOR.toString();
		}
	
	}

}
