class Depart {
String name;
}
class Pc {
	Pc(){}
	Pc(Long id, String name) {
		this.id = id; this.name = name;
	}
	Long id; String name;
}
var pc = new Pc(1L, "pc 1");
pc.name
var pcs = Arrays.asList(new Pc(1L, "PC1"), new Pc(2L, "PC2"));
pcs
pcs.getClass()
pcs.getClass().getName()
System.out.println(pcs.getClass().getName());
