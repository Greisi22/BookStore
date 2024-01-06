package Administator;

import Librarian.Zh_accessLevel;
import javafx.util.StringConverter;

public class Zh_accessLevelStringConverter extends StringConverter<Zh_accessLevel> {

	@Override
	public Zh_accessLevel fromString(String s1) {
		if(s1.equals(Zh_accessLevel.LIBRARIAN.toString()))
		{
			return Zh_accessLevel.LIBRARIAN;
		}
		else if(s1.equals(Zh_accessLevel.MANAGER.toString()))
		{
			return Zh_accessLevel.MANAGER;
		}
		else
		{
			return Zh_accessLevel.ADMINISTRATOR;
		}
		
	}

	@Override
	public String toString(Zh_accessLevel ob) {
		if(ob.equals(Zh_accessLevel.LIBRARIAN))
		{
			return Zh_accessLevel.LIBRARIAN.toString();
		}
		else if(ob.equals(Zh_accessLevel.MANAGER))
				{
			return Zh_accessLevel.MANAGER.toString();
				}
		else 
		{
	return Zh_accessLevel.ADMINISTRATOR.toString();
		}
	
	}

}
