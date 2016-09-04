package DesignPattern;

import java.util.ArrayList;
import java.util.List;

interface PeopleAtASU {
	
	Type peopleType();

	String specific();
	String name();

}

interface Type {
	String name();
}

class International implements Type {
	String name = "international";

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Domestic implements Type {
	String name = "domestic";

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

}

abstract class InternationalPeople implements PeopleAtASU {
	public Type peopleType() {
		return new International();
	}
}

abstract class DomesticPeople implements PeopleAtASU {
	public Type peopleType() {
		return new Domestic();
	}
}

class InternationalStudent extends InternationalPeople {
	String name;

	 public InternationalStudent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String specific() {
		// TODO Auto-generated method stub
		return "InternationalStudent";
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

}

class InternationalProfessor extends InternationalPeople {
	String name;

	 public InternationalProfessor(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}

	@Override
	public String specific() {
		// TODO Auto-generated method stub
		return "InternationalProfessor";
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

}

class DomesticStudent extends DomesticPeople {
	String name;

	 public DomesticStudent(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public String specific() {
		// TODO Auto-generated method stub
		return "DomesticStudent";
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

}

class DomesticProfessor extends DomesticPeople {
	String name;

	 public DomesticProfessor(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	@Override
	public String specific() {
		// TODO Auto-generated method stub
		return "DomesticProfessor";
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return name;
	}

}
class PeopleBuilder
{
	public ASU prepareInternationalPeople()
	{
		ASU asu=new ASU();
		asu.addPeople(new InternationalStudent("surbhi"));
		asu.addPeople(new InternationalProfessor("Ayan"));
		return asu;
	}
	
	public ASU prepareDomesticPeople()
	{
		
			ASU asu=new ASU();
			asu.addPeople(new DomesticProfessor("Paulo"));
			asu.addPeople(new DomesticStudent("Vienna"));
			return asu;
	}
}
class ASU {
	private List<PeopleAtASU> peopleAtASU = new ArrayList<>();

	public void addPeople(PeopleAtASU people) {
		peopleAtASU.add(people);

	}

	public void showPeople() {
		for (PeopleAtASU people : peopleAtASU) {
			System.out.println("type " + people.peopleType().name());
			System.out.println("specifics " + people.specific());
			System.out.println("name "+people.name());
		}
	}
}

public class BuilderPattern {
	public static void main(String[] args) {
    PeopleBuilder builder=new PeopleBuilder();
    ASU international=builder.prepareInternationalPeople();
    international.showPeople();
    
    ASU domestic=builder.prepareDomesticPeople();
    domestic.showPeople();
	}
}
